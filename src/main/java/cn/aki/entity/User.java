package cn.aki.entity;

import cn.aki.entity.base.BaseTimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * 用户
 *
 * @author aki
 * 2016年4月1日 上午9:25:56
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends BaseTimeEntity {
    private String username;    //,username varchar(32) -- 暂时不需要
    private String password;    //,password varchar(32) not null
    private String idNumber;    //,id_number varchar(32) -- 身份证号码
    private String mobile;        //,mobile varchar(32) -- 手机号码
    private String email;        //,email varchar(50) -- 邮箱
    @Deprecated
    private String question;    //,question varchar(100) -- 问题
    @Deprecated
    private String answer;        //,answer varchar(100) -- 答案
    private String name;        //姓名s

    /*关联*/
    private Set<Role> roles;

}
