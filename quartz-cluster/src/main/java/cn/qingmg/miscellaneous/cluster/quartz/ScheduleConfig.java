package cn.qingmg.miscellaneous.cluster.quartz;

import cn.qingmg.miscellaneous.cluster.quartz.dao.TaskInfoDao;
import cn.qingmg.miscellaneous.cluster.quartz.model.TaskInfo;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/9/30 10:02
 * @Version 1.0
 */
@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Autowired
    @Qualifier("schedulerFactoryBean")
    private Scheduler scheduler;

    @Autowired
    private TaskInfoDao taskInfoDao;

    /**
     * 状态说明：
     * 数据库：
     * 0：启动
     * 1：暂停
     * 2：作废
     * 任务：
     * BLOCKED 4 阻塞
     * COMPLETE 2 完成
     * ERROR 3 错误
     * NONE -1 不存在
     * NORMAL 0 正常
     * PAUSED 1 暂停
     */
    /**
     * fixedRate: 每隔10s查库，并根据查询结果决定是否重新设置定时任务
     */
    @Scheduled(fixedRate = 10 * 1000)
    public void scheduled() {
        List<TaskInfo> list = taskInfoDao.findAll();
        for (TaskInfo task : list) {
            try {
                JobKey jobKey = JobKey.jobKey(task.getJobcode(), task.getJobclass());
                TriggerKey triggerKey = TriggerKey.triggerKey(task.getJobcode(), task.getJobclass());

                if (scheduler.checkExists(jobKey)) {
                    // Trigger 的状态
                    Trigger.TriggerState state = scheduler.getTriggerState(triggerKey);

                    if (task.getStatus() == 0) {
                        // 获得 Cron 表达式
                        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                        String cronExpression = trigger.getCronExpression();

                        if ("NORMAL".equals(state.toString())) {
                            if (!cronExpression.equals(task.getExpression())) {
                                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(task.getExpression());
                                // 按新的 Cron 表达式重新构建 Trigger
                                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
                                // 按新的 Trigger 重新设置 Job 执行
                                scheduler.rescheduleJob(triggerKey, trigger);
                            }
                        } else if ("PAUSED".equals(state.toString())) {
                            if (!cronExpression.equals(task.getExpression())) {
                                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(task.getExpression());
                                // 按新的 Cron 表达式重新构建 Trigger
                                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(cronScheduleBuilder).build();
                                // 按新的 Trigger 重新设置 Job 执行
                                scheduler.rescheduleJob(triggerKey, trigger);
                            }
                            scheduler.resumeJob(jobKey);
                        } else {
                            scheduler.deleteJob(jobKey);
                            beginNewJob(task.getJobclass(), task.getExpression(), jobKey, triggerKey);
                        }
                    } else if (task.getStatus() == 1) {
                        scheduler.pauseJob(jobKey);
                    } else {
                        scheduler.deleteJob(jobKey);
                    }
                } else {
                    if (task.getStatus() != 2) {
                        beginNewJob(task.getJobclass(), task.getExpression(), jobKey, triggerKey);

                        if (task.getStatus() == 1) {
                            scheduler.pauseJob(jobKey);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void beginNewJob(String clazzStr, String expression, JobKey jobKey, TriggerKey triggerKey) throws Exception {
        Class clazz = Class.forName(clazzStr);
        JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(jobKey).build();
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(expression);
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }
}
