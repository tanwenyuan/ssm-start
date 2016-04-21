package com.ssm.qind.service;

import com.ssm.qind.bean.GroupTitle;
import com.ssm.qind.bean.TitleGroup;

/**
 * 标题接口类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
public interface TitleService {
	
	/**
	 * 添加话题标题
	 * @param
	 * @author QinDong
	 * @return 
	 */
	public void addGroupTitle (GroupTitle groupTitle);
	
	/**
	 * 清空所有话题标题
	 * @param
	 * @author QinDong
	 * @return 
	 */
	public void clearGroupTitle ();
	
	/**
	 * 添加话题组
	 * 
	 * @param GroupTitle groupTitle 标题
	 * @author QinDong
	 * @return
	 */
	public void addTitleGroup(TitleGroup titleGroup);
	
	/**
	 * 清理话题组
	 * 
	 * @param
	 * @author QinDong
	 * @return
	 */
	public void clearTitleGroup();
}
