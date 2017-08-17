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
		//����documentBuilderFactory
		DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
		//����documentBuider
		DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
		//����document����
		Document document=documentBuilder.newDocument();
		//�������ڵ�
		Element root=document.createElement("books");
		//�����ӽڵ�
		Element book=document.createElement("book");
		//�����ӽڵ�����
		Attr attrid=document.createAttribute("id");
		//�����Ը�ֵ������book
		attrid.setValue("001");
		book.setAttributeNode(attrid);
		//�����ӽڵ�
		Element name=document.createElement("name");
		Text text=document.createTextNode("aa");
		//���ӽڵ�������
		root.appendChild(book);
		book.appendChild(name);
		name.appendChild(text);
		//�����ļ�
		TransformerFactory tff=TransformerFactory.newInstance();
		Transformer tf=tff.newTransformer();
		//xmlԴ
		DOMSource ds=new DOMSource(root);
		//������
		File file=new File("D://bk.xml");
		FileOutputStream fos=new FileOutputStream(file);
		StreamResult sr=new StreamResult(fos);
		tf.transform(ds, sr);
	}
}
