package cn.aki.entity.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 带时间戳的实体
 *
 * @author aki
 * 2016年4月22日 上午9:49:31
 */
@EqualsAndHashCode(callSuper = true)
@Data
public abstract class BaseTimeEntity extends BaseEntity {
    private Date createTime;    //,create_time datetime -- 创建时间
    private Date modifyTime;    //,modify_time datetime -- 修改时间
}
