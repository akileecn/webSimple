<div class="container">
	<div id="awardDiv"><div>
	<button type="submit" class="btn" onclick="addSub('award','input');">添加</button>
	<button type="submit" class="btn" onclick="addSub('award','text');">添加</button>
</div>
<script type="text/javascript">
	Tempate.award={};
	Tempate.award.text='<@compress single_line=true>
		<form>
			<@c.text name="name" label="奖励名称"/>
			<@c.text name="time" label="获得时间"/><br/>
			<@c.text name="level" label="级别"/>
			<@c.text name="description" label="奖励描述"/><br/>
			<button type="button" class="btn" onclick="toUpdateSub(\'award\',this)">编辑</button>
			<button type="button" class="btn" onclick="deleteSub(\'award\',this);">删除</button>
		</form>
	</@compress>';
	Tempate.award.input='<@compress single_line=true>
		<form>
			<@c.input type="text" name="name" label="奖励名称"/>
			<@c.input type="text" name="time" label="获得时间" attr="class=\"form_datetime\""/><br/>
			<@c.select name="level" label="级别"/>
			<@c.input type="text" name="description" label="奖励描述"/><br/>
			<button type="button" class="btn" onclick="saveSub(\'award\',this)">保存</button>
			<button type="button" class="btn" onclick="deleteSub(\'award\',this);">删除</button>
		</form>
	</@compress>';
</script>