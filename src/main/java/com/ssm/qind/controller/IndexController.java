package com.ssm.qind.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.qind.base.ModuleConstance;
import com.ssm.qind.base.view.TitleView;
import com.ssm.qind.bean.ScheduleJob;
import com.ssm.qind.component.task.quart.CollectZhihuDataTask;
import com.ssm.qind.service.QuartService;
import com.ssm.qind.util.ContextConfigBeans;

@Controller
@RequestMapping("/index")
public class IndexController {

	private Logger logger  =  Logger.getLogger(IndexController. class );
	//定义当前模块
	private String curSpace = ModuleConstance.indexView;
	
	@RequestMapping("/welcome")
	public String login(HttpServletRequest request, Model model) {

		/*
		QuartService quartService = (QuartService) ContextConfigBeans.getBean("quartService");
		
		ScheduleJob scheduleJob = new ScheduleJob();
		scheduleJob.setJobId("taskJob");
		scheduleJob.setJobGroup("job_work");
		scheduleJob.setJobName("job_work_name");
		scheduleJob.setDesc("");
		scheduleJob.setCronExpression("0 33 10 * * ?");
		scheduleJob.setJobStatus("1");
		
		quartService.updateQuartz(scheduleJob);
		*/
		
		CollectZhihuDataTask.getAllZhihuTitleGroupData();
		
		return curSpace+TitleView.userView;
		
	}

}
