package cn.yx.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import cn.yx.spring.TestService;
import cn.yx.spring.context.ApplicationContext;
import cn.yx.spring.context.ClassPathXmlApplicationContext;

public class AopTest {
	
	@Test
	public void test() throws Exception{
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService testService = (TestService) applicationContext.getBean("testService");
		testService.print();
		
		// 设置连接点
		AdviceSupport adviceSupport = new AdviceSupport();
		TargetSource targetSource = new TargetSource(testService, TestService.class);
		adviceSupport.setTargetSource(targetSource);
		
		// 设置增强
		LoggerInterceptor methodInterceptor = new LoggerInterceptor();
		adviceSupport.setMethodInterceptor(methodInterceptor);
		
		// 代理
		JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(adviceSupport);
		TestService testServiceProxy = (TestService) jdkDynamicAopProxy.getProxy();
		
		testServiceProxy.print();
	}

}
