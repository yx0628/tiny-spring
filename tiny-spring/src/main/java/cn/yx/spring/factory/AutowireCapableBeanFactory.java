package cn.yx.spring.factory;

import java.lang.reflect.Field;

import cn.yx.spring.BeanDefinition;
import cn.yx.spring.BeanReference;
import cn.yx.spring.PropertyValue;

public class AutowireCapableBeanFactory extends AbstractBeanFactory{

	public Object createBean(BeanDefinition beanDefinition) throws Exception {
		Object bean = createBeanInstance(beanDefinition);
		beanDefinition.setBean(bean);
		applyPropertyValues(bean, beanDefinition);
		return bean;
	}

	public Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
		return beanDefinition.getBeanClass().newInstance();
	}

	public void applyPropertyValues(Object bean, BeanDefinition mbd) throws Exception {
		for (PropertyValue propertyValue : mbd.getPropertyValues().getPropertyValueList()) {
			Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
			declaredField.setAccessible(true);
			Object value = propertyValue.getValue();
			if(value instanceof BeanReference){
				BeanReference beanReference = (BeanReference)value;
				value = getBean(beanReference.getName());
			}
			declaredField.set(bean, value);
		}
	}
}
