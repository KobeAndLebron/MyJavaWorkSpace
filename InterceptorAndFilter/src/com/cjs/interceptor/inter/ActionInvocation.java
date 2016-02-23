package com.cjs.interceptor.inter;

/**
 * Action的调度者，即包含真正的Action
 * @author Chen
 *
 */
public interface ActionInvocation {
	public String invoke();
	public ActionProxy getActionProxy();
}
