<@bootstrap.head>
<title>我的通知</title>
<style type="text/css">
	.new_true span{
		font-weight: bold;
	}
</style>
</@bootstrap.head>
<@bootstrap.body>
<div class="container">
	<#include "user/left.ftl"/>
	<@c.right title="我的通知">
    <form id="listForm" action="<@spring.url "/notice/list"/>" method="post">
    <div>
    	<#-- 分页参数 -->
    	<input type="hidden" name="pageNum"/>
    	<input type="hidden" name="pageSize"/>
    </div>
	</form>
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="col_tab">
        <tr class="col_h_green">
            <td colspan="5" style="height:1px;"></td>
        </tr>
        <tr class="col_tab_title ">
            <td width="30%">时间</td>
            <td>标题</td>
            <td width="160" align="center">操作</td>
        </tr>
        <tbody id="listTbody"></tbody>
    </table>
    <div class="page" id="pageDiv"></div>
	</@c.right>
</div>
<script type="text/javascript" id="templete_div">
	var T={};
	//列表
	T.item='<@compress single_line=true>
        <tr class="col_tab_t new_%{isNew}">
            <td><span>%{createTime}</span></td>
            <td width="30%"><a href="javascript:void(0)" class="_tanchu" onclick="showDetail(\'%{id}\',this)"><span>%{title}</span></a></td>
            <td>
                <div class="btn notice_btn">
                    <input type="submit" value="查看" class="_tanchu" onclick="showDetail(\'%{id}\',this)">
                    <input type="reset" value="删除" onclick="deleteNotice(\'%{id}\',this)">
                </div>
            </td>
        </tr>
	</@compress>';
	//详情
	T.detail='<@compress single_line=true>
		<div class="pop_job pop_w ">
		    <span class="close" onclick="art.dialog.list[\'abc\'].close();"> </span>
		    <h2> 通知详情页 </h2>
		    <div class="pop_job_col">
		        <div class="pop_job_main">
		            <h4>%{title}</h4>
		            <p>%{content}</p>
		        </div>
		    </div>
		</div>
	</@compress>';
	//岗位查询
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
	
    //详情
	function showDetail(id,self){
		$(self).parents("tr").removeClass("new_true");
		$.post("<@spring.url "/notice/detail"/>",{"id":id},function(text){
			if(text.success){
				art.dialog({
			        lock: true,
			        id: "abc",
			        content: $.template(T.detail,text.data)
			    });
			}
		});
	}
	
	//删除
	function deleteNotice(id,self){
		$.post("<@spring.url "/notice/delete"/>",{"id":id},function(text){
			if(text.success){
				$(self).parents("tr").remove();
			}
		});
	}
</script>
</@bootstrap.body>