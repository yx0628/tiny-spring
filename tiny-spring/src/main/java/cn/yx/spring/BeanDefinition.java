package cn.yx.spring;

/**
 * BeanDefinition对真实对象bean进行了封装
 */
public class BeanDefinition {

	private Object bean;

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}
	
}
