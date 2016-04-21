package com.ssm.qind.controller;


import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qind.spider.zhihu.title.STitleService;
import com.qind.spider.zhihu.title.impl.STitleServiceImpl;
import com.ssm.qind.base.ModuleConstance;
import com.ssm.qind.base.view.PublicView;
import com.ssm.qind.bean.GroupTitle;
import com.ssm.qind.dao.ITitleDao;
import com.ssm.qind.service.TitleService;

@Controller
@RequestMapping("/title")
public class TitleController {

	private Logger logger  =  Logger.getLogger(TitleController. class );
	@Autowired
	private ITitleDao iTitleDao;
	@Autowired
	private TitleService titleService;
	//定义当前模块
	private String curSpace = ModuleConstance.indexView;
	//定义公共模块
	private String publicSpace = ModuleConstance.publicView;
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request, Model model) {
		
		titleService.clearGroupTitle();
		
		GroupTitle groupTitle = new GroupTitle();
		
		List<String> toppicTitle = new LinkedList<String>();
		STitleService sTitleService = new STitleServiceImpl();
		
		String url = "https://www.zhihu.com/topic/19629329/top-answers?page=";
		List<String> userCareTopic = null;
		for(int i=1; i<11; i++){
			userCareTopic = sTitleService.toppicTitle(url ,i);
			if(userCareTopic != null)
				toppicTitle.addAll(userCareTopic);
		}	
		
		logger.info("所有toppicTitle="+toppicTitle);
		
		for(String title:toppicTitle){
			groupTitle.setGid(1);
			groupTitle.setTitle(title);
			//iTitleDao.addGroupTitle(groupTitle);
			titleService.addGroupTitle(groupTitle);
		}
		
		return publicSpace+PublicView.successView;
		
	}

}
