package com.ssm.qind.component.task.quart;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.qind.spider.zhihu.title.STitleService;
import com.qind.spider.zhihu.title.impl.STitleServiceImpl;
import com.ssm.qind.bean.GroupTitle;
import com.ssm.qind.bean.SpiderConfigGroup;
import com.ssm.qind.bean.TitleGroup;
import com.ssm.qind.service.SpiderConfigGroupService;
import com.ssm.qind.service.TitleService;
import com.ssm.qind.util.ContextConfigBeans;

/**
 * 收集知乎数据类
 * 
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */

@Component
public class CollectZhihuDataTask {

	// 日志打印属性
	private static Logger logger = Logger.getLogger(CollectZhihuDataTask.class);
	/**
	 * 获取所有知乎相关数据
	 * 
	 * @param
	 * @author QinDong
	 * @return
	 */
	public static void execute() {

		logger.info("--------------------------定时任务开始---------------------");
		getAllZhihuTitleGroupData();
		logger.info("--------------------------定时任务结束---------------------");
		
	}

	/**
	 * 获取所有知乎相关数据
	 * 
	 * @param
	 * @author QinDong
	 * @return
	 */
	public static void getAllZhihuTitleGroupData(){
		
		logger.info("--------------------------获取所有话题数据 开始---------------------");
		SpiderConfigGroupService spiderConfigGroupService = (SpiderConfigGroupService) ContextConfigBeans.getBean("spiderConfigGroupService");
		List<SpiderConfigGroup> allConfigGroup = spiderConfigGroupService.getAllConfigGroup();
		
		logger.info("--------------------------清除所有分组话题数据---------------------");
		TitleService titleService = (TitleService) ContextConfigBeans.getBean("titleService");
		titleService.clearGroupTitle();
		titleService.clearTitleGroup();
		
		for(int i = 0; i<allConfigGroup.size(); i++){
			
			SpiderConfigGroup spiderConfigGroup = allConfigGroup.get(i);
			TitleGroup titleGroup = new TitleGroup();
			titleGroup.setGid(i+1);
			titleGroup.setGroupName(spiderConfigGroup.getGroupName());
			titleService.addTitleGroup(titleGroup);
			getEachZhihuTitleGroupData(titleService,spiderConfigGroup.getGroupUrl(),i+1);
			
		}
		logger.info("--------------------------获取所有话题数据 结束---------------------");
		
	}
	
	/**
	 * 获取所有知乎相关数据
	 * 
	 * @param TitleService titleService 标题接口
	 * @param url 请求地址
	 * @param tid 分组编号
	 * @author QinDong
	 * @return
	 */
	public static void getEachZhihuTitleGroupData(TitleService titleService, String url, Integer tid){
		
		logger.info("--------------------------获取单个话题下所有问题 开始---------------------");
		GroupTitle groupTitle = new GroupTitle();
		
		List<String> toppicTitle = new LinkedList<String>();
		STitleService sTitleService = new STitleServiceImpl();

		List<String> userCareTopic = null;
		for (int i = 1; i < 5; i++) {
			userCareTopic = sTitleService.toppicTitle(url, i);
			if (userCareTopic != null)
				toppicTitle.addAll(userCareTopic);
		}

		for (String title : toppicTitle) {
			groupTitle.setGid(tid);
			groupTitle.setTitle(title);
			titleService.addGroupTitle(groupTitle);
		}

		logger.info("--------------------------获取单个话题下所有问题 结束---------------------");
		
	}
	
}
