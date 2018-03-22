package cn.yx.spring.context;

import java.util.Map;

import cn.yx.spring.BeanDefinition;
import cn.yx.spring.factory.AbstractBeanFactory;
import cn.yx.spring.factory.AutowireCapableBeanFactory;
import cn.yx.spring.xml.XmlBeanDefinitionReader;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

	private String location;
	
	public ClassPathXmlApplicationContext(String location) throws Exception{
		this(location, new AutowireCapableBeanFactory());
	}
	
	public ClassPathXmlApplicationContext(String location, AbstractBeanFactory beanFactory) throws Exception{
		super(beanFactory);
		this.location = location;
		process();
	}

	private void process() throws Exception {
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader();
		xmlBeanDefinitionReader.loadXmlBeanDefinition(location);
		for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getBeanDefinitionMap().entrySet()) {
			beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
		}
	}
}
