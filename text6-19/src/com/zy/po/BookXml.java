package com.zy.po;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Text;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class BookXml {
	public static void main(String[] args) throws ParserConfigurationException, FileNotFoundException, TransformerException {
		//创建documentBuilderFactory
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		//创建documentBuider
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		//创建document对象
		Document document=documentBuilder.newDocument();
		//创建根节点
		Element root=document.createElement("books");
		//创建子节点
		Element book=document.createElement("book");
		//赋予子节点属性
		Attr attrid=document.createAttribute("id");
		//给属性赋值并赋给book
		attrid.setValue("001");
		book.setAttributeNode(attrid);
		//创建子节点
		Element name=document.createElement("name");
		Text text=document.createTextNode("aa");
		//将子节点归给父类
		root.appendChild(book);
		book.appendChild(name);
		name.appendChild(text);
		//生成文件
		TransformerFactory tff=TransformerFactory.newInstance();
		Transformer tf=tff.newTransformer();
		//xml源
		DOMSource ds=new DOMSource(root);
		//创建流
		File file=new File("D://bk.xml");
		FileOutputStream fos=new FileOutputStream(file);
		StreamResult sr=new StreamResult(fos);
		tf.transform(ds, sr);
	}
}
