package com.shopsys.personnel.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.mapping.Value;

import sun.org.mozilla.javascript.internal.IdScriptableObject;

import net.sf.json.JSONObject;

import com.shopsys.common.FilterSearch;
import com.shopsys.common.JqgridUtil;
import com.shopsys.common.SearchRule;


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
	private String userName;//用户名
	private String password;//密码
    private String id;
    private String roleName;
    private String status;
	private User user;
	
	

	private String filters;//条件搜索
	private String searchField;		//单字段查询的时候，查询字段名称
	private String searchString;	//单字段查询的时候，查询字段的值
	private String searchOper;		//单字段查询的时候，查询的操作
	private String oper;//编辑表格行时，传过来的操作类型。
	
	

	
	

	public String login() {
	System.out.println("login");
		if (userName.equals("admin")&&password.equals("123456")) {
			System.out.println(userName+": "+password);
			User user = new User();
			user.setUserName("admin");
			WebUtil.add2Session(WebUtil.KEY_LOGIN_USER_SESSION, user);
			return "loginsuccess";
		}
		return "error";
	}
	
	/**
	 * 查询用户数据，包括条件分页搜索和非条件分页搜索两种
	 * @return
	 */
	public String listUsers() {
		dataMap=new HashMap<String, Object>();
		int currentPage=Integer.parseInt(page);
		int pageSize=Integer.parseInt(rows);
		List<User> users =null;
		List<Map<String, Object>> userMaps = new ArrayList<Map<String, Object>>();
		int allRecordNumbers=0;
		
		if (_search) {
			String whereParams = JqgridUtil.SearchToHqlParam(null, null, null, filters, null, null, null);
			users=userService.listPageRowsByClassAndParams(User.class, currentPage, pageSize, whereParams);
			allRecordNumbers=userService.countByClassAndParams(User.class, whereParams);
			dataMap.put("total", JqgridUtil.countPageNumbers(pageSize, allRecordNumbers));//总页数
			dataMap.put("records", allRecordNumbers);//总记录数
		}else {
			allRecordNumbers=userService.countByClass(User.class);
		    users=userService.listPageRowsByClass(User.class, currentPage, pageSize);
			dataMap.put("total", JqgridUtil.countPageNumbers(pageSize, allRecordNumbers));//总页数
			dataMap.put("records", allRecordNumbers);//总记录数
		}
		for (User user : users) {
			Map<String, Object> userMap= new HashMap<String, Object>();
			userMap.put("userName", user.getUserName());
			userMap.put("id", user.getId());
			userMap.put("roleName", user.getRoleName());
			userMap.put("status", user.getStatus());
			userMaps.add(userMap);
		}
	
		dataMap.put("rows", userMaps);
	
		
		
		return "list";
	}
	

	//行编辑：更新，删除
	public String edit() {
		
		Integer[] intIds = JqgridUtil.idToIntIds(id);
		
		
		if ("edit".equalsIgnoreCase(oper)) {
			//在某一时刻编辑时只有一行记录能被编辑，浏览器发送过看来的ids只有一个id，所以这里直接去intIds[0]
			User userData= userService.getByClassNameAndId(User.class, intIds[0]);
			userData.setUserName(userName);
			userData.setStatus(status);
			userData.setRoleName(roleName);
			userService.update(userData);
			flag=true;
			
		}else if ("del".equalsIgnoreCase(oper)) {
			userService.deleteByClassAndIds(User.class, intIds);
			flag=true;
		}

		return "flag";
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public String getFilters() {
		return filters;
	}
	public String getStr() {
		return str;
	}


	public void setStr(String str) {
		this.str = str;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	public void setFilters(String filters) {
		this.filters = filters;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}
