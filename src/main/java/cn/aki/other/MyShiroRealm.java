package cn.aki.other;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import cn.aki.dao.NoticeMapper;
import cn.aki.dao.ResumeMapper;
import cn.aki.dao.UserMapper;
import cn.aki.entity.Permission;
import cn.aki.entity.Role;
import cn.aki.entity.User;
import cn.aki.utils.Md5Utils;
import cn.aki.utils.UserUtils;

public class MyShiroRealm extends AuthorizingRealm{
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ResumeMapper resumeMapper;
	@Autowired
	private NoticeMapper noticeMapper;
	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username=(String)getAvailablePrincipal(principals);
		if(!StringUtils.isEmpty(username)){
			User user=userMapper.getAuthByUsername(username);
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
				if(Md5Utils.isEncrypted(tokenPassword, password)){
					AuthenticationInfo info=new SimpleAuthenticationInfo(username, token.getCredentials(), getName());
					//添加额外用户信息
					Subject subject=SecurityUtils.getSubject();
					Session session=subject.getSession();
					session.setAttribute(UserUtils.SHIRO_SESSION_KEY_USER, user);
					//简历信息
					List<Integer> resumeIds=resumeMapper.getIdByUserId(user.getId());
					session.setAttribute(UserUtils.SHIRO_SESSION_KEY_RESUME_IDS, resumeIds);
					//通知信息
					Integer count=noticeMapper.getCountByUserId(user.getId());
					user.setNoticeCount(count);
					return info;
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
