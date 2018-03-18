package cn.yx.spring.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.yx.spring.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory{
	
private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();
	
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception{
		Object bean = createBean(beanDefinition);
		beanDefinition.setBean(bean);
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	public Object getBean(String name){
		return beanDefinitionMap.get(name).getBean();
	}
	
	public abstract Object createBean(BeanDefinition beanDefinition) throws Exception;
	
}
