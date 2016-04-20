package uk.co.dannytsang.qifinverter;

import java.io.BufferedReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.co.dannytsang.qifinverter.file.Reader;
import uk.co.dannytsang.qifinverter.file.Writer;
import uk.co.dannytsang.qifinverter.parser.IParser;
import uk.co.dannytsang.qifinverter.parser.QifParser;

/**
 * Class that glues everything together.
 * 
 * @author dannytsang<danny@dannytsang.co.uk>
 *
 */
public class ConvertQif {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	Reader fileReader = new Reader();
	Writer fileWriter = new Writer();
	IParser parser = new QifParser();

	/**
	 * Start the parsing.
	 * 
	 * @param orginalFile
	 *          Source file.
	 * @param outputFile
	 *          Output file path.
	 */
	public void run(String orginalFile, String outputFile) {
		try {
			BufferedReader reader = fileReader.open(orginalFile);
			fileWriter.open(outputFile);

			String line;
			while ((line = reader.readLine()) != null) {
				// Put line to parser and write out the result to new file.
				fileWriter.writeLine(parser.parseLine(line));
			}

		} catch (IOException ioe) {
			LOG.error(ioe);
		} finally {
			// Close file
			fileWriter.close();
		}
	}
}
