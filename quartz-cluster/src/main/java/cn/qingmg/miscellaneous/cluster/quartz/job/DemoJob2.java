package cn.qingmg.miscellaneous.cluster.quartz.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * 默认并行
 * 如果需要实现串行, 可在类上增加注解 @DisallowConcurrentExecution
 * 并行: 即任务1在未执行完的情况下，下个应该执行的任务1将会直接加载
 * 串行: 即任务1在未执行完的情况下，下个应该执行的任务1将会延迟加载
 */
/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/10/4 14:52
 * @Version 1.0
 */
@Component
public class DemoJob2 extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(System.currentTimeMillis() + ": This is DemoJob2!!!");
    }
}
