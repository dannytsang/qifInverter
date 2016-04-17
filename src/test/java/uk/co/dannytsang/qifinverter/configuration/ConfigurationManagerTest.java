package uk.co.dannytsang.qifinverter.configuration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationManagerTest {

	@Test
	public void unixFilePathTest() {
		String filePath = "/home/myuser/newoutputfile.txt";

		Assert.assertEquals("/home/myuser/newoutputfile" + Configuration.NEW_FILE_SUFFIX + ".txt",
				ConfigurationManager.defaultOutputFileName(filePath));
	}
	
	@Test
	public void WindowsFilePathTest() {
		String filePath = "C:\\user\\myuser\\newoutputfile.txt";

		Assert.assertEquals("C:\\user\\myuser\\newoutputfile" + Configuration.NEW_FILE_SUFFIX + ".txt",
				ConfigurationManager.defaultOutputFileName(filePath));
	}
	
	@Test
	public void noFilePath() {

		Assert.assertEquals(Configuration.DEFAULT_OUTPUT_FILENAME,
				ConfigurationManager.defaultOutputFileName(""));
	}
	
	@Test
	public void noFilePathMethod() {
		Assert.assertEquals(Configuration.DEFAULT_OUTPUT_FILENAME,
				ConfigurationManager.defaultOutputFileName());
	}

}
