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
<@bootstrap.body menu="about">
<@c.banner images=["index-banner.jpg","about-banner.jpg"]/>
<div class="container">
    <div class='col-xs-3 padding-r  padding-t'>
        <div class="box_3">
            <div class="box_4 minheight">
                <span class="left_title">认识瑞丰</span>
                <ul class="left_col">
                    <li><a href="javascript:loadContent(1);">企业发展</a></li>
                    <li><a href="javascript:loadContent(2);">企业文化</a></li>
                    <li><a href="javascript:loadContent(3);">薪酬福利</a></li>
                    <li><a href="javascript:loadContent(4);">培训发展</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class='col-xs-9 padding-l  padding-t'>
        <div class="box_3">
            <div class="box_4 minheight" id="contentDiv"></div>
        </div>
    </div>
    <div class="clearfix"> </div>
</div>
<script>
	$(document).ready(function(){
		loadContent(1);
	});
	function loadContent(index){
		$("#contentDiv").load("<@spring.url "/staticPage/about/"/>"+index);
	}
</script>
</@bootstrap.body>