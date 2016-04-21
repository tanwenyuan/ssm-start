package com.ssm.qind.bean;

/**
 * 爬取数据分组对象类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
public class SpiderConfigGroup {
	
	private static final long serialVersionUID = 1L;
	//分组主键
	private Integer cgid;
	//分组名称
	private String groupName;
	//分组链接
	private String groupUrl;
	
	public Integer getCgid() {
		return cgid;
	}
	public void setCgid(Integer cgid) {
		this.cgid = cgid;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupUrl() {
		return groupUrl;
	}
	public void setGroupUrl(String groupUrl) {
		this.groupUrl = groupUrl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
