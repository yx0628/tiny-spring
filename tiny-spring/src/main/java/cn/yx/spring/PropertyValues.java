package cn.yx.spring;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	
	private List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();
	
	public void addPropertyValue(PropertyValue propertyValue){
		propertyValueList.add(propertyValue);
	}

	public List<PropertyValue> getPropertyValueList() {
		return propertyValueList;
	}

	public void setPropertyValueList(List<PropertyValue> propertyValueList) {
		this.propertyValueList = propertyValueList;
	}

}
