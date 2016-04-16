package uk.co.dannytsang.qifinverter.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class QifParser implements IParser {
	private static final Logger LOG = LogManager.getLogger(QifParser.class);

	/**
	 * Checks line for specific pattern to see if any manipulation is required. If
	 * it will return the original line.
	 * 
	 * @param line
	 *          String to check
	 * @return String to return either changed or original
	 */
	@Override
	public String parseLine(String line) {
		StringBuilder sb = new StringBuilder(line);
		// Transaction
		if (line.startsWith("T")) {
			LOG.info("Found transaction line");
			
			// Check if it's a negative transaction
			if (sb.charAt(1) == '-') {
				LOG.debug("Negative Transaction:" + line);
				sb.deleteCharAt(1);
			} else {
				LOG.debug("Positive Transaction:" + line);
				sb.insert(1, "-");
			}
		} else {
			LOG.info("Non transaction line found");
		}

		return sb.toString();
	}
}
