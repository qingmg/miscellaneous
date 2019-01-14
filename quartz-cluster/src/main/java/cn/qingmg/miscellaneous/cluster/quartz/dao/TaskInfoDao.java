package cn.qingmg.miscellaneous.cluster.quartz.dao;

import cn.qingmg.miscellaneous.cluster.quartz.model.TaskInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/10/4 16:33
 * @Version 1.0
 */
public interface TaskInfoDao extends JpaRepository<TaskInfo, Integer> {
}
