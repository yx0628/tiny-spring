package cn.yx.spring;

import org.junit.Test;

import cn.yx.spring.factory.AutowireCapableBeanFactory;
import cn.yx.spring.factory.BeanFactory;

public class BeanFactoryTest {

	@Test
	public void test() throws Exception{
		// 创建工厂
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		
		// 提供类名
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName("cn.yx.spring.TestService");
		
		// 属性的添加
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("text","xxx"));
		beanDefinition.setPropertyValues(propertyValues);
		
		// 注入
		beanFactory.registerBeanDefinition("testService", beanDefinition);
		
		// Bean的获取
		TestService testService = (TestService) beanFactory.getBean("testService");
		testService.print();
	}
	
}
