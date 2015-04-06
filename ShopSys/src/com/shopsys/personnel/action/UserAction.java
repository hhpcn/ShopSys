package com.shopsys.personnel.action;

import java.util.Map;

import com.shopsys.personnel.model.User;
import com.shopsys.personnel.service.UserService;
import com.xmut.base.BaseAction;
import com.xmut.util.WebUtil;

/**
 * @author hhp
 *
 */
public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5966619251987791667L;
	private UserService userService;
	private String username;//用户名
	private String password;//密码
	
	private String page;
	private String rows;

	
	

	
	
	public String login() {
	System.out.println("login");
		if (username.equals("admin")&&password.equals("123456")) {
			System.out.println(username+": "+password);
			User user = new User();
			user.setUserName("admin");
			WebUtil.add2Session(WebUtil.KEY_LOGIN_USER_SESSION, user);
			return "loginsuccess";
		}
		return "error";
	}
	
	
	public String listUsers() {
		System.out.println(page);
		System.out.println(rows);
		
		return "list";
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}


	
}
