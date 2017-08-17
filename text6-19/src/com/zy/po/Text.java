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
		//���ڵ�
		Element root=document.getDocumentElement();
		//�������Ʋ�ѯ�ӽ��
		NodeList nodeList=root.getElementsByTagName("student");
		
		for(int i=0;i<nodeList.getLength();i++){
			//�ӽڵ�
				Node node=nodeList.item(i);
			//�������	
				NamedNodeMap attrs= node.getAttributes();
				for(int j=0;j<attrs.getLength();j++){
					System.out.println(attrs.item(j).getNodeName());
					System.out.println(attrs.item(j).getNodeValue());
					
					
				}
				
				NodeList nodeList2=node.getChildNodes();
				for(int j=0;j<nodeList2.getLength();j++){
					//�ӽ����ӽڵ�=���ӽ��
					Node node2=nodeList2.item(j);
					//��� �ı�����
					String value=node2.getTextContent();
					System.out.println(node2.getNodeName());
					System.out.println(value);
				}
		}
		
	}
}
