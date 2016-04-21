package com.ssm.qind.service.impl;

import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import com.ssm.qind.bean.ScheduleJob;
import com.ssm.qind.component.task.quart.QuartzJobFactory;
import com.ssm.qind.service.QuartService;

/**
 * 标题实现类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
@Service("quartService")
public class QuartServiceImpl implements QuartService{
	
	private Logger logger  =  Logger.getLogger(QuartServiceImpl.class );
	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;
	
	public void updateQuartz(ScheduleJob job) {

		try {
			
			Scheduler scheduler = schedulerFactoryBean.getScheduler();

			if (null != job) {

				// 获取触发器标识
				TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
				// 获取触发器trigger
				CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

				if (null == trigger) {// 不存在任务

					// 创建任务
					JobDetail jobDetail = JobBuilder.newJob(QuartzJobFactory.class)
							.withIdentity(job.getJobName(), job.getJobGroup()).build();
					jobDetail.getJobDataMap().put("scheduleJob", job);
					// 表达式调度构建器
					CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
					// 按新的cronExpression表达式构建一个新的trigger
					trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
							.withSchedule(scheduleBuilder).build();
					scheduler.scheduleJob(jobDetail, trigger);

				} else {// 存在任务
					
					// Trigger已存在，那么更新相应的定时设置
					// 表达式调度构建器
					CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
					// 按新的cronExpression表达式重新构建trigger
					trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder)
							.build();
					// 按新的trigger重新设置job执行
					scheduler.rescheduleJob(triggerKey, trigger);

				}

			}

		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void pauseQuartz(ScheduleJob job) {
		
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
		try {
			scheduler.pauseJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}

	public void resumeQuartz(ScheduleJob job) {
		
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
		try {
			scheduler.resumeJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	public void removeQuartz(ScheduleJob job) {
		
		Scheduler scheduler = schedulerFactoryBean.getScheduler();
		JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
		try {
			scheduler.deleteJob(jobKey);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
