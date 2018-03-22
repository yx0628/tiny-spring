package cn.yx.spring;

import java.util.Map;

import org.junit.Test;

import cn.yx.spring.factory.AbstractBeanFactory;
import cn.yx.spring.factory.AutowireCapableBeanFactory;
import cn.yx.spring.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {

	@Test
	public void testLazy() throws Exception{
		
		// 读取xml
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader();
		xmlBeanDefinitionReader.loadXmlBeanDefinition("applicationContext.xml");
		
		// 创建工厂并注入(此时对象没有实例化)
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getBeanDefinitionMap().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
		
		// Bean的获取(在getBean方法中实例化对象)
		TestService testService = (TestService) beanFactory.getBean("testService");
		testService.print();
	}
	
	@Test
	public void testPreLoading() throws Exception {
		// 读取xml
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader();
		xmlBeanDefinitionReader.loadXmlBeanDefinition("applicationContext.xml");

		// 创建工厂
		AbstractBeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getBeanDefinitionMap()
				.entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
		
		// 预加载(实例化对象)
		beanFactory.preload();

		// Bean的获取
		TestService testService = (TestService) beanFactory.getBean("testService");
		testService.print();
	}
	
}
