<div class='col-xs-3 padding-r  padding-t'>
    <div class="box_3">
        <div class="box_4 minheight">
            <span class="left_title">${dictMap["recruitType"][job.recruitType]}招聘</span>
            <ul class="left_col">
            	<#if job.recruitType=="campus">
                <li><a href="<@spring.url "/job/notice?recruitType="+userCenterType/>">招聘公告</a></li>
                </#if>
                <li><a href="<@spring.url "/job/list?recruitType="+userCenterType/>">招聘岗位</a></li>
                <li><a href="<@spring.url "/resume/list?recruitType="+userCenterType/>">个人中心</a></li>
                <li><a href="<@spring.url "/notice/list"/>">通知信</a></li>
            </ul>
        </div>
    </div>
</div>