package uk.co.dannytsang.qifinverter.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class to handle reading files.
 * 
 * @author dannytsang<danny@dannytsang.co.uk>
 *
 */
public class Reader {
	private static final Logger LOG = LogManager.getLogger(Reader.class);
	private BufferedReader br;

	/**
	 * Open a file and return a stream reader.
	 * 
	 * @param file
	 *          File path.
	 * @return Stream object of the file.
	 * @throws IOException
	 *           If there's a problem with file operation.
	 */
	public BufferedReader open(String file) throws IOException {
		LOG.info("Opening file: " + file);
		br = new BufferedReader(new FileReader(file));

		return br;
	}

	/**
	 * 
	 * @return Reader access to open file.
	 */
	public BufferedReader getReader() {
		return br;
	}

	/**
	 * Closes an open file.
	 */
	public void close() {
		if (br != null) {
			try {
				br.close();
			} catch (IOException ioe) {
				LOG.error(ioe);
			} catch (Exception e) {
				LOG.error(e);
			}
		}
	}

}
