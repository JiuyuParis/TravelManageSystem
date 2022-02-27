package com.travles.travel.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travles.travel.entity.Result;
import com.travles.travel.entity.User;
import com.travles.travel.service.UserService;
import com.travles.travel.utils.VerifyCodeUtils;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "user")
@CrossOrigin//允许跨域请求
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
	/**
	 * 生成验证码
	 * @param response
	 * @param session
	 */
	@GetMapping(value="getVerifyImage")
	public Map<String, String> getVerifyImage(HttpServletRequest request) {
		Map<String,String> resultMap=new HashMap<String, String>();
		String verifyCodeString=VerifyCodeUtils.generateVerifyCode(4);//生成验证码字符串
		request.getSession().setAttribute("code", verifyCodeString);//将验证码设置到session中	，仅在同域可以这样验证
		String keyString=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//生成唯一id，用于标识
		request.getServletContext().setAttribute(keyString, verifyCodeString);
		ByteArrayOutputStream bos=new ByteArrayOutputStream();//进行64位编码，字节数组流
		String imageString=null;
		//生成验证码图片并相应到前端
		try {
			VerifyCodeUtils.outputImage(80, 40, bos, verifyCodeString);
			imageString=Base64Utils.encodeToString(bos.toByteArray());//64位编码
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultMap.put("key",keyString);
		resultMap.put("image", imageString);
		return resultMap;
	}
	/**
	 * 注册用户
	 * @param code
	 * @param key
	 * @param user
	 * @param request
	 * @return
	 */
	@PostMapping(value = "register")
	public Result register(String code,String key,@RequestBody User user,HttpServletRequest request) {
		Result result=new Result();
		System.out.println("接收到的验证码："+code);
		System.out.println("接收到的对象："+user);
		String codeRight=(String) request.getServletContext().getAttribute(key);
		System.out.println("正确的验证码为："+codeRight);
		try {
			if(code.equalsIgnoreCase(codeRight)) {
				userService.register(user);
				result.setStatus(true);
				result.setMsg("注册成功！");
			}else {
				throw new RuntimeException("验证码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}
	/**
	 * 用户登录
	 * @param code
	 * @param user
	 * @param session
	 * @return
	 */
	@PostMapping("login")
	public Result login(String code,@RequestBody User user,HttpSession session) {
		Result result=new Result();
		String codeRightString=(String) session.getAttribute("code");
		System.out.println("正确的验证码"+codeRightString);
		System.out.println("接收到的验证码："+code);
		System.out.println("接收到的对象："+user);
		try {
			if(code.equalsIgnoreCase(codeRightString)) {
				User userRight=userService.login(user);
				if(userRight==null) {
					result.setStatus(false);
				}else {
					session.setAttribute("user", userRight);//将用户信息设置到session中
					result.setStatus(true);
					result.setMsg("登陆成功");
					result.setUserName(userRight.getUsername());
				}
			}else {
				throw new RuntimeException("验证码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setStatus(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}	
}
