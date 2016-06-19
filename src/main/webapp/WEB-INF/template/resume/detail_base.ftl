<div class="col_cv_tab">
    <form id="baseForm" action="<@spring.url "/resume/save/base"/>" method="post"></form>
    <#-- 头像上传 -->
    <input id="fileupload" type="file" name="files[]" data-url="<@spring.url "/resume/photo/upload?id=${id}"/>" style="display:none;" multiple/>
</div>
<script type="text/javascript">
	T.base={};
	T.base.text='<@compress single_line=true>
        <h4>基本信息</h4>
		<div class="edit fr"><a href="javascript:toEditBase();"><img src="<@c.resource "images/icon-1.png"/>" width="18"></a></div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
            	<span data-name="id" data-value="${id}" style="display:none;"/>
            	<@span label="姓名" name="name"/>
				<td rowspan="4">
                    <div class="user_pic mr fr">
                        <label>个人照片：</label>
                        <img src="<@spring.url "/resume/phote/show?id="+id />" onerror="this.src=\'<@c.resource "images/pic_tx.jpg"/>\'" width="150" height="180" alt="点击上传个人照片">
                    </div>
                </td>
            </tr>
            <tr><@span label="性别" name="gender" translate=true/></tr>
            <tr><@span label="出生日期" name="birthday"/></tr>
            <tr><@span label="民族" name="nation" translate=true/></tr>
            <tr>
				<@span label="身高(cm)" name="height"/>
            	<@span label="体重(kg)" name="weight"/>
			</tr>
            <tr><@span label="身份证号码" name="idNumber" wide=true/></tr>
            <tr><@span label="籍贯" name="nativePlace" wide=true/></tr>
            <tr><@span label="户口所在地" name="registeredResidence" wide=true/></tr>
            <tr>
            	<@span label="生源地" name="studentOrigin"/>
				<@span label="婚姻状况" name="marriage" translate=true/>
			</tr>
            <tr>
            	<@span label="政治面貌" name="politicsStatus" translate=true/>
				<@span label="入党（团）时间" name="joinPartyDate"/>
			</tr>
			<tr>
				<@span label="移动电话" name="mobile"/>
			<#if recruitType=="society">
				<@span label="参加工作时间" name="beginWorkDate"/>
			</tr>
            <tr>
				<@span label="参加工作年限" name="workYear" translate=true/>
			</#if>
				<@span label="电子邮箱" name="email"/>
            </tr>
            <tr>
				<@span label="最高全日制学历" name="highestEducation" translate=true/>
            	<@span label="最高学位" name="highestDegree" translate=true/>
			</tr>
			<tr>
				<@span label="开始时间" name="beginSchoolDate"/>
            	<@span label="毕业时间" name="graduateDate"/>
			</tr>
			<tr>
				<@span label="毕业院校" name="school"/>
            	<@span label="院校类别" name="schoolType"/>
			</tr>
            <tr>
            	<@span label="专业" name="major"/>
			<#if recruitType!="society">
				<@span label="高考省份" name="ceeProvince"/>
			</tr>
            <tr>
				<@span label="高考分数" name="ceeScore"/>
            	<@span label="是否一本分数线以上" name="isFirstLine" translate=true attr="style=\"width:200px;\""/>
			</tr>
            <tr>
				<@span label="文理科" name="artsOrScience" translate=true/>
            	<@span label="录取批次" name="admissionOrder" translate=true/>
			</tr>
			</#if>
            <tr>
				<@span label="紧急联系人" name="emergencyContact"/>
            	<@span label="紧急联系人电话" name="emergencyMobile"/>
			</tr>
            <tr>
				<@span label="子女(个)" name="childrenCount"/>
            	<@span label="是否有亲友受雇于本公司" name="isRelativeHere" translate=true attr="style=\"width:200px;\""/>
			</tr>
            <tr>
            	<@span label="期望工作地点" name="workCity" translate=true/>
            	<#--<@span label="健康状况" name="health" translate=true/>-->
			</tr>
            <tr><@span label="现居住地址" name="currentResidence" wide=true/></tr>
            <tr><@span label="家庭住址" name="familyResidence" wide=true/></tr>
            <tr><@span label="持证情况" name="certificate"/></tr>
            <tr><@span label="爱好特长" name="hobby"/></tr>
            <tr><@span label="性格特点" name="personality"/></tr>
        </table>
	</@compress>';
	T.base.input='<@compress single_line=true>
		<h4>基本信息</h4>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
            	<input type="hidden" name="id" value="${id}"/>
            	<input type="hidden" name="recruitType" value="${recruitType}"/>
            	<@input label="姓名" name="name" required=true/>
				<td rowspan="4">
                    <div class="user_pic fr">
                        <label>个人照片：</label>
                        <img id="photoImg" src="<@spring.url "/resume/phote/show?id="+id />" onerror="this.src=\'<@c.resource "images/pic_tx.jpg"/>\'" width="150" height="180" alt="点击上传个人照片">
                        <div class="tip_note">点击照片上传，要求JPG格式，不超过50KB</div>
                    </div>
                </td>
            </tr>
            <tr><@select label="性别" name="gender" required=true/></tr>
            <tr><@date label="出生日期" name="birthday" required=true/></tr>
            <tr><@select label="民族" name="nation" required=true/></tr>
            <tr>
				<@input label="身高(cm)" name="height" required=true/>
            	<@input label="体重(kg)" name="weight" required=true/>
			</tr>
            <tr><@input label="身份证号码" name="idNumber" required=true wide=true/></tr>
            <tr><@input label="籍贯" name="nativePlace" required=true wide=true/></tr>
            <tr><@input label="户口所在地" name="registeredResidence" required=true wide=true/></tr>
            <tr>
            	<@input label="生源地" name="studentOrigin" required=true/>
				<@select label="婚姻状况" name="marriage" required=true/>
			</tr>
            <tr>
            	<@select label="政治面貌" name="politicsStatus" required=true/>
				<@date label="入党（团）时间" name="joinPartyDate" required=true/>
			</tr>
            <tr>
				<@input label="移动电话" name="mobile" required=true/>
			<#if recruitType=="society">
				<@date label="参加工作时间" name="beginWorkDate" required=true/>
			</tr>
            <tr>
				<@select label="参加工作年限" name="workYear" required=true/>
			</#if>
				<@input label="电子邮箱" name="email" required=true/>
			</tr>
            <tr>
				<@select label="最高全日制学历" name="highestEducation" dict="education" required=true/>
            	<@select label="最高学位" name="highestDegree" dict="degree" required=true/>
			</tr>
            <tr>
            	<@date label="开始时间" name="beginSchoolDate" required=true/>
            	<@date label="毕业时间" name="graduateDate" required=true/>
			</tr>
            <tr>				
				<@input label="毕业院校" name="school" required=true/>
				<@select label="院校类别" name="schoolType" required=true/>
			</tr>
            <tr>
				<@input label="专业" name="major" required=true/>
			<#if recruitType!="society">
				<@input label="高考省份" name="ceeProvince" required=true/>
			</tr>
            <tr>
				<@input label="高考分数" name="ceeScore" required=true/>
            	<@radio label="是否一本分数线以上" name="isFirstLine" required=true/>
			</tr>
            <tr>
				<@select label="文理科" name="artsOrScience" required=true/>
            	<@select label="录取批次" name="admissionOrder" required=true/>
			</tr>
			</#if>
            <tr>
				<@input label="紧急联系人" name="emergencyContact" required=true/>
            	<@input label="紧急联系人电话" name="emergencyMobile" required=true/>
			</tr>
            <tr>
				<@input label="子女(个)" name="childrenCount"/>
            	<@radio label="是否有亲友受雇于本公司" name="isRelativeHere" required=true/>
			</tr>
            <tr>
            	<@select label="期望工作地点" name="workCity" required=true/>
            	<#--<@select label="健康状况" name="health" required=true/>-->
			</tr>
            <tr><@input label="现居住地址" name="currentResidence" required=true wide=true/></tr>
            <tr><@input label="家庭住址" name="familyResidence" required=true wide=true/></tr>
            <tr><@textarea label="持证情况" name="certificate" required=true/></tr>
            <tr><@textarea label="爱好特长" name="hobby" required=true/></tr>
            <tr><@textarea label="性格特点" name="personality"/></tr>
            <tr>
                <td colspan="2" style="text-align: center;">
                    <input type="reset" value="重置" class="reset">
                    <input type="submit" value="保存" class="submit">
                </td>
            </tr>
        </table>
	</@compress>';
</script>