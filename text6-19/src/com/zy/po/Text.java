package com.zy.po;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Text {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder =documentBuilderFactory.newDocumentBuilder();
		File file=new File("D://NewFile.xml");
		Document document =documentBuilder.parse(file);
		//根节点
		Element root=document.getDocumentElement();
		//根据名称查询子结点
		NodeList nodeList=root.getElementsByTagName("student");
		
		for(int i=0;i<nodeList.getLength();i++){
			//子节点
				Node node=nodeList.item(i);
			//结点属性	
				NamedNodeMap attrs= node.getAttributes();
				for(int j=0;j<attrs.getLength();j++){
					System.out.println(attrs.item(j).getNodeName());
					System.out.println(attrs.item(j).getNodeValue());
					
					
				}
				
				NodeList nodeList2=node.getChildNodes();
				for(int j=0;j<nodeList2.getLength();j++){
					//子结点的子节点=孙子结点
					Node node2=nodeList2.item(j);
					//输出 文本内容
					String value=node2.getTextContent();
					System.out.println(node2.getNodeName());
					System.out.println(value);
				}
		}
		
	}
}
