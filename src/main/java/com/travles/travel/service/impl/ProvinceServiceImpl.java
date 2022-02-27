package com.travles.travel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travles.travel.dao.ProvinceDao;
import com.travles.travel.entity.Province;
import com.travles.travel.service.ProvinceService;
@Service
public class ProvinceServiceImpl implements ProvinceService{
	@Autowired
	private ProvinceDao provinceDao;
	@Override
	public List<Province> findProviceByPage(int page, int size) {
		int start=(page-1)*size;
		List<Province> provinces = provinceDao.findByPage(start, size);
		
		return provinces;
	}

	@Override
	public int findTotalProvince() {
		return provinceDao.findTotal();
	}

	@Override
	public int insertProvince(Province province) {
		province.setPlacecounts(0);
		int rows=provinceDao.insert(province);
		return rows;
	}

	@Override
	public int deleteProvince(String id) {
		int rows=provinceDao.delete(id);
		return rows;
	}

	@Override
	public Province selectProvinceById(String id) {
		return provinceDao.selectById(id);
	}
	@Override
	public int updateProvinceById(Province province) {
		int rows=provinceDao.update(province);
		return rows;
	}
}
