package uk.co.dannytsang.qifinverter.configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConfigurationManagerTest {

	@Test
	public void unixFilePathTest() {
		String filePath = "/home/myuser/newoutputfile.txt";

		assertEquals("/home/myuser/newoutputfile" + Configuration.NEW_FILE_SUFFIX + ".txt",
				ConfigurationManager.defaultOutputFileName(filePath));
	}
	
	@Test
	public void WindowsFilePathTest() {
		String filePath = "C:\\user\\myuser\\newoutputfile.txt";

		assertEquals("C:\\user\\myuser\\newoutputfile" + Configuration.NEW_FILE_SUFFIX + ".txt",
				ConfigurationManager.defaultOutputFileName(filePath));
	}
	
	@Test
	public void noFilePath() {

		assertEquals(Configuration.DEFAULT_OUTPUT_FILENAME,
				ConfigurationManager.defaultOutputFileName(""));
	}
	
	@Test
	public void noFilePathMethod() {
		assertEquals(Configuration.DEFAULT_OUTPUT_FILENAME,
				ConfigurationManager.defaultOutputFileName());
	}

}
