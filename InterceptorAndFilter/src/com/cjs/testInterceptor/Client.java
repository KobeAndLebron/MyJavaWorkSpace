package com.cjs.testInterceptor;

import java.util.HashMap;
import java.util.Map;

import com.cjs.interceptor.factory.ActionsFactory;
import com.cjs.interceptor.inter.ActionProxy;

public class Client {
	public static void main(String[] args) {
		Map<String , String> actionConfigMap = new HashMap<>();
		actionConfigMap.put("actionName", "action1");
		actionConfigMap.put("methodName", "execute");
		actionConfigMap.put("actionClassPath", "com.cjs.interceptor.impl.Action1");
		
		actionConfigMap.put("interceptor1", "com.cjs.interceptor.factory.Interceptor1");
		
		ActionProxy p = ActionsFactory.createActionProxy(actionConfigMap);
		p.execute();
		p.execute();
	}
}



