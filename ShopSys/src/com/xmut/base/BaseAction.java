package com.xmut.base;

import java.util.Map;



import com.opensymphony.xwork2.ActionSupport;
public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 2817071984746760965L;
	public Map<String, Object> dataMap;
	public Boolean flag=false;
	protected BaseService baseService;
	
	
	
	public BaseService getBaseService() {
		return baseService;
	}

	public void setBaseService(BaseService baseService) {
		this.baseService = baseService;
	}
	
	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	
	
}
