package cn.aki.config;

import cn.aki.other.AjaxFormAuthenticationFilter;
import cn.aki.other.MyShiroRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
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

	private final MyProperties properties;

	public ShiroConfig(MyProperties properties) {
		this.properties = properties;
	}

	@Bean
	public Realm realm() {
		return new MyShiroRealm();
	}

	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		manager.setRealm(realm());
		if(properties.getRedis().getEnable()){
			manager.setSessionManager(sessionManager());
			manager.setCacheManager(cacheManager());
		}
		return manager;
	}

	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager());
		bean.setLoginUrl(INDEX);
		bean.setSuccessUrl(INDEX);
		bean.setUnauthorizedUrl(INDEX);
		bean.getFilters().put("authc", new AjaxFormAuthenticationFilter());
		bean.setFilterChainDefinitionMap(properties.getShiro());
		return bean;
	}

	@Bean
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager());
		return advisor;
	}

	// redis
	@Bean
	public RedisManager redisManager() {
		RedisManager manager = new RedisManager();
		manager.setHost(properties.getRedis().getHost());
		manager.setExpire(30 * 60); // 秒
		return manager;
	}

	@Bean
	public SessionDAO sessionDAO() {
		RedisSessionDAO dao = new RedisSessionDAO();
		dao.setRedisManager(redisManager());
		return dao;
	}

	@Bean
	public SessionManager sessionManager() {
		DefaultWebSessionManager manager = new DefaultWebSessionManager();
		manager.setSessionDAO(sessionDAO());
		return manager;
	}

	@Bean
	public CacheManager cacheManager() {
		RedisCacheManager manager = new RedisCacheManager();
		manager.setRedisManager(redisManager());
		return manager;
	}
}
