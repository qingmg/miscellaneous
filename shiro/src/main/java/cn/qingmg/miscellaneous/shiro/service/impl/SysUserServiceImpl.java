package cn.qingmg.miscellaneous.shiro.service.impl;

import cn.qingmg.miscellaneous.common.entity.Criteria;
import cn.qingmg.miscellaneous.common.service.BaseServiceImpl;
import cn.qingmg.miscellaneous.shiro.mapper.SysUserMapper;
import cn.qingmg.miscellaneous.shiro.pojo.SysUser;
import cn.qingmg.miscellaneous.shiro.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description sys_user 服务实现层
 * @Author vhs
 * @Date 2019-04-16
 * @Version 1.0
 */
@Service("sysUserService")
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Override
    public List<SysUser> query2List(Criteria criteria) {
        return super.dao.query2List(criteria);
    }

    @Override
    public SysUser query2OneRecord(Criteria criteria) {
        return super.dao.query2OneRecord(criteria);
    }
}
