<div class="container">
	<form id="myForm" action="<@spring.url "/job/apply"/>" method="post">
		<label for="name">招聘岗位:</label><span>${job.name}</span><br/>
		<label for="workYear">工作年限:</label><span>${job.workYear}</span><br/>
		<label for="workCity">工作城市:</label><span>${job.workCity}</span><br/>
		<label for="education">学历要求:</label><span>${job.education}</span><br/>
		<#-- 时间数据必须判断是否为null -->
		<label for="publishDate">发布时间:</label><span><#if job.publishDate??>${job.publishDate?date}</#if></span><br/>
		<label for="endDate">截止时间:</label><span><#if job.publishDate??>${job.endDate?date}</#if></span><br/>
		<label for="peopleNumber">人数:</label><span>${job.peopleNumber}</span><br/>
		<label for="requirement">要求:</label><span>${job.requirement}</span><br/>
		<label for="description">描述:</label><span>${job.description}</span><br/>
	</form>
</div>