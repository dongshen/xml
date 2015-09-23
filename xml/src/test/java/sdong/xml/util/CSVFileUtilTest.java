package sdong.xml.util;

import java.io.File;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

public class CSVFileUtilTest extends TestCase {

	private static final Logger LOG = Logger.getLogger(CSVFileUtilTest.class);

	public void testCSVFileUtil() {
		CSVFileUtil csv;
		try {
			String inpute = "input" + File.separator + "test.csv";
			csv = new CSVFileUtil(inpute);
			ArrayList<String> lines = csv.readAllLines();

			for (String line : lines) {
				LOG.debug("line=" + line);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testFromCSVLine_without_quota() {

		String source = "category 1,type 1,必须清理";
		int size = 3;
		String[] fields = CSVFileUtil.fromCSVLine(source, size);
		assertEquals("category 1", fields[0]);
		assertEquals("type 1", fields[1]);
		assertEquals("必须清理", fields[2]);
	}
	
	public void testFromCSVLine_wit_quota() {

		String source = "\"category 1\",\"type, 1\",\"必须清理\"";
		int size = 3;
		String[] fields = CSVFileUtil.fromCSVLine(source, size);
		assertEquals("category 1", fields[0]);
		assertEquals("type, 1", fields[1]);
		assertEquals("必须清理", fields[2]);
	}

	public void testFromCSVLinetoArray() {
		String source = "\"category 1\",\"type, 1\",\"必须清理\"";
		ArrayList<String> fields = CSVFileUtil.fromCSVLinetoArray(source);
		assertEquals("category 1", fields.get(0));
		assertEquals("type, 1", fields.get(1));
		assertEquals("必须清理", fields.get(2));
	}

}
