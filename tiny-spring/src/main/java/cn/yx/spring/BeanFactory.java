package cn.yx.spring;

import java.util.HashMap;
import java.util.Map;

public class BeanFactory {

	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
	
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition){
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	public Object getBean(String name){
		return beanDefinitionMap.get(name).getBean();
	}
	
}
