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
<#macro textarea label name required=false>
<td colspan="2">
    <label>${label}：</label>
    <textarea name="${name}" cols="" rows="" class="w537"></textarea><#if required><span class="red">*</span></#if>
    <div class="col_cv_alt" data-error="${name}"></div>
</td>
</#macro>

<#-- 时间控件 -->
<#macro date label name required=false>
<td>
    <label>${label}：</label>
    <input type="text"  name="${name}" placeholder="请输入${label}" class="form_datetime"><#if required><span class="red">*</span></#if>
    <div class="col_cv_alt" data-error="${name}"></div>
</td>
</#macro>

<#-- select标签 -->
<#macro select label name dict=name required=false>
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
</#macro>

<#-- radio标签 -->
<#macro radio label name required=false>
<td>
    <label style="width:200px;">${label}：</label>
    <input type="radio" name="${name}" value="true">是
    <input type="radio" name="${name}" value="false">否
</td>
</#macro>

<#-- 文本 -->
<#macro span label name attr translate=false wide=false>
<td <#if wide>colspan="2"</#if>>
    <label <#if attr??>${attr}</#if>>${label}：</label>
    <span data-name="${name}" <#if translate>data-value="%{${name}}">%{t.${name}}</span><#else>>%{${name}}</span></#if>
</td>
</#macro>
