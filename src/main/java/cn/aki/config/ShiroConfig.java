package cn.aki.config;

import cn.aki.other.AjaxFormAuthenticationFilter;
import cn.aki.other.MyShiroRealm;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/5.
 * shiro
 */
@Configuration
public class ShiroConfig {
	private static final String INDEX = "/index";

	@Bean("securityManager")
	public SecurityManager securityManager(){
		RealmSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(new MyShiroRealm());
		return manager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager,
														 MyProperties properties){
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		bean.setLoginUrl(INDEX);
		bean.setSuccessUrl(INDEX);
		bean.setUnauthorizedUrl(INDEX);
		bean.getFilters().put("authc", new AjaxFormAuthenticationFilter());
		Map<String,String> map = bean.getFilterChainDefinitionMap();
		bean.setFilterChainDefinitionMap(properties.getShiro());
		return bean;
	}

	@Bean("lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
		return new LifecycleBeanPostProcessor();
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
