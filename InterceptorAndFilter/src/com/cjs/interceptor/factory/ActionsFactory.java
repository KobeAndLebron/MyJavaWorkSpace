package com.cjs.interceptor.factory;

import java.util.Map;

import com.cjs.interceptor.impl.DefaultActionInvocation;
import com.cjs.interceptor.impl.DefaultActionProxy;
import com.cjs.interceptor.inter.ActionInvocation;
import com.cjs.interceptor.inter.ActionProxy;
import com.cjs.interceptor.inter.Interceptor;

public class ActionsFactory {
	private ActionsFactory(){
		
	}
	
	public static ActionProxy createActionProxy(Map<String , String> configMap){
		return new DefaultActionProxy(configMap);
	}
	
	public static  ActionInvocation createActionInvocation(ActionProxy actionProxy){
		try {
			return new DefaultActionInvocation(actionProxy);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Interceptor createInterceptor(String interceptorClassName){
		Class<?> clazz = null;
		Interceptor interceptor = null;
		try{
			clazz = Class.forName(interceptorClassName);
			interceptor = (Interceptor) clazz.newInstance();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return interceptor;
	}
}

class Interceptor1 implements com.cjs.interceptor.inter.Interceptor{

	public Interceptor1(){
		
	}
	@Override
	public String intercept(ActionInvocation actionInvocation) {
		long start = System.currentTimeMillis();
		
		String result = actionInvocation.invoke();
		
		long end = System.currentTimeMillis();
		
		System.out.println(actionInvocation.getActionProxy().getMethodName() + "的执行时间" + (end - start) + "ms");
		return result;
	}
	
}