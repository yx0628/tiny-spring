package cn.yx.spring;

import java.util.Map;

import org.junit.Test;

import cn.yx.spring.factory.AutowireCapableBeanFactory;
import cn.yx.spring.factory.BeanFactory;
import cn.yx.spring.xml.XmlBeanDefinitionReader;

public class BeanFactoryTest {

	@Test
	public void test() throws Exception{
		
		// 读取xml
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader();
		xmlBeanDefinitionReader.loadXmlBeanDefinition("applicationContext.xml");
		
		// 创建工厂并注入
		BeanFactory beanFactory = new AutowireCapableBeanFactory();
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getBeanDefinitionMap().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
		
		// Bean的获取
		TestService testService = (TestService) beanFactory.getBean("testService");
		testService.print();
		
	}
	
}
