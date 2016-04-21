package com.ssm.qind.bean;

/**
 * 标题话题组对象类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
public class TitleGroup {
	
	private static final long serialVersionUID = 1L;
	//标题分组外键
	private Integer gid;
	//标题名称
	private String groupName;
	
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
