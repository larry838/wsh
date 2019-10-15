package com.wsh.framework.config;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import com.wsh.framework.kaptcha.KaptchaConstant;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

//@Configuration
public class KaptchaConfig {

	@Bean(name = "captchaProducer")
    public DefaultKaptcha captchaProducer() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 是否有边框 默认为true 可以自己设置yes，no
        properties.setProperty(Constants.KAPTCHA_BORDER, "no");
        // 边框颜色   默认为Color.BLACK  
       // properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "105,179,90");
        // 验证码文本字符颜色  默认为Color.BLACK 
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");
       // 验证码文本字符大小  默认为40
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "32");
        // 验证码文本字体样式  默认为new Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize) 
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
        // 验证码文本字符长度  默认为5
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "4");
        // 验证码文本字符间距  默认为2
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "3");
        // 验证码噪点颜色   默认为Color.BLACK
        properties.setProperty(Constants.KAPTCHA_NOISE_COLOR, "white");       

        // 验证码图片宽度  默认为200 
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "116");
        // 验证码图片高度  默认为50
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "36");
        // KAPTCHA_SESSION_KEY
        properties.setProperty(Constants.KAPTCHA_SESSION_CONFIG_KEY, KaptchaConstant.KAPTCHA_SESSION_KEY);
        //内容
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, KaptchaConstant.TEXT_CHAR_STRING);
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
    
    @Bean(name = "captchaProducerMath")
    public DefaultKaptcha getKaptchaBeanMath()
    {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 是否有边框 默认为true 可以自己设置yes，no
        properties.setProperty(Constants.KAPTCHA_BORDER, "no");
        // 边框颜色   默认为Color.BLACK  
       // properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "105,179,90");
        // 验证码文本字符颜色 默认为Color.BLACK
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "blue");
        // 验证码文本字符大小 默认为40
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "35");
        // 验证码文本字体样式 默认为new Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize)
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "Arial,Courier");
        // 验证码文本字符长度 默认为5
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "6");
        // 验证码文本字符间距 默认为2
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_CHAR_SPACE, "3");
        // 验证码噪点颜色 默认为Color.BLACK
        properties.setProperty(Constants.KAPTCHA_NOISE_COLOR, "white");       
        // 验证码图片宽度 默认为200
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "160");
        // 验证码图片高度 默认为50
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "60");

        // KAPTCHA_SESSION_KEY
        properties.setProperty(Constants.KAPTCHA_SESSION_CONFIG_KEY, KaptchaConstant.KAPTCHA_MATH_SESSION_KEY);
        // 验证码文本生成器
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_IMPL, "com.wsh.framework.kaptcha.KaptchaArithmeticCreator");
        // 干扰实现类
        properties.setProperty(Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        // 图片样式 水纹com.google.code.kaptcha.impl.WaterRipple 鱼眼com.google.code.kaptcha.impl.FishEyeGimpy 阴影com.google.code.kaptcha.impl.ShadowGimpy
        properties.setProperty(Constants.KAPTCHA_OBSCURIFICATOR_IMPL, "com.google.code.kaptcha.impl.ShadowGimpy");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
