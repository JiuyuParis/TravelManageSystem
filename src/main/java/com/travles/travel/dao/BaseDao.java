package com.travles.travel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface BaseDao<O,K> {
	public int insert(O object);
	public int delete(K id);
	public int update(O object);
	public O selectById(K k);
	public List<O> findByPage(@Param("start") int start,@Param("size") int size);
	public int findTotal();
}
