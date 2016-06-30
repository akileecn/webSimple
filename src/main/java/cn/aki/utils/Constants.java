package cn.aki.utils;

public interface Constants {
	/**招聘类型 校招*/
	String RECRUIT_TYPE_CAMPUS="campus";
	/**招聘类型 社招*/
	String RECRUIT_TYPE_SOCIETY="society";
	/**招聘类型 实习生招聘*/
	String RECRUIT_TYPE_TRAINEE="trainee";
	/**servletContext属性key 字典数据*/
	String CONTEXT_ATTR_KEY_DICT_MAP="dictMap";
	/** servletContext属性key 左侧跳转连接的招聘类型*/
	String CONTEXT_ATTR_KEY_LEFT_RECRUIT_TYPE="leftRecruitType";
	/**shiro会话key 用户对象*/
	String SHIRO_SESSION_KEY_USER="user";
	/**shiro会话key 简历ID*/
	String SHIRO_SESSION_KEY_RESUME_IDS="resumeIds";
	/**shiro会话key 图片验证码*/
	String SHIRO_SESSION_KEY_CAPTCHA="captcha";
	/**shiro会话key 个人中心类型*/
	String SHIRO_SESSION_KEY_USER_CENTER_TYPE="userCenterType";
	/**字典code other*/
	String DICT_CODE_OTHER="other";
	/**字典类型 查询学历要求*/
	String DICT_TYPE_CODE_SEARCH_EDUCATION="searchEducation";
	/**
	 * 错误代码
	 * @author Aki
	 * 2016年6月26日 下午7:40:16
	 */
	public interface ErrorCode{
		/**未提交简历*/
		String NOT_SUBMIT="notSubmit";
		/**未登录*/
		String NOT_LOGIN="notLogin";
	}
	/**
	 * 静态页代码
	 * @author Aki
	 * 2016年6月28日 上午12:12:04
	 */
	public interface StaticPageCode{
		/**静态页 用户协议*/
		String USER_AGREEMENT="userAgreement";
		/**静态页 招聘公告*/
		String RECRUIT_NOTICE="recruitNotice";
		/**邮件模版*/
		String MAIL_TEMPLATE="mailTemplate";
	}
}
