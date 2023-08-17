package com.springmvc.xml;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;

// 用来解析SpringMvc.xml配置文件
public class XmlParser {
    public static String getBasePackage(String contextConfigLocation) {
        try{
            SAXReader saxReader = new SAXReader();
            InputStream inputStream = XmlParser.class.getClassLoader().getResourceAsStream(contextConfigLocation);
            // XML 文档对象
            Document document = saxReader.read(inputStream);
            Element rootElement = document.getRootElement();
            Element componentScanElement = rootElement.element("component-scan");
            return componentScanElement.attribute("base-package").getText();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return "";
    }
}
