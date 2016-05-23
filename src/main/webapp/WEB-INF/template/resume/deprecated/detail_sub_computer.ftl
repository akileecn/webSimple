<div class="col_cv_tab">
    <h4>计算机情况</h4>
	<div id="computerDiv"></div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	    <tr>
	        <td colspan="2" style="text-align: center;">
	            <input name="" type="button" value="+继续添加" class="new fr" onclick="addSub('computer','input');">
	        </td>
	    </tr>
	</table>
</div>
<script type="text/javascript">
	T.computer={};
	T.computer.text='<@compress single_line=true>
		<form action="" method="post" data-type="text">
			<div class="col_cv_tab">
			    <div class="edit fr">
			        <a href="javascript:void(0);" onclick="switchSub(\'computer\',this);"><img src="<@c.resource "images/icon-1.png"/>" width="18"></a>
			    </div>
			    <div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'computer\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
		        <table width="100%" border="0" cellspacing="0" cellpadding="0">
		            <tr><span data-name="id" data-value="%{id}" style="display:none;"/>
						<@span label="证书名称" name="certificate"/>
						<@span label="取得时间" name="obtainDate"/>
					</tr>
					<tr><@span label="掌握程度" name="level"/></tr>
		            <tr><@span label="详细说明" name="detail" wide=true/></tr>
		        </table>
			</div>
		</form>
	</@compress>';
	T.computer.input='<@compress single_line=true>
		<form action="" method="post" data-type="input">
			<div class="col_cv_tab">
				<div class="del fr">
			        <a href="javascript:void(0);" onclick="deleteSub(\'computer\',this);"><img src="<@c.resource "images/icon-2.png"/>" width="18"></a>
			    </div>
			    <table width="100%" border="0" cellspacing="0" cellpadding="0">
			        <tr><input type="hidden" name="id"/>
			        	<@input label="证书名称" name="certificate"/>
						<@date label="取得时间" name="obtainDate"/>
					</tr>
					<tr><@select label="掌握程度" name="level"/></tr>
		            <tr><@textarea label="详细说明" name="detail"/></tr>
			        <tr>
			            <td colspan="2" style="text-align: center;">
			                <input type="reset" value="重置" class="reset">
			                <input type="button" value="保存" class="submit" onclick="saveSub(\'computer\',this)">
			            </td>
			        </tr>
			    </table>
			</div>
		</form>
	</@compress>';
</script>