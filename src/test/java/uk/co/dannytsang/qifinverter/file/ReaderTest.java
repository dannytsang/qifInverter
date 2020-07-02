package uk.co.dannytsang.qifinverter.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReaderTest {

	Reader fileReader = null;
	ClassLoader classLoader = getClass().getClassLoader();

	@BeforeEach
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
				assertTrue(line.length() > 0);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testInvalidFilePath() {
		assertThrows(IOException.class, () -> {
			fileReader.open("dummy/path.txt");
		});
	}

	@AfterEach
	public void tearDownClass() {
		fileReader.close();
	}

}
