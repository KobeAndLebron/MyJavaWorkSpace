package com.cjs.interceptor.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cjs.interceptor.factory.ActionsFactory;
import com.cjs.interceptor.inter.ActionInvocation;
import com.cjs.interceptor.inter.ActionProxy;
import com.cjs.interceptor.inter.Interceptor;
import com.cjs.testInterceptor.Action;

public class DefaultActionInvocation implements ActionInvocation{
	private Object action;
	private List<Interceptor> interceptorList;
	private int interceptorIndex = 0;
	private int interceptorIndex1;
	private ActionProxy actionProxy;
	
	public DefaultActionInvocation(ActionProxy actionProxy) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		this.actionProxy = actionProxy;
		this.interceptorList = createrInterceptorbyConfigMap(actionProxy.getActionConfigMap());
		interceptorIndex1 = this.interceptorList.size();
		this.action = createAction(actionProxy);
	}
	private Object createAction(ActionProxy actionProxy) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String actionClassPathName = actionProxy.getActionClassPath();
		return Class.forName(actionClassPathName).newInstance();
	}
	
	/**
	 * 通过actionConfingMap来创建拦截器栈
	 * @param configMap
	 * @return
	 */
	private List<Interceptor> createrInterceptorbyConfigMap(Map<String, String> configMap) {
		List<Interceptor> list = new ArrayList<>();
		Iterator<Map.Entry<String, String>> iterator = configMap.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> entry = iterator.next();
			String key = entry.getKey();
			if(key.indexOf("interceptor") >= 0){
				list.add(ActionsFactory.createInterceptor(entry.getValue()));
			}
		}
		return list;
	}
	
	public String invoke() {
		String result = null;
		if(this.interceptorIndex < this.interceptorList.size()){
			result = this.interceptorList.get(this.interceptorIndex++).intercept(this);
		}else{
			result = invokeActionOnly(this.action , this.actionProxy.getMethodName());
		}
		
		countInterceptorIndex();
		
		return result;
	}
	
	/**
	 * 重置interceptorIndex
	 */
	private void countInterceptorIndex() {
		if(this.interceptorIndex1-- == 0){
			this.interceptorIndex = 0;
		}
	}
	
	/**
	 * 当没有拦截器栈的时候，只需要执行action
	 * @param action
	 * @param methodName
	 * @return
	 */
	private String invokeActionOnly(Object action, String methodName) {
		Method invokeMethod = null;
		String result = null;
		try {
			invokeMethod = action.getClass().getMethod(methodName, new Class[]{});
			result = (String) invokeMethod.invoke(action, new Object[]{});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public ActionProxy getActionProxy() {
		return this.actionProxy;
	}

}


class Action1 implements Action{
	public Action1(){
		
	}
	@Override
	public String execute() {
		System.out.println("execute");
		return "aa";
	}
	
}