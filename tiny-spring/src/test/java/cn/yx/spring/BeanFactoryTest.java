package cn.yx.spring;

import org.junit.Test;

import cn.yx.spring.factory.AutowireCapableBeanFactory;
import cn.yx.spring.factory.BeanFactory;

public class BeanFactoryTest {

	@Test
	public void test() throws Exception{
		// 创建工厂
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		// Bean的注入 这里不再需要对象来进行注入，提供类名即可，在工厂中创建对象并注入
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("cn.yx.spring.TestService");
		beanFactory.registerBeanDefinition("testService", beanDefinition);
		
		// Bean的获取
		TestService testService = (TestService) beanFactory.getBean("testService");
		testService.print();
	}
	
}
