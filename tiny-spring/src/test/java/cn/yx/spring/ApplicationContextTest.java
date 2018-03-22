package cn.yx.spring;

import org.junit.Test;

import cn.yx.spring.context.ApplicationContext;
import cn.yx.spring.context.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

	@Test
	public void test() throws Exception{
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestService testService = (TestService) context.getBean("testService");
		testService.print();
	}
	
}
