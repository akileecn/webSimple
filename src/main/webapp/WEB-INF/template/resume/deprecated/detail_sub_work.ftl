<div class="col_cv_tab">
    <h4>工作实习经历</h4>
	<div id="workDiv"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	        <td colspan="2" style="text-align: center;">
	            <input name="" type="button" value="+继续添加" class="new fr" onclick="addSub('work','input');">
	        </td>
	    </tr>
	</table>
</div>
<script type="text/javascript">
	T.work={};
	T.work.text='<@compress single_line=true>
		<form action="" method="post" data-type="text">
			<div class="col_cv_tab">
			    <div class="edit fr">
			        <a href="javascript:void(0);" onclick="switchSub(\'work\',this);"><img src="<@c.resource "images/icon-1.png"/>" width="18"></a>
			    </div>
			    <div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'work\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr><span data-name="id" data-value="%{id}" style="display:none;"/>
						<@span label="单位名称" name="company"/>
						<@span label="年薪" name="annualSalary"/>
					</tr>
					<tr>
						<@span label="部门名称" name="department"/>
						<@span label="职位" name="job"/>
					</tr>
					<tr>	
						<@span label="证明人" name="certifier"/>
						<@span label="证明人电话" name="certifierMobile"/>
					</tr>
					<tr>
						<@span label="工作地点" name="workPlace"/>
						<@span label="职位类型" name="jobType" translate=true/>
					</tr>
					<tr>
						<@span label="开始时间" name="beginDate"/>
						<@span label="结束时间" name="endDate"/>
					</tr>
		            <tr><@span label="离职原因" name="dimissionReason" wide=true/></tr>
		            <tr><@span label="职责描述" name="duty" wide=true/></tr>
		            <tr><@span label="工作业绩" name="performance" wide=true/></tr>
		        </table>
			</div>
		</form>
	</@compress>';
	T.work.input='<@compress single_line=true>
		<form action="" method="post" data-type="input">
			<div class="col_cv_tab">
				<div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'work\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			        <tr><input type="hidden" name="id"/>
			        	<@input label="单位名称" name="company"/>
						<@input label="年薪" name="annualSalary"/>
					</tr>
					<tr>
						<@input label="部门名称" name="department"/>
						<@input label="职位" name="job"/>
					</tr>
					<tr>	
						<@input label="证明人" name="certifier"/>
						<@input label="证明人电话" name="certifierMobile"/>
					</tr>
					<tr>
						<@input label="工作地点" name="workPlace"/>
						<@select label="职位类型" name="jobType"/>
					</tr>
					<tr>
						<@date label="开始时间" name="beginDate"/>
						<@date label="结束时间" name="endDate"/>
					</tr>
		            <tr><@textarea label="离职原因" name="dimissionReason"/></tr>
		            <tr><@textarea label="职责描述" name="duty"/></tr>
		            <tr><@textarea label="工作业绩" name="performance"/></tr>
			        <tr>
			            <td colspan="2" style="text-align: center;">
			                <input type="reset" value="重置" class="reset">
			                <input type="button" value="保存" class="submit" onclick="saveSub(\'work\',this)">
			            </td>
			        </tr>
			    </table>
			</div>
		</form>
	</@compress>';
</script>