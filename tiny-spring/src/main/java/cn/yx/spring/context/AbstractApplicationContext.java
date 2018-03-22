package cn.yx.spring.context;

import cn.yx.spring.factory.AbstractBeanFactory;

public abstract class AbstractApplicationContext implements ApplicationContext {
	
	protected AbstractBeanFactory beanFactory;
	
	public AbstractApplicationContext(AbstractBeanFactory beanFactory){
		this.beanFactory = beanFactory;
	}

	public Object getBean(String name) throws Exception {
		return beanFactory.getBean(name);
	}

}
