package com.travles.travel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.travles.travel.interceptor.UserInterceptor;
@Configuration //定义此类为配置文件类
public class MvcConfig implements WebMvcConfigurer{
	private String[] addPathPatterns= {"/user/**","/province/**","/place/**"};//要拦截的路径
	private String[] excludePathPatterns= {"/login.html","/reg.html"};//要排除的路径
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
	}
	
	/**
	 * 将页面重定向
	 * @return
	 */
	@Bean
	public WebMvcConfigurer redirectConfigurer() {
		//创建一个WebMvcConfigurer对象
		WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				//将路径重定向
				registry.addViewController("/").setViewName("login");
			}
			
		};
		return webMvcConfigurer;
	}
}
