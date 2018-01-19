<div class='col-xs-8 padding-r padding-t'>
    <div class="box_3">
        <div class="box_4" style="height:375px;">
            <h3>热招职位</h3>
            <#-- <a href="<@spring.url "/job/list"/>"><span class="more fr" >更多 &nbsp;<img src="<@c.resource "images/arrow1.png"/>" alt=""/></span></a> -->
            <a href="javascript:void(0);" id="nextHotJob"><span class="more fr" >下一页&nbsp;</span></a>
            <a href="javascript:void(0);" id="preHotJob"><span class="more fr" >上一页&nbsp;</span></a>
            <ul class="hotjob" id="hotJobDiv"></ul>
        </div>
    </div>
</div>
<script>
	$(function(){
		var PAGE_NUM=1;
		//加载第一页
		loadHotList(PAGE_NUM);
		$("#preHotJob").click(function(){
			loadHotList(PAGE_NUM-1);
		});
		$("#nextHotJob").click(function(){
			loadHotList(PAGE_NUM+1);
		});
		function loadHotList(pageNum){
			$.ajax({
				url:"<@spring.url "/job/hotList"/>"
				,data:{"pageNum":pageNum}
				,type:"post"
				,success:function(text){
					if(text.success){
						var list=text.data.list;
						var html="";
						for(var i=0;i<list.length;i++){
							html+=$.template("<li><a href='<@spring.url "/job/list?recruitType=%{recruitType}&id=%{id}"/>'>%{name}</a></li>",list[i]);
						}
						$("#hotJobDiv").html(html);
						//记录当前页数
						PAGE_NUM=text.data.pageNum;
						//控制上下页按钮
						if(text.data.isFirstPage){
							$("#preHotJob").hide();
						}else{
							$("#preHotJob").show();
						}
						if(text.data.isLastPage){
							$("#nextHotJob").hide();
						}else{
							$("#nextHotJob").show();
						}
					}
				}
			});
		
		}
	});

</script>