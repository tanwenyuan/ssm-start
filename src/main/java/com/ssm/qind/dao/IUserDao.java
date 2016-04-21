package com.ssm.qind.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.qind.bean.User;

//userMapper只能传入一个参数,多个的话需要注解
public interface IUserDao {

	// value 必须与Bean 属性一致！
	User login(@Param(value = "name") String name,
			@Param(value = "password") String password);

	List<User> getAllUsers();
	
	public void addUser(User user);
	
}
