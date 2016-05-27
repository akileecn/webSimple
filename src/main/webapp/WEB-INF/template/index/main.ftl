<@bootstrap.head>
<title>瑞丰银行欢迎您！</title>
<script type="application/x-javascript">
    addEventListener("load", function() {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    }
</script>
</@bootstrap.head>
<@bootstrap.body>
<#include "/index/part/banner.ftl"/>
<div class="grid_1">
    <div class="container">
    <#include "/index/part/job_search.ftl"/>
    <#include "/index/part/login.ftl"/>
    <#include "/index/part/job_hot.ftl"/>
    <#include "/index/part/wechat.ftl"/>
    </div>
</div>
</@bootstrap.body>