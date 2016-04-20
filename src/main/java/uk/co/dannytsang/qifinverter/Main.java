/**
 * 
 */
package uk.co.dannytsang.qifinverter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import uk.co.dannytsang.qifinverter.data.Setting;

/**
 * Main method starting class for application.
 * 
 * @author dannytsang<danny@dannytsang.co.uk>
 *
 */
public class Main {

	private static final Logger LOG = LogManager.getLogger(Main.class);

	/**
	 * @param args
	 *          Command line parameters. [1] file path to qif (required). [2]
	 *          output file (optional).
	 */
	public static void main(String[] args) {

		Setting settings = ParameterChecker.check(args);
		if (settings != null) {
			LOG.debug("Found QIF file path: " + args[0]);
			// Run method to read and write QIF file.
			ConvertQif cq = new ConvertQif();
			cq.run(settings.getOriginalFile(), settings.getOutputFile());
		} else {
			LOG.error("Missing QIF file path.");
			throw new RuntimeException("Missing QIF file path.");
		}

	}

}
