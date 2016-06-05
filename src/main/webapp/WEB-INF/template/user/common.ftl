<#-- 自定宏 -->
<#macro input label name type="text" wide=false>
<li>
    <label>${label}：</label>
    <input type="${type}" name="${name}" placeholder="请输入${label}" <#if wide>class="w"</#if>><span class="red">*</span>
	<#nested>
    <div class="col_cv_alt" data-error="${name}"></div>
</li>
</#macro>