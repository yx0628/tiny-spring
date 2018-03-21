package cn.yx.spring.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.yx.spring.BeanDefinition;

public abstract class AbstractBeanFactory implements BeanFactory{
	
	private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<String, BeanDefinition>();

	private List<String> beanNames = new ArrayList<String>();
	
	// 这里在注入的时候生成实例对象，可以改成懒加载，在获取bean的时候生成
	public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception{
		// Object bean = createBean(beanDefinition);
		// beanDefinition.setBean(bean);
		beanDefinitionMap.put(name, beanDefinition);
	}
	
	public Object getBean(String name) throws Exception{
		BeanDefinition beanDefinition = beanDefinitionMap.get(name);
		if(beanDefinition == null){
			throw new Exception("no beanDefinition defined by this name:" + name);
		}
		Object bean = beanDefinition.getBean();
		if(bean == null){
			bean = createBean(beanDefinition);
		}
		return bean;
	}
	
	// 预加载bean对象的调用方法
	public void preload() throws Exception{
		for(String name : beanNames){
			BeanDefinition beanDefinition = beanDefinitionMap.get(name);
			Object bean = createBean(beanDefinition);
			beanDefinition.setBean(bean);
		}
	}
	
	public abstract Object createBean(BeanDefinition beanDefinition) throws Exception;
	
}
