package cn.aki.test;

import java.awt.Color;

import org.patchca.color.SingleColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.word.AdaptiveRandomWordFactory;

public class CaptchaTest {
	public static void main(String[] args) throws Exception{
		ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
        cs.setColorFactory(new SingleColorFactory(new Color(25, 60, 170)));
        cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
        AdaptiveRandomWordFactory wordFactory=new AdaptiveRandomWordFactory();
        //4到6位
        wordFactory.setMinLength(4);
        wordFactory.setMaxLength(4);
        cs.setWordFactory(wordFactory);
        Captcha captcha=cs.getCaptcha();
        System.err.println(captcha.getChallenge());
	}
}
