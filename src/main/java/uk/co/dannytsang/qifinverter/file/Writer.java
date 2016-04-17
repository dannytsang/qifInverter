package uk.co.dannytsang.qifinverter.file;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to handle writing text to a file.
 * 
 * @author dannytsang<danny@dannytsang.co.uk>
 *
 */
public class Writer {
	private static final Logger LOG = LogManager.getLogger(Writer.class);
	BufferedWriter fileWriter = null;
	private String filePath = null;

	/**
	 * Open file to be written to.
	 * 
	 * @param file
	 *          file path
	 * @throws IOException
	 */
	public void open(String file) throws IOException {
		LOG.debug("Attempting to open: " + file);
		
		fileWriter = Files.newBufferedWriter(Paths.get(file));
		
		// Set file path
		filePath = file;
	}

	/**
	 * Appends a single line to the open file.
	 * 
	 * @param line
	 *          Text to append to file.
	 * @return The line that was written to file.
	 * @throws IOException
	 */
	public String writeLine(String line) throws IOException {
		LOG.debug("Writing '" + line + "' to: " + filePath);

		fileWriter.write(line);

		return line;
	}

	public String getFilePath() {
		return filePath;
	}

	/**
	 * Close file.
	 */
	public void close() {
		LOG.debug("Attempting to close: " + filePath);
		
		try {
			fileWriter.close();
			filePath = null;
		} catch (IOException ioe) {
			LOG.error(ioe);
		} catch (Exception e) {
			LOG.error(e);
		}
	}
}
