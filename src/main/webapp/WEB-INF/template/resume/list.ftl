<@bootstrap.head>
<title>我的简历</title>
</@bootstrap.head>
<@bootstrap.body>
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
            <#list dictMap["recruitType"]?keys as key>
            <ul class="col_cv_title" style="margin-top: -10px;">
                <li class="col_cv_btn">
                    <p>${dictMap["recruitType"][key]}简历</p>
                </li>
                <li class="col_cv_btn"><a href="javascript:void(0);" <#if resume.recruitType==key>class="yes">已提交<#else>class="no">未提交</#if></li>
                <li class="col_cv_btn"><a href="<@spring.url "/resume/detail?id="+resume.id+"&recruitType="+key />">编辑查看</a></li>
            </ul>
            </#list>
        </div>
    </div>
	</@c.right>
</div>
<script type="text/javascript" id="templete_div">
</script>
</@bootstrap.body>