<div class="col_cv_tab">
    <h4>外语情况</h4>
	<div id="foreignLanguageDiv"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	        <td colspan="2" style="text-align: center;">
	            <input name="" type="button" value="+继续添加" class="new fr" onclick="addSub('foreignLanguage','input');">
	        </td>
	    </tr>
	</table>
</div>
<script type="text/javascript">
	T.foreignLanguage={};
	T.foreignLanguage.text='<@compress single_line=true>
		<form action="" method="post" data-type="text">
			<div class="col_cv_tab">
			    <div class="edit fr">
			        <a href="javascript:void(0);" onclick="switchSub(\'foreignLanguage\',this);"><img src="<@c.resource "images/icon-1.png"/>" width="18"></a>
			    </div>
			    <div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'foreignLanguage\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr><span data-name="id" data-value="%{id}" style="display:none;"/>
						<@span label="英语等级" name="level" translate=true/>
						<@span label="英语分数" name="score"/>
					</tr>
					<tr>
						<@span label="英语口语" name="speaking" translate=true/>
						<@span label="其他语言" name="others" translate=true/>
					</tr>
		        </table>
			</div>
		</form>
	</@compress>';
	T.foreignLanguage.input='<@compress single_line=true>
		<form action="" method="post" data-type="input">
			<div class="col_cv_tab">
				<div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'foreignLanguage\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			        <tr><input type="hidden" name="id"/>
			        	<@select label="英语等级" name="level" dict="languageLevel"/>
						<@input label="英语分数" name="score"/>
					</tr>
					<tr>
						<@select label="英语口语" name="speaking" dict="languageProficiency"/>
						<@select label="其他语言" name="others" dict="language"/>
			        <tr>
			            <td colspan="2" style="text-align: center;">
			                <input type="reset" value="重置" class="reset">
			                <input type="button" value="保存" class="submit" onclick="saveSub(\'foreignLanguage\',this)">
			            </td>
			        </tr>
			    </table>
			</div>
		</form>
	</@compress>';
</script>