package uk.co.dannytsang.qifinverter.configuration;

import org.apache.commons.io.FilenameUtils;

/**
 * Manages configuration settings either by accessing or returning settings.
 * 
 * @author dannytsang<danny@dannytsang.co.uk>
 *
 */
public class ConfigurationManager {

	/**
	 * Return default file name.
	 * 
	 * @return Default file name.
	 */
	public static String defaultOutputFileName() {
		return Configuration.DEFAULT_OUTPUT_FILENAME;
	}

	/**
	 * Returns file path based on existing file.
	 * 
	 * @param inputFilename
	 *          Full path to existing file
	 * @return New file path.
	 */
	public static String defaultOutputFileName(String inputFilename) {
		String newFileName = null;

		if (inputFilename != null && inputFilename.length() > 0) {
			// Get file path excluding the file name
			StringBuilder sb = new StringBuilder(FilenameUtils.getPrefix(inputFilename))
					.append(FilenameUtils.getPath(inputFilename));

			// Add file name without extension
			sb.append(FilenameUtils.getBaseName(inputFilename));
			// Add suffix
			sb.append(Configuration.NEW_FILE_SUFFIX);
			// Add file extension
			sb.append(".").append(FilenameUtils.getExtension(inputFilename));

			newFileName = sb.toString();
		} else {
			// No file name found. Use default
			newFileName = Configuration.DEFAULT_OUTPUT_FILENAME;
		}

		return newFileName;
	}
}
