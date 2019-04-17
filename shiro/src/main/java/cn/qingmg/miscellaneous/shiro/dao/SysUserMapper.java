package cn.qingmg.miscellaneous.shiro.dao;

import cn.qingmg.miscellaneous.shiro.pojo.SysUser;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends Mapper<SysUser> {

    SysUser queryByUsername(String username);
}