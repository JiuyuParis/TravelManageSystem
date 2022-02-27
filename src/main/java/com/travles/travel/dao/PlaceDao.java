package com.travles.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.travles.travel.entity.Place;
@Mapper
public interface PlaceDao extends BaseDao<Place, String> {
	List<Place> selectPlacesByPage(@Param("start") int start,@Param("size") int size,@Param("provinceId") String provinceId);
	int provinceTotal(String provinceId);
}
