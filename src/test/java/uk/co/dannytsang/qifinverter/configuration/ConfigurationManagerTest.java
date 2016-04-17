package uk.co.dannytsang.qifinverter.configuration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConfigurationManagerTest {

	private ConfigurationManager cm = null;

	@Before
	public void setUp() throws Exception {

		cm = new ConfigurationManager();
	}

	@Test
	public void unixFilePathTest() {
		String filePath = "/home/myuser/newoutputfile.txt";

		Assert.assertEquals("/home/myuser/newoutputfile" + Configuration.NEW_FILE_SUFFIX + ".txt",
				cm.defaultOutputFileName(filePath));
	}
	
	@Test
	public void WindowsFilePathTest() {
		String filePath = "C:\\user\\myuser\\newoutputfile.txt";

		Assert.assertEquals("C:\\user\\myuser\\newoutputfile" + Configuration.NEW_FILE_SUFFIX + ".txt",
				cm.defaultOutputFileName(filePath));
	}
	
	@Test
	public void noFilePath() {

		Assert.assertEquals(Configuration.DEFAULT_OUTPUT_FILENAME,
				cm.defaultOutputFileName(""));
	}

	@After
	public void tearDown() throws Exception {
		cm = null;
	}

}
