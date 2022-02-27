package com.travles.travel.config;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.travles.travel.filter.LoginFilter;

//@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean<Filter> myFilterRegistrationBean(){
		FilterRegistrationBean<Filter> filterRegistrationBean=new FilterRegistrationBean<>(new LoginFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("excludedUris", "/travel/login.html,/travel/reg.html,/travel/user/*");
		return filterRegistrationBean;
	}
}
