<div class="col_cv_tab">
    <h4>教育经历</h4>
	<div id="educationDiv"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	        <td colspan="2" style="text-align: center;">
	            <input name="" type="button" value="+继续添加" class="new fr" onclick="addSub('education','input');">
	        </td>
	    </tr>
	</table>
</div>
<script type="text/javascript">
	T.education={};
	T.education.text='<@compress single_line=true>
		<form action="" method="post" data-type="text">
			<div class="col_cv_tab">
			    <div class="edit fr">
			        <a href="javascript:void(0);" onclick="switchSub(\'education\',this);"><img src="<@c.resource "images/icon-1.png"/>" width="18"></a>
			    </div>
			    <div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'education\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr><span data-name="id" data-value="%{id}" style="display:none;"/>
						<@span label="学校名称" name="schoolName"/>
						<@span label="所学专业" name="major"/>
					</tr>
					<tr>
						<@span label="毕业方式" name="graduateType" translate=true/>
						<@span label="所得学位" name="degree" translate=true/>
					</tr>
					<tr>
						<@span label="学历等级" name="education" translate=true/>
						<@span label="学习形式" name="learnType" translate=true/>
					</tr>
					<tr>
						<@span label="开始时间" name="beginDate"/>
						<@span label="结束时间" name="endDate"/>
					</tr>
					<tr>
						<@span label="学校类别" name="schoolType" translate=true/>
						<@span label="是否担任过学生干部" name="hasBeenCadre" translate=true attr="style=\"width:200px;\""/>
					</tr>
					<tr><@span label="年级排名" name="gradeRank" translate=true/></tr>
		        </table>
			</div>
		</form>
	</@compress>';
	T.education.input='<@compress single_line=true>
		<form action="" method="post" data-type="input">
			<div class="col_cv_tab">
				<div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'education\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			        <tr><input type="hidden" name="id"/>
						<@input label="学校名称" name="schoolName"/>
						<@input label="所学专业" name="major"/>
					</tr>
					<tr>
						<@select label="毕业方式" name="graduateType"/>
						<@select label="所得学位" name="degree"/>
					</tr>
					<tr>
						<@select label="学历等级" name="education"/>
						<@select label="学习形式" name="learnType"/>
					</tr>
					<tr>
						<@date label="开始时间" name="beginDate"/>
						<@date label="结束时间" name="endDate"/>
					</tr>
					<tr>
						<@select label="学校类别" name="schoolType"/>
						<@radio label="是否担任过学生干部" name="hasBeenCadre"/>
					</tr>
					<tr><@select label="年级排名" name="gradeRank"/></tr>
			        <tr>
			            <td colspan="2" style="text-align: center;">
			                <input type="reset" value="重置" class="reset">
			                <input type="button" value="保存" class="submit" onclick="saveSub(\'education\',this)">
			            </td>
			        </tr>
			    </table>
			</div>
		</form>
	</@compress>';
</script>