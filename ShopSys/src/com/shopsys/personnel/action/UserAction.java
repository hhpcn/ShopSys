package com.shopsys.personnel.action;

import java.util.HashMap;
import java.util.List;
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
	private Boolean _search;
	private String nd;
	private String sidx;
	private String sord;

	
	

	
	
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
		dataMap=new HashMap<String, Object>();
		int currentPage=Integer.parseInt(page);
		int pageSize=Integer.parseInt(rows);
		List<User> users=userService.listPageRowsByClass(User.class, currentPage, pageSize);
		dataMap.put("rows", users);
		
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


	public Boolean get_search() {
		return _search;
	}


	public void set_search(Boolean _search) {
		this._search = _search;
	}


	public String getNd() {
		return nd;
	}


	public void setNd(String nd) {
		this.nd = nd;
	}


	public String getSidx() {
		return sidx;
	}


	public void setSidx(String sidx) {
		this.sidx = sidx;
	}


	public String getSord() {
		return sord;
	}


	public void setSord(String sord) {
		this.sord = sord;
	}


	
}
