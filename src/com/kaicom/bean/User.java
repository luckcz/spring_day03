package com.kaicom.bean;

public class User {
	private Integer uid ;
	private String uname ;
	private Integer uage ;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public Integer getUage() {
		return uage;
	}
	public void setUage(Integer uage) {
		this.uage = uage;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uage=" + uage + "]";
	}
	
}
