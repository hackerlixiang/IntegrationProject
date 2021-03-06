package com.myproject.www.bean;

import java.util.Date;

import com.myproject.www.utils.validate.RegexType;
import com.myproject.www.utils.validate.annon.Validate;

/**
 * 管理员Bean
 * 
 * @author lixiang
 * @Version 1.0
 * @Time 2017年2月9日 下午5:41:03
 */
public class AdminBean extends BaseBean {
	
	/** 管理员ID */
	private Long id;

	/** 用户名 */
	@Validate(minLength=6,maxLength=15)
	private String username;

	/** 密码 */
	@Validate(minLength=6,maxLength=15,regexExpression = "^(?![^A-Za-z]+$)(?![^0-9]+$)[0-9a-zA-Z_]+$")
	private String password;

	/** 名称 */
	@Validate(regexType = RegexType.CHINESE)
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

	/** 注册IP */
	@Validate(regexType = RegexType.IP)
	private String registIp;

	/** 头像 */
	private String headPortrait;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

}
