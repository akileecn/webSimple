package cn.aki.config;

import cn.aki.other.AjaxFormAuthenticationFilter;
import cn.aki.other.MyShiroRealm;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * Created by Administrator on 2017/7/5.
 * shiro
 */
@Configuration
public class ShiroConfig {
	private static final String INDEX = "/index";

	@Autowired
	private MyProperties properties;

	@Bean("myShiroRealm")
	public Realm myShiroRealm(){
		return new MyShiroRealm();
	}

	@Bean("securityManager")
	public SecurityManager securityManager(@Qualifier("myShiroRealm")Realm realm){
		RealmSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(realm);
		return manager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager){
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		bean.setLoginUrl(INDEX);
		bean.setSuccessUrl(INDEX);
		bean.setUnauthorizedUrl(INDEX);
		bean.getFilters().put("authc", new AjaxFormAuthenticationFilter());
		bean.setFilterChainDefinitionMap(properties.getShiro());
		return bean;
	}

	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		return new DefaultAdvisorAutoProxyCreator();
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager){
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
}
