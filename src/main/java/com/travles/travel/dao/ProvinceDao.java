package com.travles.travel.dao;

import org.apache.ibatis.annotations.Mapper;

import com.travles.travel.entity.Province;

@Mapper
public interface ProvinceDao extends BaseDao<Province, String>{
}
