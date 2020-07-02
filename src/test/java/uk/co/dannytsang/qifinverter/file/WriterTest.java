package uk.co.dannytsang.qifinverter.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

import org.junit.jupiter.api.io.TempDir;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WriterTest {

	Writer fileWriter = null;

	@TempDir
	public Path temporaryFolder;

	@BeforeEach
	public void setUpClass() {
		fileWriter = new Writer();

	}

	@Test
	public void testWriteToFile() throws IOException {
		File output = temporaryFolder.resolve("output.txt").toFile();

		System.out.println(output.getAbsolutePath());
		fileWriter.open(output.getAbsolutePath());
		fileWriter.writeLine("test");
	}

	@AfterEach
	public void tearDownClass() {
		fileWriter.close();
	}

}
