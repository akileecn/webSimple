<@bootstrap.head>
<title>岗位列表页</title>
<script>
	$(document).ready(function() {
		//岗位查询
		var listTrTemplate=$("#myTbody").html();//保存原有模版
		$('#myForm').ajaxForm(function(text){
			if(text.success){
				var list=text.data.list;
				var html="";
				for(var i=0;i<list.length;i++){
					html+=$.template(listTrTemplate,list[i]);
				}
				$("#myTbody").html(html);
			}else{
				$("#myTbody").html("<tr><td>无相关数据</td></tr>")
			}
		});
		//初始化加载
		$("#myForm").submit();
		
		//分页按钮
		$(".pagination li a").on("click",function(){
			var pageNum=$(this).attr("pageNum");
			if(pageNum){
				$("#myForm").find("input[name='pageNum']").val(pageNum);
				$("#myForm").submit();
			}
		});
		
		//岗位列表
		var detailTemplate=$("#myModalBody").html();//保存原有模版
		$("#myTbody").on("click","tr",function(){
			var id=$(this).attr("jobId");
			if(id){
				$.post("<@spring.url "/job/detail"/>",{"id":id},function(text){
					if(text.success){
						$("#myModalBody").template(detailTemplate,text.data);
						$("#myModal").modal("show");
					}
				});
			}
		});
		
	});
</script>
</@bootstrap.head>
<@bootstrap.body>
<!-- 详情页模板 -->
<div class="modal fade" id="myModal" tabindex="-1">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
				<h4 class="modal-title">岗位详情</h4>
			</div>
			<div id="myModalBody" class="modal-body">
				<form action="<@spring.url "/job/apply"/>" method="post">
					<label for="name">招聘岗位:</label><span>%{name}</span><br />
					<label for="workYear">工作年限:</label><span>%{t.workYear}</span><br />
					<label for="workCity">工作城市:</label><span>%{t.workCity}</span><br />
					<label for="education">学历要求:</label><span>%{t.education}</span><br />
					<label for="publishDate">发布时间:</label><span>%{publishDate}</span><br />
					<label for="endDate">截止时间:</label><span>%{endDate}</span><br />
					<label for="peopleNumber">人数:</label><span>%{peopleNumber}</span><br />
					<label for="requirement">要求:</label><span>%{requirement}</span><br />
					<label for="description">描述:</label><span>%{description}</span><br />
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary">申请</button>
			</div>
		</div>
	</div>
</div>
<!-- 岗位列表 -->
<div class="container">
	<form id="myForm" action="<@spring.url "/job/list"/>" method="post">
		<label for="workCity">工作地点:</label>
		<@c.select name="workCity" value=form.workCity />
		<label for="education">学历要求:</label>
		<@c.select name="education" value=form.education />
		<label for="publishDateType">发布时间:</label>
		<@c.select name="publishDateType" value=form.publishDateType />
		<label for="name">岗位名称:</label>
		<input type="text" name="name"/>
		<input type="hidden" name="pageNum"/><!-- 页码 -->
		<button type="submit" class="btn">搜索</button>
	</form>
	<table class="table">
		<tr>
			<th>招聘岗位</th>
			<th>工作地点</th>
			<th>截止时间</th>
			<th>招聘人数</th>
			<th></th>
		</tr>
		<tbody id="myTbody">
		<tr jobId="%{id}">
			<td>%{name}</td>
			<td>%{t.workCity}</td>
			<td>%{t.endDate}</td>
			<td>%{peopleNumber}</td>
			<td></td>
		</tr>
		</tbody>
		<tr><td>共?条</td></tr>
		<tr><td><nav><ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<li><a href="#" pageNum="1">1</a></li>
			<li><a href="#" pageNum="2">2</a></li>
			<li><a href="#" pageNum="3">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul></nav></td></tr>
	</table>
</div>
</@bootstrap.body>