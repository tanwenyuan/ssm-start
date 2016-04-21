package com.ssm.qind.service;

import java.util.List;

import com.ssm.qind.bean.SpiderConfigGroup;

/**
 * 爬虫配置数据接口类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
public interface SpiderConfigGroupService {
	
	/**
	 * 添加话题标题
	 * @param
	 * @author QinDong
	 * @return 
	 */
	public List<SpiderConfigGroup> getAllConfigGroup ();
	
}
