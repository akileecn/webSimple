package cn.aki.entity;

import lombok.Data;

import java.io.Serializable;
/**
 * 静态页面
 * @author Aki
 * 2016年6月19日 上午11:20:13
 */
@Data
public class StaticPage implements Serializable{
	private static final long serialVersionUID = -5553663739033521081L;
	private Integer id;//id int primary key identity(1,1)
	private String code;//,code nvarchar(32) -- 代码
	private String attr;//,attr nvarchar(32) -- 其他属性
	private String template;//,template nvarchar(100) -- 模版路径
	private String title;//,title nvarchar(100) -- 标题
	private String content;//,content ntext -- 内容
}
