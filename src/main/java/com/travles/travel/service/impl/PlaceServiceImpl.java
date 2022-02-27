package com.travles.travel.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travles.travel.dao.PlaceDao;
import com.travles.travel.entity.Place;
import com.travles.travel.entity.Province;
import com.travles.travel.service.PlaceService;
import com.travles.travel.service.ProvinceService;
@Service
@Transactional
public class PlaceServiceImpl implements PlaceService {
	@Autowired
	private PlaceDao placeDao;
	@Autowired
	private ProvinceService provinceService;
	@Value("${upload.dir}")
	private String uploadPath;
	@Override
	public List<Place> selectPlacesByPage(int page, int size, String provinceId) {
		int start=(page-1)*size;
		return placeDao.selectPlacesByPage(start, size, provinceId);
	}
	
	@Override
	public int provinceTotal(String provinceId) {
		return placeDao.provinceTotal(provinceId);
	}

	@Override
	public int addPlace(Place place) {
		//使该省份的景点数加一
		Province province=provinceService.selectProvinceById(place.getProvinceid());
		province.setPlacecounts(province.getPlacecounts()+1);
		provinceService.updateProvinceById(province);
		return placeDao.insert(place);
	}

	@Override
	public int deltePlace(String id) {
		Place place=placeDao.selectById(id);
		Province province=provinceService.selectProvinceById(place.getProvinceid());
		province.setPlacecounts(province.getPlacecounts()-1);
		provinceService.updateProvinceById(province);
		File file=new File(uploadPath+File.separator+place.getPicpath());
		if(file!=null) {
			file.delete();
		}
		return placeDao.delete(id);
	}

	@Override
	public Place selectPlaceById(String id) {
		return placeDao.selectById(id);
	}

	@Override
	public int updatePlace(Place place) {
		int rows =placeDao.update(place);
		return rows;
	}

}
