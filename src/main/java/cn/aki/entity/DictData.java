package cn.aki.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 字典数据
 *
 * @author aki
 * 2016年4月15日 下午5:07:40
 */
@Data
public class DictData implements Serializable {
    private Integer id;
    private String typeCode;
    private String code;
    private String name;
    private String remark;
    private Boolean disabled;
    private Date createTime;
    private Date modifyTime;
    private Integer orderby;//orderby int default 0;
}
