package com.cjs.interceptor.impl;

import java.util.Map;

import com.cjs.interceptor.factory.ActionsFactory;
import com.cjs.interceptor.inter.ActionInvocation;
import com.cjs.interceptor.inter.ActionProxy;

public class DefaultActionProxy implements ActionProxy{
	/**
	 * 这几项属性从配置文件中加载
	 */
	private String actionName;
	private String actionClassPath;
	private String methodName;
	/**
	 * 包括interceptor、action的相关信息
	 */
	private Map<String , String> actionConfigMap;
	
	/**
	 * 由ActionFactory产生;
	 */
	private ActionInvocation actionInvocation;
	
	public DefaultActionProxy(Map<String , String> configMap){
		this.actionName = configMap.get("actionName");
		this.actionClassPath = configMap.get("actionClassPath");
		this.methodName = configMap.get("methodName");
		this.actionConfigMap = configMap;
		
		// 初始化actionInvocation
		init();
	}
	
	private void init() {
		this.actionInvocation = ActionsFactory.createActionInvocation(this);
	}
	
	public String getActionName() {
		return this.actionName;
	}

	public String getActionClassPath() {
		return this.actionClassPath;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public String execute() {
		return this.actionInvocation.invoke();
	}

	public Map<String, String> getActionConfigMap() {
		return this.actionConfigMap;
	}
}
