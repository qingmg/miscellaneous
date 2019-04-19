package cn.qingmg.miscellaneous.shiro.mapper;

import cn.qingmg.miscellaneous.common.entity.Criteria;
import cn.qingmg.miscellaneous.shiro.pojo.SysUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysUserMapper extends Mapper<SysUser> {

    List<SysUser> query2List(Criteria criteria);

    SysUser query2OneRecord(Criteria criteria);
}