package cn.yx.spring.factory;

import cn.yx.spring.BeanDefinition;

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

	@Override
	public Object createBean(BeanDefinition beanDefinition) throws Exception {
		Object bean = beanDefinition.getBeanClass().newInstance();
		return bean;
	}

}
