package com.kevin.examples.shiro.Realm;

import com.kevin.examples.entity.User;
import com.kevin.examples.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by Administrator on 11/16/2016.
 */
@Slf4j
public class JpaRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    public JpaRealm() {

        System.out.printf("init");
    }

    public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        String username = (String) getAvailablePrincipal(principals);

        return current().getAuthorizationInfo(username);
    }

    @Cacheable(value = "authorizationInfoCache")
    public SimpleAuthorizationInfo getAuthorizationInfo(String username) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(userService.getRoleStringsByUserName(username));
        info.setStringPermissions(userService.getPermissionStringsByUserName(username));

        return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username = upToken.getUsername();
        User user;

        // Null username is invalid
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        try {
            user = userService.findByName(username);
        } catch (Exception e) {
            final String message = "There was a SQL error while authenticating user [" + username + "]";

            if (log.isErrorEnabled()) {
                log.error(message, e);
            }

            // Rethrow any SQL errors as an authentication exception
            throw new AuthenticationException(message, e);
        }

        if (null == user) {
            throw new UnknownAccountException("No account found for user [" + username + "]");
        }

        return new SimpleAuthenticationInfo(username, user.getPassword(), getName());
    }

    private JpaRealm current(){
        if(null != AopContext.currentProxy()){
            return (JpaRealm)AopContext.currentProxy();
        }else{
            return this;
        }
    }
}
