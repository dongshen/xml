package sdong.xml.util;

import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class XMLFileUtil {

	public static Document createXML() {
		Document document = DocumentHelper.createDocument();
		return document;
	}

	public static Element createRoot(Document document, String rootName) {

		Element root = DocumentHelper.createElement(rootName);
		document.setRootElement(root);

		return root;
	}

	public static Document createXMLwithRoot(String rootName) {
		Element root = DocumentHelper.createElement(rootName);
		Document document = DocumentHelper.createDocument(root);
		return document;
	}

	public static void outputXML(String filename, Document document) throws IOException {

		// 设置文件编码
		OutputFormat xmlFormat = new OutputFormat();
		xmlFormat.setEncoding("UTF-8");

		// 设置换行
		xmlFormat.setNewlines(true);
		// 生成缩进
		xmlFormat.setIndent(true);
		// 使用4个空格进行缩进, 可以兼容文本编辑器
		xmlFormat.setIndent("    ");

		// 创建写文件方法
		XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(filename), xmlFormat);

		// 写入文件
		xmlWriter.write(document);
		// 关闭
		xmlWriter.close();

	}
}
