package cn.yx.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggerInterceptor implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("logger...before");
		Object proceed = invocation.proceed();
		System.out.println("logger...after");
		return proceed;
	}

}
