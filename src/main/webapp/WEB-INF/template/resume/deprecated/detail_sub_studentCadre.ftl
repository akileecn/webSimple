<div class="col_cv_tab">
    <h4>学生干部情况（从初中开始）</h4>
	<div id="studentCadreDiv"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	        <td colspan="2" style="text-align: center;">
	            <input name="" type="button" value="+继续添加" class="new fr" onclick="addSub('studentCadre','input');">
	        </td>
	    </tr>
	</table>
</div>
<script type="text/javascript">
	T.studentCadre={};
	T.studentCadre.text='<@compress single_line=true>
		<form action="" method="post" data-type="text">
			<div class="col_cv_tab">
			    <div class="edit fr">
			        <a href="javascript:void(0);" onclick="switchSub(\'studentCadre\',this);"><img src="<@c.resource "images/icon-1.png"/>" width="18"></a>
			    </div>
			    <div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'studentCadre\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr><span data-name="id" data-value="%{id}" style="display:none;"/>
						<@span label="开始时间" name="beginDate"/>
						<@span label="结束时间" name="endDate"/>
					</tr>
					<tr>
						<@span label="所在院校" name="school"/>
						<@span label="学生干部名称" name="name"/>
					</tr>
					<tr>
						<@span label="学生干部级别" name="level" translate=true/>
						<@span label="证明人" name="certifier"/>
					</tr>
					<tr><@span label="证明人联系方式" name="certifierMobile"/></tr>
		        </table>
			</div>
		</form>
	</@compress>';
	T.studentCadre.input='<@compress single_line=true>
		<form action="" method="post" data-type="input">
			<div class="col_cv_tab">
				<div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'studentCadre\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			        <tr><input type="hidden" name="id"/>
						<@date label="开始时间" name="beginDate"/>
						<@date label="结束时间" name="endDate"/>
					</tr>
					<tr>
						<@input label="所在院校" name="school"/>
						<@input label="学生干部名称" name="name"/>
					</tr>
					<tr>
						<@select label="学生干部级别" name="level" dict="cadreLevel"/>
						<@input label="证明人" name="certifier"/>
					</tr>
					<tr><@input label="证明人联系方式" name="certifierMobile"/></tr>
			        <tr>
			            <td colspan="2" style="text-align: center;">
			                <input type="reset" value="重置" class="reset">
			                <input type="button" value="保存" class="submit" onclick="saveSub(\'studentCadre\',this)">
			            </td>
			        </tr>
			    </table>
			</div>
		</form>
	</@compress>';
</script>