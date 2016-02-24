package com.qiu.module;

/*
 * 用户名和密码的POJO类
 */

public class UsersInfo {

	private String mName;
	private String mPwd;
	private int mId;
	
	public int getId() {
		return mId;
	}
	
	public void setId(int id) {
		this.mId = id;
	}
	
	public String getName() {
		return mName;
	}
	public void setName(String mName) {
		this.mName = mName;
	}
	public String getPwd() {
		return mPwd;
	}
	public void setPwd(String mPwd) {
		this.mPwd = mPwd;
	}
	
	
}
