package cn.qingmg.miscellaneous.shiro.config;

import cn.qingmg.miscellaneous.shiro.pojo.SysUser;
import cn.qingmg.miscellaneous.shiro.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author vhs
 * @Date 2019-04-10
 * @Version 1.0
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService userService;

    /**
     * 用户权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        // 获得用户
//         User user = SecurityUtils.getSubject().getPrincipal();

        /*
         * 角色、权限
         */
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        // 角色 0 管理员 1 普通成员
//        info.setRoles(new HashSet<String>() {{
//            add("1");
//        }});
//        // 权限
//        info.setStringPermissions(new HashSet<String>() {{
//            add("query");
//        }});
//        return info;

        return null;
    }

    /**
     * 用户身份验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        // 获得 用户名、密码
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        String password = token.getPassword() != null ? String.valueOf(token.getPassword()) : null;

        if (!StringUtils.isNotBlank(username)) {
            throw new AccountException("账号为空");
        }
        if (!StringUtils.isNotBlank(password)) {
            throw new AccountException("密码为空");
        }

        SysUser user = userService.queryByUsername(username);
        if (user == null) {
            throw new UnknownAccountException("账号不存在");
        }
        if (!user.getPassword().equals(password)) {
            throw new IncorrectCredentialsException("密码错误");
        }
        if (user.getLockStatus() == 1) {
            throw new LockedAccountException("账号被锁, 请联系管理员");
        }
        if (user.getStatus() == 1) {
            throw new DisabledAccountException("账号被冻结, 请联系管理员");
        }

        return new SimpleAuthenticationInfo(user, password, user.getRealName());
    }
}
