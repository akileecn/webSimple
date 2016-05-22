<div class="col_cv_tab">
    <h4>教育经历</h4>
	<div id="awardDiv"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	        <td colspan="2" style="text-align: center;">
	            <input name="" type="button" value="+继续添加" class="new fr" onclick="addSub('award','input');">
	        </td>
	    </tr>
	</table>
</div>
<script type="text/javascript">
	T.award={};
	T.award.text='<@compress single_line=true>
		<form action="" method="post" data-type="text">
			<div class="col_cv_tab">
			    <div class="edit fr">
			        <a href="javascript:void(0);" onclick="switchSub(\'award\',this);"><img src="<@c.resource "images/icon-1.png"/>" width="18"></a>
			    </div>
			    <div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'award\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr><span data-name="id" data-value="%{id}" style="display:none;"/>
						<@span label="奖励名称" name="name"/>
						<@span label="获得时间" name="time"/>
					</tr>
					<tr><@span label="级别" name="level" translate=true wide=true/></tr>
		            <tr><@span label="奖励描述" name="description" wide=true/></tr>
		        </table>
			</div>
		</form>
	</@compress>';
	T.award.input='<@compress single_line=true>
		<form action="" method="post" data-type="input">
			<div class="col_cv_tab">
				<div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'award\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			        <tr><input type="hidden" name="id"/>
						<@input label="奖励名称" name="name"/>
						<@date label="获得时间" name="time"/>
					</tr>
					<tr><@select label="级别" name="level" dict="awardLevel"/></tr>
			        <tr><@textarea label="奖励描述" name="description"/></tr>
			        <tr>
			            <td colspan="2" style="text-align: center;">
			                <input type="reset" value="重置" class="reset">
			                <input type="button" value="保存" class="submit" onclick="saveSub(\'award\',this)">
			            </td>
			        </tr>
			    </table>
			</div>
		</form>
	</@compress>';
</script>