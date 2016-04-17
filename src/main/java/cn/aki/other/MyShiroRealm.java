package cn.aki.other;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import cn.aki.dao.UserMapper;
import cn.aki.entity.Permission;
import cn.aki.entity.Role;
import cn.aki.entity.User;

public class MyShiroRealm extends AuthorizingRealm{
	@Autowired
	private UserMapper userMapper;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username=(String)getAvailablePrincipal(principals);
		if(!StringUtils.isEmpty(username)){
			User user=userMapper.getByUsername(username);
			if(user!=null&&user.getRoles()!=null){
				SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
				//角色授权
				for(Role role:user.getRoles()){
					authorizationInfo.addRole(role.getName());
					//权限授权
					if(role.getPermissions()!=null){
						for(Permission permission:role.getPermissions()){
							authorizationInfo.addStringPermission(permission.getName());
						}
					}
				}
				return authorizationInfo;
			}
		}
		return null;
	}
	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username=(String) token.getPrincipal();
		if(!StringUtils.isEmpty(username)){
			User user=userMapper.getByUsername(username);
			if(user!=null&&token.getCredentials()!=null){
				String tokenPassword=new String((char[]) token.getCredentials());
				String password=user.getPassword();
				Md5Hash md5=new Md5Hash(tokenPassword);
				if(password.equals(md5.toString())){
					return new SimpleAuthenticationInfo(username, token.getCredentials(), getName());
				}else{
					throw new IncorrectCredentialsException();
				}
			}else{
				throw new IncorrectCredentialsException();
			}
		}else{
			throw new UnknownAccountException();
		}
	}

}
