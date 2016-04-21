package com.ssm.qind.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.qind.bean.SpiderConfigGroup;
import com.ssm.qind.dao.ISpiderConfigGroupDao;
import com.ssm.qind.service.SpiderConfigGroupService;


/**
 * 爬虫配置数据接口实现类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
@Service("spiderConfigGroupService")
public class SpiderConfigGroupServiceImpl implements SpiderConfigGroupService{
	
	private Logger logger  =  Logger.getLogger(SpiderConfigGroupServiceImpl.class );
	@Autowired
	private ISpiderConfigGroupDao iSpiderConfigGroupDao;
	
	public List<SpiderConfigGroup> getAllConfigGroup() {
		// TODO Auto-generated method stub
		return iSpiderConfigGroupDao.getAllConfigGroup();
		
	}
	
}
