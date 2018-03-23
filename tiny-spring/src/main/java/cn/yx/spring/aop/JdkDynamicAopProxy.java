package cn.yx.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;

public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

	public AdviceSupport adviceSupport;

	public JdkDynamicAopProxy(AdviceSupport adviceSupport) {
		this.adviceSupport = adviceSupport;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		MethodInterceptor methodInterceptor = adviceSupport.getMethodInterceptor();
		return methodInterceptor.invoke(new ReflectiveMethodInvocation(adviceSupport.getTargetSource().getTarget(), method, args));
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class[] { adviceSupport.getTargetSource().getTargetClass() }, this);
	}

}
