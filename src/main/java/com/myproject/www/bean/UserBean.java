package com.myproject.www.bean;

import java.util.Date;

import com.myproject.www.utils.validate.RegexType;
import com.myproject.www.utils.validate.annon.Validate;

public class UserBean extends BaseBean {

	@Validate(minLength=6,maxLength=15)
	/** 用户名 */
	private String username;

	@Validate(minLength=6,maxLength=15,regexExpression = "^(?![^A-Za-z]+$)(?![^0-9]+$)[0-9a-zA-Z_]+$")
	/** 密码 */
	private String password;

	@Validate(regexType = RegexType.CHINESE)
	/** 名称 */
	private String name;

	/** 昵称 */
	private String nickName;
	
	/** 生日 */
	private Date birthday;

	/** 年龄 */
	@Validate(regexType = RegexType.NUMBER)
	private Integer age;

	/** 性别 */
	private String sex;

	/** 身份证 */
	@Validate(regexType = RegexType.ID_CARD)
	private String idCard;

	/** email */
	@Validate(regexType = RegexType.EMAIL)
	private String email;

	/** 手机号 */
	@Validate(regexType = RegexType.MOBILE)
	private String mobile;

	/** 家庭住址 */
	private String homeAddress;

	/** 注册IP */
	@Validate(regexType = RegexType.IP)
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

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
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

}
