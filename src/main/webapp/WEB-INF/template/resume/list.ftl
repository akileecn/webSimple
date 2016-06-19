<@bootstrap.head>
<title>我的简历</title>
</@bootstrap.head>
<@bootstrap.body attr="id='user_center'">
<div class="container">
	<#include "user/left.ftl"/>
	<@c.right title="我的简历">
    <div class="col_cv_main">
        <img class="fl" src="<@c.resource "images/pe.png"/>" width="60" height="60" style="margin: 12px 0 0 10px;">
        <div class="col_cv fr">
            <ul class="col_cv_title">
                <li><b>简历类型</b></li>
                <li><b>状态</b></li>
                <li><b>操作</b></li>
            </ul>
        	<#list list as resume>
        		<#if resume.recruitType=="society">
            <ul class="col_cv_title" style="margin-top: -10px;">
                <li class="col_cv_btn"><p>社招简历</p></li>
                <li class="col_cv_btn"><a href="javascript:void(0);" 
					<#if resume.isLocked>class="yes">已锁定
					<#elseif resume.isSubmit>class="yes">已提交
					<#else>class="no">未提交</#if></li>
                <li class="col_cv_btn"><a href="<@spring.url "/resume/detail?id="+resume.id+"&recruitType="+resume.recruitType />">编辑查看</a></li>
            </ul>
    			<#else>
            <ul class="col_cv_title" style="margin-top: -10px;">
                <li class="col_cv_btn"><p>校招简历</p></li>
                <li class="col_cv_btn"><a href="javascript:void(0);" 
					<#if resume.isLocked>class="yes">已锁定
					<#elseif resume.isSubmit>class="yes">已提交
					<#else>class="no">未提交</#if></li>
                <li class="col_cv_btn"><a href="<@spring.url "/resume/detail?id="+resume.id+"&recruitType=campus"/>">编辑查看</a></li>
            </ul>
            <ul class="col_cv_title" style="margin-top: -10px;">
                <li class="col_cv_btn"><p>实习生简历</p></li>
                <li class="col_cv_btn"><a href="javascript:void(0);" 
					<#if resume.isLocked>class="yes">已锁定
					<#elseif resume.isSubmit>class="yes">已提交
					<#else>class="no">未提交</#if></li>
                <li class="col_cv_btn"><a href="<@spring.url "/resume/detail?id="+resume.id+"&recruitType=trainee"/>">编辑查看</a></li>
            </ul>
            	</#if>
			</#list>
        </div>
    </div>
	</@c.right>
</div>
<script type="text/javascript" id="templete_div">
</script>
</@bootstrap.body>