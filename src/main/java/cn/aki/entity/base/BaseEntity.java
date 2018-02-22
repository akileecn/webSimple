package cn.aki.entity.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * 实体基类
 *
 * @author aki
 * 2016年4月19日 上午10:27:58
 */
public abstract class BaseEntity implements Serializable {
    @Getter
    @Setter
    protected Integer id;//主键
    protected Map<String, String> translation;

    public void setT(Map<String, String> translation) {
        this.translation = translation;
    }

    public Map<String, String> getT() {
        return translation;
    }

}
