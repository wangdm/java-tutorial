package com.wangdm.tutorial.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.wangdm.tutorial.mybatis.dao.UserMapper;
import com.wangdm.tutorial.mybatis.model.User;

public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	public void addUser(User user){
		userMapper.insert(user);
		
	}
	
	public User findById(Integer id){
		return userMapper.selectByPrimaryKey(id);
	}
}
