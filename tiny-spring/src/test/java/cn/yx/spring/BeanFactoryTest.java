package cn.yx.spring;

import org.junit.Test;

public class BeanFactoryTest {

	@Test
	public void test(){
		// 创建工厂
		BeanFactory beanFactory = new BeanFactory();
		
		// Bean的注入
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBean(new TestService());
		beanFactory.registerBeanDefinition("testService", beanDefinition);
		
		// Bean的获取
		TestService testService = (TestService) beanFactory.getBean("testService");
		testService.print();
	}
	
}
