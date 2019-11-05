package cn.net.szwx.sell.security.shiro;

import cn.net.szwx.sell.common.Constants;
import cn.net.szwx.sell.entity.system.user.Employee;
import cn.net.szwx.sell.entity.system.user.EmployeeSO;
import cn.net.szwx.sell.service.system.user.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.bouncycastle.openssl.PasswordException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeShiroDbRealm extends AuthorizingRealm {
    @Autowired
    private EmployeeService employeeService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String password = new String(token.getPassword());

        if (StringUtils.isBlank(token.getUsername())) {
            throw new AccountException("用户名为空。");
        }

        if (StringUtils.isBlank(password)) {
            throw new AccountException("密码为空。");
        }

        EmployeeSO employeeSO = new EmployeeSO();
        employeeSO.setUsername(token.getUsername());

        List<Employee> list = employeeService.list(employeeSO);

        Employee employee = null;
        if (null != list && list.size() > 0) {
            employee = list.get(0);
            if (employee.getPassword().equals(password)) {
                if (employee.getLockState().equals(Constants.YES)) {
                    throw new LockedAccountException("用户已经被锁定");
                }
            } else {
                throw new IncorrectCredentialsException("输入的登录密码不正确");
            }
        } else {
            throw new UnknownAccountException("输入的用户名不正确");
        }

        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(employee.getUsername(), employee.getPassword(), getName());
        return sai;
    }
}
