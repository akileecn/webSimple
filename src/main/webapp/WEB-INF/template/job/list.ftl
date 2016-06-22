<#-- 详情页tr -->
<#macro detailTr label name wide=false>
	<td <#if wide>colspan="3"</#if>>
        <div class="title fl">${label}</div>
        <div class="con w833 <#if wide>h300</#if>">%{${name}}</div>
    </td>
</#macro>
<@bootstrap.head>
<title>${dictMap["recruitType"][job.recruitType]}招聘</title>
<style>
    ._more {
        position: relative;
    }
</style>
<style type="text/css">
    #plp_ad_container {
        display: none!important;
        display: none
    }
    
    [class="top-advert"] {
        display: none!important;
        display: none
    }
    
    [class="middle-advert"] {
        display: none!important;
        display: none
    }
</style>
</@bootstrap.head>
<@bootstrap.body menu=job.recruitType>
<div class="banner">
    <div class="banner_container">
        <img src="<@c.resource "images/"+(job.recruitType!"campus")+"-banner.jpg"/>" width="100%">
    </div>
</div>
<div class="container">
	<#-- left -->
    <#include "/job/left.ftl"/>
    <#-- right -->
    <@c.right title="招聘岗位">
    <form id="listForm" action="<@spring.url "/job/list"/>" method="post" class="col_search">
    <div>
    	<#-- 分页参数 -->
    	<input type="hidden" name="pageNum"/>
    	<input type="hidden" name="pageSize"/>
    	<#-- 招聘类型 -->
    	<input type="hidden" name="recruitType" value="${job.recruitType}"/>
		<@c.select label="工作地点" name="workCity" value=job.workCity selectAttr="class=\"col_search_add\""/>
		<@c.select label="学历要求" name="education" dict="searchEducation" value=job.education selectAttr="class=\"col_search_add\""/>
		<br>
        <label>岗位名称关键字</label>
        <input name="name" type="text" value="${job.name}" class="col_search_text" placeholder="请输入关键字">
    </div>
    <input type="submit" class="col_search_btn fr" value="搜索">
	</form>
    <div class="col_h">
        <h3>岗位列表</h3>
    </div>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="col_tab">
        <tr class="col_tab_title">
            <td width="30%">招聘岗位</td>
            <td>工作地点</td>
            <td>截止时间</td>
            <td>人数</td>
            <td width="160">
        		每页<a href="javascript:void(0);" class="col_tab_num">10</a>
        		<a href="javascript:void(0);" class="col_tab_num">20</a>
        		<a href="javascript:void(0);" class="col_tab_num">50</a>条
        	</td>
        </tr>
        <tbody id="listTbody"></tbody>
    </table>
    <div id="showjobb"></div>
    <div class="page" id="pageDiv"></div>
	</@c.right>
