package com.travles.travel.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.travles.travel.entity.User;

public class LoginFilter implements Filter{
	private String[] excludedUris;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String param = filterConfig.getInitParameter("excludedUris");
        if (param!=null) {
            this.excludedUris = param.split(",");
        }

    }
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		System.out.println("已经进入登录检测过滤器！");
		// 定义表示变量 并验证用户请求URI 是否包含不过滤路径
        boolean flag = false;
        for (String uri:excludedUris) {
            if (req.getRequestURI().equals(uri)){
                flag = true;
            }
        }
        if(!flag) {
        	User user=(User) req.getSession().getAttribute("user");
        	if(user==null) {
        		resp.sendRedirect(req.getContextPath()+"/login.html");
        		return;
        	}
        }
        chain.doFilter(request, response);//拦截完让程序继续执行
	}

}
