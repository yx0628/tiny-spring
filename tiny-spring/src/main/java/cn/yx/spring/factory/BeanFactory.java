package cn.yx.spring.factory;

import cn.yx.spring.BeanDefinition;

public interface BeanFactory {
	
	void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
	
	Object getBean(String name) throws Exception;
	
}
