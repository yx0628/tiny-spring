package cn.yx.spring.aop;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInvocation;

public class ReflectiveMethodInvocation implements MethodInvocation{
	
	private Object target;
	
	private Method method;
	
	private Object[] args;
	
	public ReflectiveMethodInvocation(Object target, Method method, Object[] args) {
		this.target = target;
		this.method = method;
		this.args = args;
	}

	public Object[] getArguments() {
		return args;
	}

	public AccessibleObject getStaticPart() {
		return method;
	}

	public Object getThis() {
		return target;
	}

	public Object proceed() throws Throwable {
		return method.invoke(target, args);
	}

	public Method getMethod() {
		return method;
	}

}
