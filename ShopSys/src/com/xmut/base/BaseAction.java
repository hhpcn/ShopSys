package com.xmut.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
public class BaseAction extends ActionSupport{
	private static final long serialVersionUID = 2817071984746760965L;
	protected Map<String, Object> dataMap;
	protected BaseService baseService;
	protected JsonResult json=new JsonResult();
	public JsonResult getJson() {
		return json;
	}
	public void setJson(JsonResult json) {
		this.json = json;
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
	
	
	
	protected class JsonResult implements Serializable{
		private static final long serialVersionUID = -8483874375183014284L;
		private Object msg;
		private boolean isSuccess=false;
		public Object getMsg() {
			return msg;
		}
		public void setMsg(Object msg) {
			this.msg = msg;
		}
		public boolean isSuccess() {
			return isSuccess;
		}
		public void setSuccess(boolean isSuccess) {
			this.isSuccess = isSuccess;
		}
	}
}