</div>
<script type="text/javascript" id="templete_div">
	var T={};
	//列表
	T.item='<@compress single_line=true>
		<tr class="col_tab_t" data-id="%{id}" data-name="%{name}">
            <td width="30%"><a href="javascript:void(0)" class="_detail">%{name}</a></td>
            <td><a href="javascript:void(0)" class="_detail"><img src="<@c.resource "images/add.png"/>" class="add _more" data-requirement="%{requirement}" data-description="%{description}">%{t.workCity}</a></td>
            <td>%{endDate}</td>
            <td>%{peopleNumber}</td>
            <td><a href="javascript:void(0)" class="col_tab_join _confirm">我要应聘</a></td>
        </tr>
	</@compress>';
	//更多信息
	T.more='<@compress single_line=true>
		<div>
			岗位职责:
			<div style = "width: 400px;height:auto;">%{requirement}</div>
			招聘要求：
			<div style="width: 400px;height:auto;">%{description}</div>
		</div>
	</@compress>';
	//详情页
	T.detail='<@compress single_line=true>
		<div class="pop_job pop_w">
		    <span class="close " onclick="art.dialog.list[\'abc\'].close();"> </span>
		    <h2> 招聘岗位说明 </h2>
		    <div class="pop_job_col">
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr>
						<@detailTr label="岗位名称" name="name"/>
						<@detailTr label="所属部门" name="department"/>
					</tr>
		            <tr>
						<@detailTr label="工作地点" name="t.workCity"/>
						<@detailTr label="工作年限要求" name="t.workYear"/>
					</tr>
		            <tr>
						<@detailTr label="学历要求" name="t.education"/>
						<@detailTr label="招聘人数" name="peopleNumber"/>
					</tr>
		            <tr>
						<@detailTr label="发布时间" name="publishDate"/>
						<@detailTr label="截止时间" name="endDate"/>
					</tr>
		            <tr>
						<@detailTr label="任职要求" name="requirement" wide=true/>
					</tr>
		            <tr>
						<@detailTr label="职责描述" name="description" wide=true/>
		            <tr data-id="%{id}" data-name="%{name}">
		                <td colspan="3">
		                    <div class="pop_job_p"> <a class="pop_job_in _confirm"> 我要应聘 </a></div>
		                </td>
		            </tr>
		        </table>
		    </div>
		</div>
	</@compress>';
	//确认
	T.confirm='<@compress single_line=true>
		<div class="pop_job pop_w2">
	        <span class="close" onclick="art.dialog.list[\'abc\'].close();"></span>
	        <h2>提示</h2>
	        <div class="pop_job_col">
	            <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                <tr><td><div class="pop_job_p"><div class="pop_job_yix">
                        <div class="tt">意向岗位</div>
                        <div class="cop"><a href="javascript:showDetail(\'%{id}\')">%{name}</a></div>
                        <div class="cen">您一季度只有一次申请机会，申请提交后无法修改</div>
                        <div class="btn">
                            <input name="" type="reset" value="取消" onclick="art.dialog.list[\'abc\'].close();">
                            <input name="" type="submit" value="确认提交" class="_complete" onclick="apply(\'%{id}\')">
                        </div>
                    </div></div></td></tr>
	            </table>
	        </div>
	    </div>
	</@compress>';
	//完成
	T.complete='<@compress single_line=true>
		<div class="pop_job pop_w2">
		    <span class="close" onclick="art.dialog.list[\'abc\'].close();"></span>
		    <h2> 提示 </h2>
		    <div class="pop_job_col">
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr><td><div class="pop_job_p"><div class="pop_job_yix">
                        <div style="margin-right:50px;">
                            <div class="tt"><img src="<@c.resource "images/good.png"/>" width="52" height="52" style="margin:15px 0 0 0;"></div>
                            <div class="cop">感谢您应聘我行职位<div class=" clearfix"></div>
                            <p>我们会尽快和您联系， 请您耐心等待！ </p>
                            </div>
                        </div>
                        <div class="btn">
                            <input name="" type="submit" value="关闭" onclick="art.dialog.list[\'abc\'].close();">
                        </div>
					</div></div></td></tr>
		        </table>
		    </div>
		</div>
	</@compress>';
	$(document).ready(function() {
		$("#listForm").css({"position":"relative"});
		//岗位查询
		var listTrTemplate=$("#myTbody").html();//保存原有模版
		$('#listForm').ajaxForm(function(text){
			if(text.success){
				var list=text.data.list;
				var html="";
				for(var i=0;i<list.length;i++){
					html+=$.template(T.item,list[i]);
				}
				$("#listTbody").html(html);
			}else{
				$("#listTbody").html("<tr><td colspan=\"5\">无相关数据</td></tr>");
			}
			//分页条
			$("#pageDiv").page(text.data,function(index){
				$("#listForm").find("input[name='pageNum']").val(index);
				$("#listForm").submit();
			});
		});
		
		//初始化加载
		$("#listForm").submit();
		
		<#-- 如果需要显示岗位详情 -->
		<#if job.id??>
		showDetail(${job.id});
		</#if>
		
		//每页显示条数
		$(".col_tab_num").click(function(){
			var pageSize=$(this).text();
			if(pageSize){
				$("#listForm").find("input[name='pageNum']").val(1);
				$("#listForm").find("input[name='pageSize']").val(pageSize);
				$("#listForm").submit();
			}
		});
		
		//更多信息
		$("body").on("mouseenter","._more",function(){
		    var top = this.offsetTop + 20;
		    var left = this.offsetLeft + 50;
		    var requirement=$(this).attr("data-requirement");
			var	description=$(this).attr("data-description");
		    $("#showjobb").css({
		        opacity: 0.9,
		        display: "block",
		        width: "400px",
		        height: "auto",
		        position: "absolute",
		        border: "1px solid rgb(0, 0, 0)",
		        left: left + "px",
		        top: top + "px",
		        backgroundColor: "rgb(255, 255, 255)",
		        fontSize: "12px"
		    }).html($.template(T.more,{"requirement":requirement,"description":description}));
		}).on("mouseleave","._more",function(){
		    $("#showjobb").hide();
		});
		
		//详情
		$("body").on("click","._detail",function(){
			var $tr=$(this).parents("tr");
			var id=$tr.attr("data-id");
			if(id){
				showDetail(id);
			}
		});
		
		//确认
		$("body").on("click","._confirm",function(){
			var $tr=$(this).parents("tr");
			var id=$tr.attr("data-id");
			var name=$tr.attr("data-name");
		    if (typeof art.dialog.list['abc'] != 'undefined')
		        art.dialog.list['abc'].close();
		    art.dialog({
		        id: "abc",
		        lock: true,
		        content: $.template(T.confirm,{"id":id,"name":name})
		    });
		})
		
	});	
	
	//显示详情
	function showDetail(id){
		$.post("<@spring.url "/job/detail"/>",{"id":id},function(text){
			if(text.success){
				if(typeof art.dialog.list['abc'] != 'undefined')art.dialog.list['abc'].close();
				art.dialog({
			        lock: true,
			        id: "abc",
			        content: $.template(T.detail,text.data)
			    });
			}
		});
	}
		
	//正式申请
	function apply(jobId){
		$.post("<@spring.url "/application/apply"/>",{"jobId":jobId},function(text){
			if(text.success){
				if(typeof art.dialog.list['abc'] != 'undefined')art.dialog.list['abc'].close();
			    art.dialog({
			        id: 'abc',
			        lock: true,
			        content: T.complete
			    });
			}else{
				if(text.message){
					if(text.message.indexOf(",")>-1){
						var parts=text.message.split(",");
						if("notSubmit"==parts[0]){
							alert("简历未提交");
							window.location.href="<@spring.url "/resume/detail"/>?recruitType=${job.recruitType}&id="+parts[1];
						}
					}else{
						alert(text.message);
					}
				}
			}
		});	
	
	}
</script>
</@bootstrap.body>
