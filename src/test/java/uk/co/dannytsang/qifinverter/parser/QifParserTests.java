package uk.co.dannytsang.qifinverter.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class QifParserTests {

	static IParser parser;
	String line;

	@BeforeAll
	public static void setUpClass() {
		parser = new QifParser();
	}

	@Test
	public void testEmptyLine() {
		String line = "";
		assertEquals(line, parser.parseLine(line));
	}
	
	@Test
	public void testInvertPostiveTransactionLine() {
		String line = "T20.28";
		String expectedLine = "T-20.28";
		assertEquals(expectedLine, parser.parseLine(line));
	}
	
	@Test
	public void testInvertNegativeTransactionLine() {
		String line = "T-20.28";
		String expectedLine = "T20.28";
		assertEquals(expectedLine, parser.parseLine(line));
	}
	
	@Test
	public void testNonTransactionLine(){
		String line = "!Type:Bank";
		assertEquals(line, parser.parseLine(line));
	}
	
	@AfterAll
	public static void tearDownClass() {
		parser = null;
	}

}
