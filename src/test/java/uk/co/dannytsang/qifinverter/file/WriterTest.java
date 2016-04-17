package uk.co.dannytsang.qifinverter.file;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class WriterTest {

	Writer fileWriter = null;

	@Rule
	public TemporaryFolder temporaryFolder = new TemporaryFolder();

	@Before
	public void setUpClass() {
		fileWriter = new Writer();

	}

	@Test
	public void testWriteToFile() throws IOException {
		File output = temporaryFolder.newFolder("reports").toPath().resolve("output.txt").toFile();

		System.out.println(output.getAbsolutePath());
		fileWriter.open(output.getAbsolutePath());
		fileWriter.writeLine("test");
	}

	@After
	public void tearDownClass() {
		fileWriter.close();
	}

}
