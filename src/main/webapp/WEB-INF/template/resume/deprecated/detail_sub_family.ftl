<div class="col_cv_tab">
    <h4>家庭成员</h4>
	<div id="familyDiv"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	        <td colspan="2" style="text-align: center;">
	            <input name="" type="button" value="+继续添加" class="new fr" onclick="addSub('family','input');">
	        </td>
	    </tr>
	</table>
</div>
<script type="text/javascript">
	T.family={};
	T.family.text='<@compress single_line=true>
		<form action="" method="post" data-type="text">
			<div class="col_cv_tab">
			    <div class="edit fr">
			        <a href="javascript:void(0);" onclick="switchSub(\'family\',this);"><img src="<@c.resource "images/icon-1.png"/>" width="18"></a>
			    </div>
			    <div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'family\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr><span data-name="id" data-value="%{id}" style="display:none;"/>
						<@span label="姓名" name="name"/>
						<@span label="关系" name="relationship" translate=true/>
					</tr>
					<tr>
						<@span label="工作单位" name="workCompany"/>
						<@span label="职位" name="workJob"/>
					</tr>
		            <tr><@span label="说明" name="description" wide=true/></tr>
		        </table>
			</div>
		</form>
	</@compress>';
	T.family.input='<@compress single_line=true>
		<form action="" method="post" data-type="input">
			<div class="col_cv_tab">
				<div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'family\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			        <tr><input type="hidden" name="id"/>
			        	<@input label="姓名" name="name"/>
						<@select label="关系" name="relationship"/>
					</tr>
					<tr>
						<@input label="工作单位" name="workCompany"/>
						<@input label="职位" name="workJob"/>
					</tr>
		            <tr><@textarea label="说明" name="description"/></tr>
			        <tr>
			            <td colspan="2" style="text-align: center;">
			                <input type="reset" value="重置" class="reset">
			                <input type="button" value="保存" class="submit" onclick="saveSub(\'family\',this)">
			            </td>
			        </tr>
			    </table>
			</div>
		</form>
	</@compress>';
</script>