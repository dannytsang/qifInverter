package uk.co.dannytsang.qifinverter.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SettingTest {

	private Setting setting;

	@BeforeEach
	public void setUp() {
		setting = new Setting();
	}

	@Test
	public void testOriginalFile() {
		String originalFile = "original.txt";
		setting.setOriginalFile(originalFile);

		assertEquals(originalFile, setting.getOriginalFile());
	}

	@Test
	public void testOutputFile() {
		String outputFile = "output.txt";
		setting.setOutputFile(outputFile);

		assertEquals(outputFile, setting.getOutputFile());
	}

	@Test
	public void testOriginalAndOutputFile() {
		String originalFile = "original.txt";
		String outputFile = "output.txt";

		setting.setOutputFile(outputFile);
		setting.setOriginalFile(originalFile);

		assertEquals(originalFile, setting.getOriginalFile());
		assertEquals(outputFile, setting.getOutputFile());
	}

	@AfterEach
	public void tearDown() {
		setting = null;
	}

}
