package cn.aki.entity;

import cn.aki.entity.base.BaseTimeEntity;
import cn.aki.entity.base.UserSub;
import cn.aki.entity.translate.Translatable;
import cn.aki.entity.translate.TranslateTypeCode;
import cn.aki.form.validator.IdNumber;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 简历主表
 *
 * @author aki
 * 2016年4月19日 上午10:28:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Resume extends BaseTimeEntity implements UserSub, Translatable {
    private Integer userId;                //,user_id int not null -- 用户ID
    @NotBlank
    @Size(max = 32)
    private String name;                //,name varchar(32)
    @NotBlank
    @TranslateTypeCode
    private String gender;                //,gender varchar(32)
    @NotNull
    private Date birthday;                //,birthday timestamp
    @NotBlank
    @TranslateTypeCode
    private String nation;                //,nation varchar(32) -- 民族
    @NotNull
    private Integer height;                //,height int
    @NotNull
    private Integer weight;                //,weight int
    private String idType;                //,id_type varchar(32) -- 证件类型
    @NotBlank
    @IdNumber()
    private String idNumber;            //,id_number varchar(32)
    @NotBlank
    @TranslateTypeCode
    private String marriage;            //,marriage varchar(32) -- 婚姻状况
    @TranslateTypeCode
    private String politicsStatus;        //,politics_status varchar(32) -- 政治面貌
    private Date joinPartyDate;            //,join_party_date timestamp -- 入党时间
    @NotBlank
    @Pattern(regexp = "^1\\d{10}$", message = "{v.mobile}")
    private String mobile;                //,mobile varchar(11)
    private String email;                //,email varchar(50)
    @NotBlank
    @TranslateTypeCode
    private String highestEducation;    //,highest_education varchar(32) -- 最高学历
    @TranslateTypeCode("degree")
    private String highestDegree;        //,highest_degree varchar(32) -- 最高学位
    @NotNull
    private Date graduateDate;            //,graduate_date timestamp -- 毕业时间
    private String ceeProvince;            //,cee_province varchar(32) -- 高考省份
    private Integer ceeScore;            //,cee_score int -- 高考分数
    @TranslateTypeCode
    private Boolean isFirstLine;        //,is_first_line tinyint -- 是否一本分数线以上
    @TranslateTypeCode
    private String artsOrScience;        //,arts_or_science varchar(32) -- 文理科
    @TranslateTypeCode
    private String admissionOrder;        //,admission_order varchar(32) -- 录取批次
    private String emergencyContact;    //,emergency_contact varchar(32) -- 紧急联系人
    private String emergencyMobile;        //,emergency_mobile varchar(32) -- 紧急联系人电话
    @Deprecated
    private Integer childrenCount;        //,children_count int -- 子女
    @TranslateTypeCode
    private Boolean isRelativeHere;        //,is_relative_here tinyint -- 是否有亲友受雇与本公司
    @NotBlank
    @Size(max = 100)
    private String currentResidence;    //,current_residence varchar(100) -- 现居住地址
    @NotBlank
    @Size(max = 100)
    private String familyResidence;        //,family_residence varchar(100) -- 家庭住址
    @NotBlank
    @Size(max = 100)
    private String nativePlace;            //,native_place varchar(100) -- 籍贯
    @Deprecated
    private String studentOrigin;        //,student_origin varchar(100) -- 生源地
    @NotBlank
    @Size(max = 100)
    private String registeredResidence;    //,registered_residence varchar(100) -- 户口所在地
    @Size(max = 500)
    private String certificate;            //,certificate varchar(500) -- 持证情况
    @Size(max = 500)
    private String hobby;                //,hobby varchar(500) -- 爱好特长
    @Size(max = 500)
    private String personality;            //,personality varchar(500) -- 性格特点
    @TranslateTypeCode
    private String workYear;//,work_year varchar(32) -- 工作年前
    @Deprecated
    private String workCity;//,work_city varchar(32) -- 期望工作城市
    @Deprecated
    private String health;//,health varchar(32) -- 健康
    private byte[] photo; // 头像

    @NotBlank
    @TranslateTypeCode
    private String recruitType;    //招聘类型
    /*20160614*/
    private Date beginWorkDate;//begin_work_date datetime;-- 参加工作时间
    @NotNull
    private Date beginSchoolDate;//begin_school_date datetime;-- 开始时间
    @Size(max = 100)
    @NotBlank
    private String school;//school nvarchar(100);-- 毕业院校
    @TranslateTypeCode
    private String schoolType;//school_type nvarchar(32);-- 院校类别
    @Size(max = 32)
    @NotBlank
    private String major;//nvarchar(32);-- 专业
    /*20160619*/
    private Boolean isSubmit;//is_submit bit not null default 0; -- 是否提交
    private Boolean isLocked;//is_lock bit not null default 0; -- 是否锁定
    /*20160719*/
    private String ceeYear;//cee_year nvarchar(32); -- 增加高考年份

}
