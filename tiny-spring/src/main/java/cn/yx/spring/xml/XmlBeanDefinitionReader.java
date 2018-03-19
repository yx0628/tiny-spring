package cn.yx.spring.xml;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cn.yx.spring.BeanDefinition;
import cn.yx.spring.PropertyValue;
import cn.yx.spring.PropertyValues;
import cn.yx.spring.io.UrlResource;

public class XmlBeanDefinitionReader {
	
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
	
	public void loadXmlBeanDefinition(String location) throws Exception{
		// 获取输入流
		URL url = getClass().getClassLoader().getResource(location);
		UrlResource urlResource = new UrlResource(url);
		InputStream inputStream = urlResource.getInputStream();
		
		// xml读取
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document doc = documentBuilder.parse(inputStream);
		
		// 根节点
		Element root = doc.getDocumentElement();
		parseXmlElement(root);
		
		inputStream.close();
		
	}

	private void parseXmlElement(Element root) {
		NodeList nodeList = root.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node instanceof Element){
				Element ele = (Element)node;
				processBeanDefinition(ele);
			}
		}
	}

	private void processBeanDefinition(Element ele) {
		String name = ele.getAttribute("name");
		String className = ele.getAttribute("class");
		BeanDefinition beanDefinition = new BeanDefinition();
		beanDefinition.setBeanClassName(className);
		// 属性赋值
		processPropertyValue(ele, beanDefinition);
		beanDefinitionMap.put(name, beanDefinition);
	}

	private void processPropertyValue(Element ele, BeanDefinition beanDefinition) {
		NodeList nodeList = ele.getElementsByTagName("property");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if(node instanceof Element){
				Element propertyEle = (Element)node;
				String name = propertyEle.getAttribute("name");
				String value = propertyEle.getAttribute("value");
				PropertyValues propertyValues = new PropertyValues();
				propertyValues.addPropertyValue(new PropertyValue(name, value));
				beanDefinition.setPropertyValues(propertyValues);
			}
		}
	}

	public Map<String, BeanDefinition> getBeanDefinitionMap() {
		return beanDefinitionMap;
	}

}
