package com.wsh.framework.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * 
	 * 日志拦截器
	 */
	@Autowired


	// 重写添加拦截器方法并添加配置拦截器

	@Override

	public void addInterceptors(InterceptorRegistry registry) {

		List excludePatternsList = new ArrayList<>();
		// 静态资源放开不拦截

		excludePatternsList.add("/static/**");

		excludePatternsList.add("/favicon.ico");

		excludePatternsList.add("*.css");

		excludePatternsList.add("*.js");

		excludePatternsList.add("*.jpg");

		excludePatternsList.add("*.png");

		// 日志拦截器
		registry.addInterceptor(null).addPathPatterns("/**").excludePathPatterns(excludePatternsList);

	}

	/**
	 * 
	 * 跨域配置
	 * 
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.mediaType("json", MediaType.APPLICATION_JSON);
		configurer.mediaType("xml", MediaType.APPLICATION_XML);
	}

	/**
	 * 
	 * 配置静态资源映射
	 * 
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

}
