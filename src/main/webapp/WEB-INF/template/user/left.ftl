<#-- 个人中心其他页面也共用 -->
<div class='col-xs-3 padding-r  padding-t'>
    <div class="box_3">
        <div class="box_4 minheight">
            <span class="left_title">个人中心</span>
            <ul class="left_col">
                <li><a href="<@spring.url "/resume/list?recruitType="+userCenterType/>">我的简历</a></li>
                <li><a href="<@spring.url "/application/list?recruitType="+userCenterType/>">我的应聘</a></li>
                <li><a href="<@spring.url "/notice/list"/>">我的通知</a></li>
                <li><a href="<@spring.url "/user/updatePassword"/>">密码修改</a></li>
            </ul>
        </div>
    </div>
</div>