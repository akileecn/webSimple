<div class='col-xs-8 padding-r'>
    <div class="box_3">
        <div class="box_4" style="height:375px;">
            <span class="search_title">职位搜索</span>
            <form action="<@spring.url "/job/list"/>" method="get">
                <div class="search_con">
                	<div class="search_ul">
                        <span>招聘类型：</span>
                        <#assign recuitTypes={"campus":"校园","society":"社会","trainee":"实习生"}/>
                        <#list recuitTypes?keys as key>
                        <input type="radio" name="recruitType" value="${key}" id="recruitType_${key?index+1}" <#if key?index==0>checked</#if>>
                        <label class="search_bg" for="recruitType_${key?index+1}">${recuitTypes[key]}</label>
						</#list>
                    </div>
                    <div class="search_ul">
                        <span>工作地点：</span>
                        <input type="radio" name="workCity" value="" id="workCity_all" checked/>
                        <label class="search_bg cursor" for="workCity_all">全部</label>
                        <#list dictMap["workCity"]?keys as key>
                        <input type="radio" name="workCity" value="${key}" id="workCity_${key?index+1}">
                        <label class="search_bg" for="workCity_${key?index+1}">${dictMap["workCity"][key]}</label>
						</#list>
                    </div>
                    <span class="search_index col-xs-9 padding-l">
			            <input type="text" name="name" placeholder="搜索" style="height:39px;">
			            <input type="submit" value="">
			        </span>
                </div>
            </form>
        </div>
    </div>
</div>