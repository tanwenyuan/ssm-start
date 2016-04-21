package com.ssm.qind.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.qind.bean.GroupTitle;
import com.ssm.qind.bean.TitleGroup;
import com.ssm.qind.dao.ITitleDao;
import com.ssm.qind.service.TitleService;

/**
 * 标题实现类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
@Service("titleService")
public class TitleServiceImpl implements TitleService{
	
	private Logger logger  =  Logger.getLogger(TitleServiceImpl.class );
	@Autowired
	private ITitleDao iTitleDao;
	
	public void addGroupTitle(GroupTitle groupTitle) {
		iTitleDao.addGroupTitle(groupTitle);
	}
	public void clearGroupTitle() {
		iTitleDao.clearGroupTitle();
	}
	public void addTitleGroup(TitleGroup titleGroup) {
		iTitleDao.addTitleGroup(titleGroup);
	}
	public void clearTitleGroup() {
		iTitleDao.clearTitleGroup();
	}
	
}
