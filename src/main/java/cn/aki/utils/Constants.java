package cn.aki.utils;

public interface Constants {
	/**招聘类型 校招*/
	String RECRUIT_TYPE_CAMPUS="campus";
	/**招聘类型 社招*/
	String RECRUIT_TYPE_SOCIETY="society";
	/**招聘类型 实习生招聘*/
	String RECRUIT_TYPE_TRAINEE="trainee";
	/**静态页 用户协议*/
	String STATIC_PAGE_CODE_USER_AGREEMENT="userAgreement";
	/**静态页 招聘公告*/
	String STATIC_PAGE_CODE_RECRUIT_NOTICE="recruitNotice";
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
}
