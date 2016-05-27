<#-- 资源链接 -->
<#macro resource relativeUrl>
	<@spring.url "/resources/"+relativeUrl />
</#macro>
<#-- select标签 -->
<#macro select label name value lableAttr selectAttr dict=name>
<#if label??><label <#if lableAttr??>${lableAttr}</#if>>${label}:</label></#if>
    <select name="${name}" <#if selectAttr??>${selectAttr}</#if>>
		<option value="">请选择</option>
	<#if dictMap[dict]?exists >
		<#list dictMap[dict]?keys as key>
		<option value="${key}" <#if key==value>selected="selected"</#if>>${dictMap[dict][key]}</option>
		</#list>
	</#if>
	</select>
</#macro>

<#-- 右侧内容 -->
<#macro rightTitle title>
<h3>${title}</h3>
<div class="col_more fr">
	<a href="<@spring.url "/index"/>">首页</a> - <a href="javascript:void(0);">${title}</a> - <a href="javascript:void(0);"><span >更多 &nbsp;<img src="<@c.resource "images/arrow1.png"/>" alt=""/></span></a>
</div>   
</#macro>
<#macro right title>
<div class='col-xs-9 padding-l  padding-t'>
    <div class="box_3">
        <div class="box_4 minheight">
            <@rightTitle title=title/>  
			<#nested>
    	</div>
    </div>
</div>
<div class="clearfix"></div>
</#macro>