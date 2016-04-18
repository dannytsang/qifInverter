package uk.co.dannytsang.qifinverter.data;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SettingTest {

	private Setting setting;

	@Before
	public void setUp() {
		setting = new Setting();
	}

	@Test
	public void testOriginalFile() {
		String originalFile = "original.txt";
		setting.setOriginalFile(originalFile);

		Assert.assertEquals(originalFile, setting.getOriginalFile());
	}

	@Test
	public void testOutputFile() {
		String outputFile = "output.txt";
		setting.setOutputFile(outputFile);

		Assert.assertEquals(outputFile, setting.getOutputFile());
	}

	@Test
	public void testOriginalAndOutputFile() {
		String originalFile = "original.txt";
		String outputFile = "output.txt";

		setting.setOutputFile(outputFile);
		setting.setOriginalFile(originalFile);

		Assert.assertEquals(originalFile, setting.getOriginalFile());
		Assert.assertEquals(outputFile, setting.getOutputFile());
	}

	@After
	public void tearDown() {
		setting = null;
	}

}
