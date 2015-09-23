package sdong.xml;

import java.util.ArrayList;

import org.dom4j.Document;
import org.dom4j.Element;

import sdong.xml.util.CSVFileUtil;

public class generateXML {

	public static void generateDoc(String filename, String nodeName, Document document) {

		try {

			Element root = document.getRootElement();

			Element element = root.addElement(nodeName);

			CSVFileUtil csv = new CSVFileUtil(filename);

			ArrayList<String> lines = csv.readAllLines();

			for (String line : lines) {
				ArrayList<String> fields = CSVFileUtil.fromCSVLinetoArray(line);
				if (fields.size() != 0) {
					addElement(element, fields);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void addElement(Element root, ArrayList<String> fields) {
		Element element = root.addElement("Checker");
		element.addAttribute("Category", fields.get(0));
		element.addAttribute("Type", fields.get(1));

		String clear = fields.get(2);
		if (clear.equals("必须清理")) {
			clear = "Mandatory";
		} else if (clear.equals("建议清理")) {
			clear = "Suggest";
		} else {
			clear = "It depend";
		}

		element.addAttribute("Clear", clear);
		Element elementRules = element.addElement("Rules");
	}

}
