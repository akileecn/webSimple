package cn.aki.utils;

public interface Constants {
    /**
     * 招聘类型 校招
     */
    String RECRUIT_TYPE_CAMPUS = "campus";
    /**
     * 招聘类型 社招
     */
    String RECRUIT_TYPE_SOCIETY = "society";
    /**
     * 招聘类型 实习生招聘
     */
    String RECRUIT_TYPE_TRAINEE = "trainee";
    /**
     * servletContext属性key 字典数据
     */
    String CONTEXT_ATTR_KEY_DICT_MAP = "dictMap";
    /**
     * servletContext属性key 左侧跳转连接的招聘类型
     */
    String CONTEXT_ATTR_KEY_LEFT_RECRUIT_TYPE = "leftRecruitType";
    /**
     * 字典code other
     */
    String DICT_CODE_OTHER = "other";
    /**
     * 字典类型 查询学历要求
     */
    String DICT_TYPE_CODE_SEARCH_EDUCATION = "searchEducation";

    /**
     * shiro会话key
     *
     * @author Aki
     * 2016年8月15日下午3:06:42
     */
    interface SessionKey {
        /**
         * 用户对象
         */
        String USER = "user";
        /**
         * 简历ID
         */
        String RESUME_IDS = "resumeIds";
        /**
         * 图片验证码
         */
        String CAPTCHA = "captcha";
        /**
         * 个人中心类型
         */
        String USER_CENTER_TYPE = "userCenterType";
        /**
         * 短信验证码
         */
        String MESSAGE_CAPTCHA = "messageCaptcha";
    }

    /**
     * 错误代码
     *
     * @author Aki
     * 2016年6月26日 下午7:40:16
     */
    interface ErrorCode {
        /**
         * 未提交简历
         */
        String NOT_SUBMIT = "notSubmit";
        /**
         * 未登录
         */
        String NOT_LOGIN = "notLogin";
    }

    /**
     * 静态页代码
     *
     * @author Aki
     * 2016年6月28日 上午12:12:04
     */
    interface StaticPageCode {
        /**
         * 静态页 用户协议
         */
        String USER_AGREEMENT = "userAgreement";
        /**
         * 静态页 招聘公告
         */
        String RECRUIT_NOTICE = "recruitNotice";
        /**
         * 邮件模版
         */
        String MAIL_TEMPLATE = "mailTemplate";
        /**
         * 短信模版
         */
        String MESSAGE_TEMPLATE = "messageTemplate";
        /**
         * 短信模版_注册
         */
        String MESSAGE_TEMPLATE_ATTR_REGISTER = "register";
        /**
         * 短信模版_修改密码
         */
        String MESSAGE_TEMPLATE_ATTR_UPDATE_PASSWORD = "updatePassword";
        /**
         * 关于
         */
        String ABOUT = "about";
    }
}
