package com.travles.travel.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.travles.travel.entity.Place;
import com.travles.travel.entity.Result;
import com.travles.travel.service.PlaceService;

@RestController
@CrossOrigin
@RequestMapping(value = "place")
public class PlaceController {
	@Autowired
	private PlaceService placeService;
	@Value("${upload.dir}")
	private String uploadPath;
	/**
	 * 分页查询景点
	 * @param page
	 * @param size
	 * @param provinceId
	 * @return
	 */
	@RequestMapping(value="selectProvinceByPage")
	public Map<String, Object> selectProvinceByPage(int page,int size,String provinceId){
		Map<String, Object> resultMap=new HashMap<String, Object>();
		List<Place> places=placeService.selectPlacesByPage(page, size,provinceId);
		int total=placeService.provinceTotal(provinceId);
		resultMap.put("places", places);
		resultMap.put("total", total);
		resultMap.put("page", page);
		int pageTotal=(int) Math.ceil((double)total/size);
		resultMap.put("pageTotal", pageTotal);
		return resultMap;
	}
	/**
	 * 添加景点
	 * @param picFile
	 * @param place
	 * @return
	 */
	@RequestMapping(value="addPlace")
	public Result addPlace(MultipartFile picFile,Place place) {
		System.out.println(picFile.getOriginalFilename());
		Result result=new Result();
		try {
			//文件上传
			String extension = FilenameUtils.getExtension(picFile.getOriginalFilename());//获得文件扩展名
			String newFilename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +"."+extension;//设置新文件名
//			place.setPicpath(Base64Utils.encodeToString(picFile.getBytes()));//进行64为编码处理,直接把图片以编码后存进数据库，不太好
//			System.out.println("data:image/jpg;base64,"+place.getPicpath());//解码图片);
			place.setPicpath(newFilename);
			File file = new File(uploadPath);
			picFile.transferTo(new File(file, newFilename));//文件上传
			placeService.addPlace(place);//添加景点信息
			result.setStatus(true);
			result.setMsg("添加景点信息信息成功");
		} catch (Exception e) {
			result.setStatus(false);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 删除景点
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deletePlace")
	public Result deletePlace(String id) {
		Result result=new Result();
		try {
			placeService.deltePlace(id);
			result.setStatus(true);
			result.setMsg("删除景点信息成功！");
		} catch (Exception e) {
			result.setMsg(e.getMessage());
			e.printStackTrace();
			result.setStatus(false);
		}
		return result;
	}
	@RequestMapping(value = "selectPlaceById")
	public Place selectPlaceById(String id) {
		return placeService.selectPlaceById(id);
	}
	
	@RequestMapping(value="updatePlace")
	public Result updatePlace(MultipartFile picFile,Place place) {
		Result result=new Result();
		try {
			if(picFile!=null) {
				System.out.println(picFile.getOriginalFilename());
				//文件上传
				String extension = FilenameUtils.getExtension(picFile.getOriginalFilename());//获得文件扩展名
				String newFilename = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) +"."+extension;//设置新文件名
	//			place.setPicpath(Base64Utils.encodeToString(picFile.getBytes()));//进行64为编码处理,直接把图片以编码后存进数据库，不太好
	//			System.out.println("data:image/jpg;base64,"+place.getPicpath());//解码图片);
				place.setPicpath(newFilename);
				File file = new File(uploadPath);
				picFile.transferTo(new File(file, newFilename));//文件上传
			}
			placeService.updatePlace(place);//修改景点信息
			result.setStatus(true);
			result.setMsg("修改景点信息信息成功");
		} catch (Exception e) {
			if(e.getMessage().contains("maximum permitted size")) {
				result.setMsg("文件大小超出1MB");
			}
			result.setMsg(e.getMessage());
			result.setStatus(false);
			e.printStackTrace();
		}
		return result;
	}
}
