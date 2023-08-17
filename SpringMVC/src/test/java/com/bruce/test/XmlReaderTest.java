package com.bruce.test;

import com.springmvc.xml.XmlParser;
import org.junit.Test;


public class XmlReaderTest {
    @Test
    public void testReadBasePackage(){
        String basePackage = XmlParser.getBasePackage("springmvc.xml");
        System.out.println(basePackage);
    }
}
