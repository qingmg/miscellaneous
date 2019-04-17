package cn.qingmg.miscellaneous.shiro.service.impl;

import cn.qingmg.miscellaneous.common.service.BaseServiceImpl;
import cn.qingmg.miscellaneous.shiro.dao.SysUserMapper;
import cn.qingmg.miscellaneous.shiro.pojo.SysUser;
import cn.qingmg.miscellaneous.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description sys_user 服务实现层
 * @Author vhs
 * @Date 2019-04-16
 * @Version 1.0
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired(required = false)
    SysUserMapper mapper;

    @Override
    public SysUser queryByUsername(String username) {
        return mapper.queryByUsername(username);
    }
}
