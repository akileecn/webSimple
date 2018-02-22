package cn.aki.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author llh
 * Created on 2018/01/29.
 */
@Data
public class LoginVO implements Serializable {
    private String name;
    private Integer noticeCount;
}
