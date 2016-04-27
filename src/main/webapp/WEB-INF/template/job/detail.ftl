<div class="container">
	<form id="myForm" action="<@spring.url "/job/apply"/>" method="post">
		<label for="workYear">工作年限:</label><span>${dictMap['workYear'][job.workYear]}</span><br/>
		<label for="workCity">工作城市:</label><span>${dictMap['workCity'][job.workCity]}</span><br/>
		<label for="education">学历要求:</label><span>${dictMap['education'][job.education]}</span><br/>
		<label for="publishDate">发布时间:</label><span>${job.publishDate?date}</span><br/>
		<label for="endDate">截止时间:</label><span>${job.endDate?date}</span><br/>
		<label for="peopleNumber">人数:</label><span>${job.peopleNumber}</span><br/>
		<label for="requirement">要求:</label><span>${job.requirement}</span><br/>
		<label for="description">描述:</label><span>${job.description}</span><br/>
	</form>
</div>