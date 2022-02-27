package com.travles.travel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travles.travel.dao.UserDao;
import com.travles.travel.entity.User;
import com.travles.travel.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	public void register(User user) {
		if(userDao.findUserByName(user.getUsername())==null) {
			userDao.save(user);
		}else {
			throw new RuntimeException("用户名称已被占用！");
		}
	}

	@Override
	public User login(User user) {
		User userRight=userDao.findUserByName(user.getUsername());
		if(userRight!=null) {
			if(userRight.getPassword().equals(user.getPassword())) {
				return userRight;
			}else {
				throw new RuntimeException("密码错误！");
			}
		}else {
			throw new RuntimeException("用户不存在！");
		}
	}
	
}
