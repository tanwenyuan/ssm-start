package com.ssm.qind.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户对象类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	//用户主键
	private Integer id;
	//用户名称
	private String name;
	//用户密码
	private String password;
	//创建时间
	private String time;

	public User() {
		super();
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public User(Integer id, String name, String password, String time) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.time = time;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", time=" + time + "]";
	}

}
