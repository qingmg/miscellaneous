package cn.qingmg.miscellaneous.shiro.service;

import cn.qingmg.miscellaneous.common.service.BaseService;
import cn.qingmg.miscellaneous.shiro.pojo.SysUser;

/**
 * @Description sys_user 服务层
 * @Author vhs
 * @Date 2019-04-16
 * @Version 1.0
 */
public interface SysUserService extends BaseService<SysUser> {

    SysUser queryByUsername(String username);
}
