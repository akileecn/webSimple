<#-- 详情页样式 -->
<#-- input标签 -->
<#macro input label name required=false wide=false>
<td <#if wide>colspan="2"</#if>>
    <label>${label}：</label>
    <input type="text"  name="${name}" placeholder="请输入${label}" <#if wide>class="w537"<#else>class="w185"</#if>><#if required><span class="red">*</span></#if>
    <div class="col_cv_alt" data-error="${name}"></div>
</td>
</#macro>

<#-- textarea标签 -->
<#macro textarea label name attr required=false>
<td colspan="2">
    <label>${label}：</label>
    <textarea name="${name}" <#if attr??>${attr}</#if> cols="" rows="" class="w537"></textarea><#if required><span class="red">*</span></#if>
    <div class="col_cv_alt" data-error="${name}"></div>
</td>
</#macro>

<#-- 时间控件 -->
<#macro year label name required=false>
<@date label=label name=name required=required type="year"/>
</#macro>
<#macro date label name type required=false>
<td>
    <label>${label}：</label>
    <input type="text"  name="${name}" placeholder="请输入${label}" class="form_datetime<#if type??>_${type}</#if> w185"><#if required><span class="red">*</span></#if>
    <div class="col_cv_alt" data-error="${name}"></div>
</td>
</#macro>

<#-- select标签 -->
<#macro select label name type dict=name required=false>
	<#if type??>
		<#if type=="other">
	<td colspan="2" class="selectWithOther">
	    <label>${label}：</label>
	    <select <#if long>class="w537"<#else>class="w185"</#if>>
			<option value="">请选择</option>
			<#if dictMap[dict]?exists >
				<#list dictMap[dict]?keys as key>
			<option value="${key}">${dictMap[dict][key]}</option>
				</#list>
			</#if>
		</select><#if required><span class="red">*</span></#if>
		<input type="text" name="${name}" style="display:none;"/>
	    <div class="col_cv_alt" data-error="${name}"></div>
	</td>
		<#elseif type=="prov">
	<td class="selectCity">
	    <label>${label}：</label>
	    <select class="prov" style="width:185px;"></select><#if required><span class="red">*</span></#if>
		<input type="text" name="${name}" style="display:none;"/>
	    <div class="col_cv_alt" data-error="${name}"></div>
	</td>	
		<#elseif type=="city">
	<td class="selectCity">
	    <label>${label}：</label>
	    <select class="prov"></select> 
		<select class="city" disabled="disabled"></select><#if required><span class="red">*</span></#if>
		<input type="text" name="${name}" style="display:none;"/>
	    <div class="col_cv_alt" data-error="${name}"></div>
	</td>	
		<#elseif type=="dist">
	<td colspan="2" class="selectCity">
	    <label>${label}：</label>
	    <select class="prov"></select> 
		<select class="city" disabled="disabled"></select>
		<select class="dist" disabled="disabled"></select>
		<input type="text" class="more" placeholder="____街道____号" style="display:none;"/>
		<#if required><span class="red">*</span></#if>
		<input type="text" name="${name}" style="display:none;"/>
	    <div class="col_cv_alt" data-error="${name}"></div>
	</td>
		</#if>
	<#else>
	<td>
	    <label>${label}：</label>
	    <select name="${name}" <#if long>class="w537"<#else>class="w185"</#if>>
			<option value="">请选择</option>
		<#if dictMap[dict]?exists >
			<#list dictMap[dict]?keys as key>
			<option value="${key}" <#if key==value>selected="selected"</#if>>${dictMap[dict][key]}</option>
			</#list>
		</#if>
		</select><#if required><span class="red">*</span></#if>
	    <div class="col_cv_alt" data-error="${name}"></div>
	</td>
	</#if>
</#macro>

<#-- radio标签 -->
<#macro radio label name required=false>
<td>
    <label style="width:200px;">${label}：</label>
    <input type="radio" name="${name}" value="true">是
    <input type="radio" name="${name}" value="false">否
    <#if required><span class="red">*</span></#if>
	<div class="col_cv_alt" data-error="${name}"></div>
</td>
</#macro>

<#-- 文本 -->
<#macro span label name attr translate=false wide=false>
<td <#if wide>colspan="2"</#if>>
    <label <#if attr??>${attr}</#if>>${label}：</label>
    <span <#if wide>style="width:500px;float:left;"</#if> data-name="${name}" <#if translate>data-value="%{${name}}">%{t.${name}}</span><#else>>%{${name}}</span></#if>
</td>
</#macro>

<#-- 从属编辑页面 -->
<#macro subpage1 name title required=false>
<div class="col_cv_tab">
    <h4>${title}<#if required><span class="red">*</span></#if></h4>
	<div id="${name}Div"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	        <td colspan="2" style="text-align: center;">
	            <input name="" type="button" value="+添加" class="new fr" onclick="addSub('${name}','input');">
	        </td>
	    </tr>
	</table>
</div>
<script type="text/javascript">
	T.${name}={};
	T.${name}.text='<@compress single_line=true>
		<div class="col_cv_tab">
		    <div class="edit2 fr">
		        <a href="javascript:void(0);" onclick="switchSub(\'${name}\',this);"><img src="<@c.resource "images/icon-1.png"/>" width="18"></a>
		    </div>
		    <div class="del2 fr">
		        <a href="javascript:void(0);" onclick="deleteSub(\'${name}\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
		    </div>
	        <table width="100%" border="0" cellspacing="0" cellpadding="0">
	            <tr><span data-name="id" data-value="%{id}" style="display:none;"/><#nested></tr>
	        </table>
		</div>
	</@compress>';
</#macro>
<#macro subpage2 name>
	T.${name}.input='<@compress single_line=true>
		<div class="col_cv_tab">
			<div class="del2 fr">
		        <a href="javascript:void(0);" onclick="deleteSub(\'${name}\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
		    </div>
		    <table width="100%" border="0" cellspacing="0" cellpadding="0">
		        <tr><input type="hidden" name="id"/><#nested></tr>
		        <tr>
		            <td colspan="2" style="text-align: center;">
		                <input type="reset" value="重置" class="reset">
		                <input type="button" value="保存" class="submit" onclick="saveSub(\'${name}\',this)">
		            </td>
		        </tr>
		    </table>
		</div>
	</@compress>';
</script>
</#macro>
