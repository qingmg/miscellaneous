package cn.qingmg.miscellaneous.cluster.quartz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @Description TODO
 * @Author vhs
 * @Date 2018/9/30 10:05
 * @Version 1.0
 */
@Entity
@Table(name = "task_info")
public class TaskInfo {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 任务编码, 使用 UUID.randomUUID().toString()
     */
    private String jobcode;
    /**
     * 任务名称
     */
    private String jobname;
    /**
     * 类名称, 使用 ***.class
     */
    private String jobclass;
    /**
     * 任务描述
     */
    private String jobdesc;
    /**
     * 任务表达式 遵循 CronTriggers 表达式规则
     */
    private String expression;
    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @Column(name = "gmt_modify")
    private Date gmtModify;
    /**
     * 修改原因
     */
    private String reason;
    /**
     * 状态 0 启动 1 暂停 2 作废
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobcode() {
        return jobcode;
    }

    public void setJobcode(String jobcode) {
        this.jobcode = jobcode;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getJobclass() {
        return jobclass;
    }

    public void setJobclass(String jobclass) {
        this.jobclass = jobclass;
    }

    public String getJobdesc() {
        return jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        this.jobdesc = jobdesc;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
