package com.travles.travel.service;

import com.travles.travel.entity.User;

public interface UserService {
	/**
	 * 注册用户
	 * @param user
	 */
	void register(User user);
	/**
	 * 用户登录功能
	 * @param user
	 */
	User login(User user);
}
