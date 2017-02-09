package com.myproject.www.utils;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * Utils - XML 工具类
 * 
 * @author lixiang
 * @version 1.0
 */
public final class XMLUtils {
	
	 /** 编码 */
    private static final String encoding = "UTF-8";
	
	private XMLUtils(){
		
	}
	
	/**
	 * 根据XML文件地址获取Document 对象
	 * @param uri
	 * @return
	 */
	public static Document getDocument(String uri){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder = null;
        Document document = null;
		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(uri);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}  
        return document;
	}
	
	/**
     * 转换XML字符串
     * 
     * @param value
     *            XML对象
     * @return XML字符串
     */	
    public static String convertString(Object value) {
        try {
            JAXBContext context = JAXBContext.newInstance(value.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 格式化
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);// 编码
            StringWriter writer = new StringWriter();
            marshaller.marshal(value, writer);
            return writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转换XML对象
     * 
     * @param xml
     *            XML字符串
     * @param valueType
     *            XML对象类型
     * @return XML对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertObject(String xml, Class<T> valueType) {
        try {
            JAXBContext context = JAXBContext.newInstance(valueType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
}