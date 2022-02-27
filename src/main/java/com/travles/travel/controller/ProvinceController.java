package com.travles.travel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travles.travel.entity.Province;
import com.travles.travel.entity.Result;
import com.travles.travel.service.ProvinceService;

@RestController
@CrossOrigin
@RequestMapping(value = "province")
public class ProvinceController {
	@Autowired
	private ProvinceService provinceService;
	/**
	 * 分页查询省份
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping(value = "findByPage")
	public Map<String, Object> findByPage(int page,int size){
		Map<String, Object> provinceMap=new HashMap<String, Object>();
		List<Province> provinces=provinceService.findProviceByPage(page, size);
		int totalNum=provinceService.findTotalProvince();
		int totalPage=(int) Math.ceil((double)totalNum/size);
		provinceMap.put("provinceList", provinces);
		provinceMap.put("totalNum", totalNum);
		provinceMap.put("totalPage", totalPage);
		return provinceMap;
	}
	@RequestMapping(value = "insertProvince")
	public Result insertProvince(@RequestBody Province province) {
		Result result=new Result();
		try {
			provinceService.insertProvince(province);
			result.setStatus(true);
			result.setMsg("添加省份信息成功！");
		} catch (Exception e) {
			result.setStatus(false);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping(value = "deleteProvince")
	public Result deleteProvince(String id) {
		Result result=new Result();
		try {
			provinceService.deleteProvince(id);
			result.setStatus(true);
			result.setMsg("删除省份信息成功！");
		} catch (Exception e) {
			result.setStatus(false);
			result.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
	@RequestMapping(value = "selectProvinceById")
	public Province selectProvinceById(String id) {
		Province province=provinceService.selectProvinceById(id);
		return province;
	}
	@RequestMapping(value = "updateProvince")
	public Result updateProvince(@RequestBody Province province) {
		Result result=new Result();
		try {
			provinceService.updateProvinceById(province);
			result.setStatus(true);
			result.setMsg("修改省份信息成功！");
		} catch (Exception e) {
			result.setStatus(false);
			result.setMsg("修改省份信息失败！");
			e.printStackTrace();
		}
		return result;
	}
}
