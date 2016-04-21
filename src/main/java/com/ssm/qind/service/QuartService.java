package com.ssm.qind.service;

import com.ssm.qind.bean.ScheduleJob;

/**
 * 定时任务接口类
 * @author QinDong
 * @version 1.1, 2015/12/29
 * 
 */
public interface QuartService {
	
	/**
	 * 添加/更新定时任务
	 * @param ScheduleJob job 定时任务对象
	 * @author QinDong
	 * @return 
	 */
	public void updateQuartz (ScheduleJob job);
	
	/**
	 * 暂停定时任务
	 * @param ScheduleJob job 定时任务对象
	 * @author QinDong
	 * @return 
	 */
	public void pauseQuartz (ScheduleJob job);
	
	/**
	 * 恢复定时任务
	 * @param ScheduleJob job 定时任务对象
	 * @author QinDong
	 * @return 
	 */
	public void resumeQuartz (ScheduleJob job);
	
	/**
	 * 删除定时任务
	 * @param ScheduleJob job 定时任务对象
	 * @author QinDong
	 * @return 
	 */
	public void removeQuartz (ScheduleJob job);
	
}
