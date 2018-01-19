<@bootstrap.head>
<title>我的应聘</title>
</@bootstrap.head>
<@bootstrap.body attr="id='user_center'">
<div class="container">
	<#include "user/left.ftl"/>
	<@c.right title="我的应聘">
    <table width="100%" border="0" cellspacing="0" cellpadding="0" class="col_tab">
        <tr class="col_h_green">
            <td colspan="5" style="height:1px;"></td>
        </tr>
        <tr class="col_tab_title ">
            <td width="30%">投递时间</td>
            <td>招聘类型</td>
            <td>岗位名称</td>
            <td>工作地点</td>
            <td width="160" align="center">操作</td>
        </tr>
        <#if list??&&list?has_content>
        	<#list list as item>
        <tr class="col_tab_t">
            <td>${item.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            <td>${item.job.t.recruitType}</td>
            <td><a href="<@spring.url "/job/list?recruitType="+item.job.recruitType+"&id="+item.jobId/>">${item.job.name}</a></td>
            <td>${item.job.t.workCity}</td>
            <td><a href="javascript:void(0);" class="col_tab_joingo">已投递</a></td>
        </tr>
        	</#list>
        <#else>
        <tr><td colspan="4">无相关数据</td></tr>
        </#if>
    </table>
    <div class="page" id="pageDiv"></div>
	</@c.right>
</div>
<script type="text/javascript" id="templete_div">
    //详情
	function showJobDetail(id){
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