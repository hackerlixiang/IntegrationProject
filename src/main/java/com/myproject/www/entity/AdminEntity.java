package com.myproject.www.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.www.utils.DictionaryUtils;
import com.myproject.www.utils.StringUtils;

/**
 * 管理员Entity
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class AdminEntity extends BaseEntity {

	/** serialVersionUID */
	private static final long serialVersionUID = 5888524617375324430L;
	
	/** 用户名 */
	private String username;
	
	/** 密码 */
	private String password;

	/** 姓名 */
	private String name;

	/** 昵称 */
	private String nickName;
	
	/** 生日 */
	private Date birthday;

	/** 年龄 */
	private Integer age;
	
	/** 性别 */
	private String sex;

	/** 身份证 */
	private String idCard;
	
	/** email */
	private String email;
	
	/** 手机号 */
	private String mobile;

	/** 注册IP */
	private String registIp;

	/** 登录IP */
	private String loginIp;

	/** 头像 */
	private String headPortrait;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRegistIp() {
		return registIp;
	}

	public void setRegistIp(String registIp) {
		this.registIp = registIp;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	//================================================JSON====================================================
	@JsonProperty("name")
	public String getNameToJson() {
		return StringUtils.getStringByObject(getName());
	}

	@JsonProperty("username")
	public String getUsernameToJson() {
		return StringUtils.getStringByObject(getUsername());
	}

	@JsonProperty("nickName")
	public String getNickNameToJson() {
		return StringUtils.getStringByObject(getNickName());
	}

	@JsonProperty("age")
	public String getAgeToJson() {
		return StringUtils.getStringByObject(getAge());
	}

	@JsonProperty("sex")
	public String getSexToJson() {
		return DictionaryUtils.getNameByCode(getSex());
	}
	
	@JsonProperty("mobile")
	public String getMobileToJson() {
		return StringUtils.getStringByObject(getMobile());
	}
	
	@Override
	public String toString() {
		String superToString = super.toString();
		String thisToString = "AdminEntity [username=" + username + ", password=" + password + ", name=" + name + ", nickName=" + nickName + ", birthday="
				+ birthday + ", age=" + age + ", sex=" + sex + ", idCard=" + idCard + ", email=" + email + ", mobile=" + mobile
				+ ", registIp=" + registIp + ", loginIp=" + loginIp + ", headPortrait=" + headPortrait + "]";
		return superToString+"|"+thisToString;
	}
	
	

}
