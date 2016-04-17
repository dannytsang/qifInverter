package uk.co.dannytsang.qifinverter.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReaderTest {

	Reader fileReader = null;
	ClassLoader classLoader = getClass().getClassLoader();

	@Before
	public void setUpClass() {
		fileReader = new Reader();
	}

	@Test
	public void testOpen() {
		File file = new File(classLoader.getResource("example.qif").getFile());

		try {
			BufferedReader br = fileReader.open(file.getAbsolutePath());

			String line;
			while ((line = br.readLine()) != null) {
				Assert.assertTrue(line.length() > 0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test(expected=IOException.class)
	public void testInvalidFilePath() throws IOException {
			fileReader.open("dummy/path.txt");
	}

	@After
	public void tearDownClass() {
		fileReader.close();
	}

}
