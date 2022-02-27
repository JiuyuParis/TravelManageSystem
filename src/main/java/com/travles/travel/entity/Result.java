package com.travles.travel.entity;
/**
 * 状态结果封装
 * @author Jiuyu
 *
 */
public class Result {
	private boolean status;
	private String msg;
	private String userName;
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Result(boolean status, String msg) {
		super();
		this.status = status;
		this.msg = msg;
	}
	public Result() {
		super();
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
