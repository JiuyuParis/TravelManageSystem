package com.travles.travel.dao;

import org.apache.ibatis.annotations.Mapper;

import com.travles.travel.entity.User;

/*
 * 用户Dao
 */
@Mapper
public interface UserDao {
	/**
	 * 注册用户
	 * @param user
	 */
	void save(User user);
	/**
	 * 根据用户名查找用户
	 * @param name
	 * @return
	 */
	User findUserByName(String name);
}
