package com.cjs.interceptor.inter;

import java.util.Map;

/**
 * Action�Ĵ�����
 * @author Chen
 *
 */
public interface ActionProxy {
	public String getActionName();
	public String getActionClassPath();
	public String getMethodName();
	public Map<String , String> getActionConfigMap();
	public String execute();
}
