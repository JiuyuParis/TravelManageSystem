package com.travles.travel.service;

import java.util.List;

import com.travles.travel.entity.Province;

public interface ProvinceService {
	/**
	 * 分页查询省份
	 * @param page
	 * @param size
	 * @return
	 */
	List<Province> findProviceByPage(int page,int size);
	/**
	 * 查询省份总数
	 * @return
	 */
	int findTotalProvince();
	/**
	 * 添加省份信息
	 * @param province
	 * @return
	 */
	int insertProvince(Province province);
	/**
	 * 删除省份信息
	 * @param id
	 * @return
	 */
	int deleteProvince(String id);
	/**
	 * 根据id查询省份信息
	 * @param id
	 * @return
	 */
	Province selectProvinceById(String id);
	/**
	 * 修改省份信息
	 * @param province
	 * @return
	 */
	int updateProvinceById(Province province);
}
