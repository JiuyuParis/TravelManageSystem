package com.travles.travel.service;

import java.util.List;

import com.travles.travel.entity.Place;

public interface PlaceService {
	List<Place> selectPlacesByPage(int start,int size,String provinceId);
	int provinceTotal(String provinceId);
	int addPlace(Place place);
	int deltePlace(String id);
	Place selectPlaceById(String id);
	int updatePlace(Place place);
}
