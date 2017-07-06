<@bootstrap.head>
<title>招聘公告</title>
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
<div class="banner">
    <div class="banner_container">
        <img src="<@c.resource "images/about-banner.jpg"/>" width="1000">
    </div>
</div>
<div class="container">
    <#include "/job/left.ftl"/>
    <@c.right title=staticPage.title subTitle="招聘公告">
	${staticPage.content}
	</@c.right>
</div>
</@bootstrap.body>