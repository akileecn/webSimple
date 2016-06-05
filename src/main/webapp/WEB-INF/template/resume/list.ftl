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
                <li><b>操作</b></li>
            </ul>
            <#list dictMap["recruitType"]?keys as key>
            <ul class="col_cv_title" style="margin-top: -10px;">
                <li class="col_cv_btn">
                    <p>${dictMap["recruitType"][key]}简历</p>
                </li>
                <li class="col_cv_btn"><a href="<@spring.url "/resume/detail?id="+id+"&recruitType="+key />">编辑查看</a></li>
            </ul>
            </#list>
            <#--
            <ul class="col_cv_title" style="margin-top: -10px;">
                <li class="col_cv_btn">
                    <p>社招简历</p>
                </li>
                <li class="col_cv_btn"><a href="#" class="yes">已提交</a></li>
                <li class="col_cv_btn"><a href="user_detail.html">编辑查看</a></li>
            </ul>
            <ul class="col_cv_title" style="margin-top: -10px;">
                <li class="col_cv_btn">
                    <p>校招简历</p>
                </li>
                <li class="col_cv_btn"><a href="#" class="no">未提交</a></li>
                <li class="col_cv_btn"><a href="user_detail.html">编辑查看</a> <a href="user_print.html">导出简历</a></li>
            </ul>
            <ul class="col_cv_title" style="margin-top: -10px;">
                <li class="col_cv_btn" style="color:#999; width:66%;">
                    <p>您还没有简历哦，赶快去建立吧！</p>
                </li>
                <li class="col_cv_btn"><a href="user_detail_new.html">新建简历</a></li>
            </ul>
            -->
        </div>
    </div>
	</@c.right>
</div>
<script type="text/javascript" id="templete_div">
</script>
</@bootstrap.body>