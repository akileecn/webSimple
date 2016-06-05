package cn.aki.test.template;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class IdNoTest {

	@Test
	public void test(){
		String idNo="140524197506121047";
		System.err.println(validate(idNo));
		
	}
	
	private boolean validate(String idNo){
		if(idNo!=null&&idNo.matches("\\d{17}[0-9xX]")){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String datePart=idNo.substring(6, 14);
			try {
				//时间校验
				sdf.parse(datePart);
			} catch (ParseException e) {
				return false;
			}
			//最后一维校验
			int[] b={7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
			char[] lasts={'1','0','X','9','8','7','6','5','4','3','2'};
			int sum=0;
			Integer a=null;
			for(int i=0;i<b.length;i++){
				a=Integer.parseInt(idNo.substring(i, i+1));
				sum+=a*b[i];
			}
			char last=lasts[sum%11];
			return idNo.charAt(17)==last;
		}
		return false;
	}
}
