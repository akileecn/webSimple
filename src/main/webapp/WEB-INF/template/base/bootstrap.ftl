<#-- html头 -->
<#macro head>
<!DOCTYPE html >
<html lang="zh-CN">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<!-- Bootstrap -->
	<#-- 用美工的
	<link href="<@c.resource "bootstrap-3.3.6/css/bootstrap.min.css"/>" rel="stylesheet">
	-->
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<@c.resource "jquery/jquery-1.12.3.min.js"/>"></script>
	<#-- bootstrap日期插件 -->
	<link href="<@c.resource "bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet">
	<script src="<@c.resource "bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"/>"></script>
	<#-- 日期国际化 -->
	<script src="<@c.resource "bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"/>"></script>
	<#-- 异步提交表单 -->
	<script src="<@c.resource "jquery/jquery.form.js"/>"></script>
	<#-- 自动填充表单 -->
	<script src="<@c.resource "jquery/jquery.formautofill.min.js"/>"></script>
	<#-- 公共方法 -->
	<script src="<@c.resource "js/common.js"/>"></script>
	<#-- 美工样式相关 -->
	<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
	<link href="<@c.resource "css/bootstrap.css"/>" rel='stylesheet' type='text/css' />
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="<@c.resource "js/jquery.artDialog.js"/>"></script><!-- Custom Theme files -->
	<link href="<@c.resource "css/style.css"/>" rel='stylesheet' type='text/css' />
	<!----start-top-nav-script---->
	<script>
		$(function() {
			var pull 		= $('#pull');
				menu 		= $('nav ul');
				menuHeight	= menu.height();
			$(pull).on('click', function(e) {
				e.preventDefault();
				menu.slideToggle();
			});
			$(window).resize(function(){
        		var w = $(window).width();
        		if(w > 320 && menu.is(':hidden')) {
        			menu.removeAttr('style');
        		}
    		});
		});
	</script>
	<!----//End-top-nav-script---->
	<script src="<@c.resource "js/jquery.easydropdown.js"/>"></script>
	<script src="<@c.resource "js/hover_pack.js"/>"></script>
	<#-- //End美工样式相关 -->
	<script>
		(function($){
			//分页条
			$.fn.page=function(p,callback){
				if(!p||!p.pages||!p.pageNum){
					$(this).html('<a href="javascript:void(0);"><font class="green">1</font></a><a href="javascript:void(0);">共<b class="green">0</b>条</a>');
					return;
				}
				var html="";
				if(p.pages>0){
					var begin=p.pageNum-3;
					if(begin<1){
						begin=1;
					}
					var end=p.pageNum+3;
					if(end>p.pages){
						end=p.pages;
					}
					if(begin!=1){
						html+='<a href="javascript:void(0);" data-index="'+(begin-1)+'"><img src="<@c.resource "images/arrow_left1.png"/>"></a>';
					}
					for(var i=begin;i<=end;i++){
						if(i==p.pageNum){
							html+='<a href="javascript:void(0);"><font class="green">'+i+'</font></a>';
						}else{
							html+='<a href="javascript:void(0);" data-index="'+i+'">'+i+'</a>';
						}
					}
					if(end!=p.pages){
						html+='<a href="javascript:void(0);" data-index="'+(end+1)+'"><img src="<@c.resource "images/arrow_right1.png"/>"></a>';
					}
				}
				html+='<a href="javascript:void(0);">共<b class="green">'+p.pages+'</b>条</a>';
				var $self=$(this);
				$self.html(html);
				$self.on("click","a",function(text){
					var index=$(this).attr("data-index");
					if(index&&callback){
						callback(index);
					}
				});
			}
		}(window.$));
	</script>
	<#nested>
</head>
</#macro>

<#-- html体 -->
<#macro body menu>
<body>
	<!----start-header---->
	<div class="header">
		<div class="container"  >
			<div class="header_top">
				<div class="logo">
					<a href="<@spring.url "/index"/>"><img src="<@c.resource "images/logo.jpg"/>" alt=""></a>
				</div>
				<div class="menu">					
					<ul class="nav" id="nav">
						<li <#if !menu??>class="current"</#if>><a href="<@spring.url "/index"/>">首页</a></li>
						<li <#if menu=="campus">class="current"</#if>><a href="<@spring.url "/job/list?recruitType=campus"/>">校园招聘</a></li>
						<li <#if menu=="society">class="current"</#if>><a href="<@spring.url "/job/list?recruitType=society"/>">社会招聘</a></li>
						<li <#if menu=="trainee">class="current"</#if>><a href="<@spring.url "/job/list?recruitType=trainee"/>">实习生招聘</a></li>
						<li <#if menu=="about">class="current"</#if>><a href="<@spring.url "/about"/>">认识瑞丰</a></li>								
					</ul>
					<script type="text/javascript" src="<@c.resource "js/responsive-nav.js"/>"></script>
				</div>							
				<div class="clearfix"> </div>
				<!----//End-top-nav---->
			</div>
		</div>
	</div>
	<!----//End-header---->
	<#nested>
	<div class="footer">
	    <div class="container">
	        <div class="col-xs-12 footer_grid">
	            <div class="copy">
	                <p>Copyright &copy; 2016.Company name All rights reserved.</p>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<@c.resource "bootstrap-3.3.6/js/bootstrap.min.js"/>"></script>
</body>
</html>
</#macro>