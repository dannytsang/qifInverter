package uk.co.dannytsang.qifinverter.parser;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class QifParserTests {

	static QifParser parser;
	String line;

	@BeforeClass
	public static void setUpClass() {
		parser = new QifParser();
	}

	@Test
	public void testEmptyLine() {
		String line = "";
		Assert.assertEquals(line, parser.parseLine(line));
	}
	
	@Test
	public void testInvertPostiveTransactionLine() {
		String line = "T20.28";
		String expectedLine = "T-20.28";
		Assert.assertEquals(expectedLine, parser.parseLine(line));
	}
	
	@Test
	public void testInvertNegativeTransactionLine() {
		String line = "T-20.28";
		String expectedLine = "T20.28";
		Assert.assertEquals(expectedLine, parser.parseLine(line));
	}
	
	@Test
	public void testNonTransactionLine(){
		String line = "!Type:Bank";
		Assert.assertEquals(line, parser.parseLine(line));
	}
	
	@AfterClass
	public static void tearDownClass() {
		parser = null;
	}

}
