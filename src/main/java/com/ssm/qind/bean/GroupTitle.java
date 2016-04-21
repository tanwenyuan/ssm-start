package com.ssm.qind.bean;

/**
 * 话题组标题对象类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
public class GroupTitle {
	
	private static final long serialVersionUID = 1L;
	//标题主键
	private Integer tid;
	//标题分组外键
	private Integer gid;
	//标题名称
	private String title;
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
