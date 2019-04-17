package cn.qingmg.miscellaneous.shiro.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_user")
public class SysUser implements Serializable {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 状态 0 正常 1 冻结
     */
    private Integer status;

    /**
     * 锁定状态 0 未锁定 1 锁定
     */
    @Column(name = "lock_status")
    private Integer lockStatus;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键ID
     *
     * @return user_id - 主键ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置主键ID
     *
     * @param userId 主键ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取账号
     *
     * @return username - 账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置账号
     *
     * @param username 账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 获取状态 0 正常 1 冻结
     *
     * @return status - 状态 0 正常 1 冻结
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0 正常 1 冻结
     *
     * @param status 状态 0 正常 1 冻结
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取锁定状态 0 未锁定 1 锁定
     *
     * @return lock_status - 锁定状态 0 未锁定 1 锁定
     */
    public Integer getLockStatus() {
        return lockStatus;
    }

    /**
     * 设置锁定状态 0 未锁定 1 锁定
     *
     * @param lockStatus 锁定状态 0 未锁定 1 锁定
     */
    public void setLockStatus(Integer lockStatus) {
        this.lockStatus = lockStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nickName=").append(nickName);
        sb.append(", realName=").append(realName);
        sb.append(", status=").append(status);
        sb.append(", lockStatus=").append(lockStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}