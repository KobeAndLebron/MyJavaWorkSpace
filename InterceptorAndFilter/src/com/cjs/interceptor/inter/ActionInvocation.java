package com.cjs.interceptor.inter;

/**
 * Action�ĵ����ߣ�������������Action
 * @author Chen
 *
 */
public interface ActionInvocation {
	public String invoke();
	public ActionProxy getActionProxy();
}
