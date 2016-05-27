<div class='col-xs-8 padding-r padding-t'>
    <div class="box_3">
        <div class="box_4">
            <h3>热招职位</h3>
            <a href="<@spring.url "/job/list"/>"><span class="more fr" >更多 &nbsp;<img src="<@c.resource "images/arrow1.png"/>" alt=""/></span></a>
            <ul class="hotjob">
            	<#list hotJoblist as job>
                <li><a href="<@spring.url "/job/list?resumeType="+job.resumeType+"&id="+job.id/>">${job.name}</a></li>
            	</#list>
            </ul>
        </div>
    </div>
</div>