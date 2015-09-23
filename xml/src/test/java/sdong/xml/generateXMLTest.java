package sdong.xml;

import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

import org.dom4j.Document;

import sdong.xml.util.XMLFileUtil;

public class generateXMLTest extends TestCase {

	public void testGenerateDoc() {
		try {
			Document document = XMLFileUtil.createXMLwithRoot("Checkers");
			
			String inpute = "input" + File.separator + "test.csv";
			generateXML.generateDoc(inpute, "Coverity_C", document);
				
			String output = "output"+ File.separator+ "Checker.xml";
			XMLFileUtil.outputXML(output, document);
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
