package com.ssm.qind.dao;

import com.ssm.qind.bean.GroupTitle;
import com.ssm.qind.bean.TitleGroup;

/**
 * 标题数据库处理类
 * 
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
public interface ITitleDao {

	/**
	 * 添加话题组标题
	 * 
	 * @param GroupTitle groupTitle 标题
	 * @author QinDong
	 * @return
	 */
	public void addGroupTitle(GroupTitle groupTitle);
	
	/**
	 * 清理话题组标题
	 * 
	 * @param
	 * @author QinDong
	 * @return
	 */
	public void clearGroupTitle();
	
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
