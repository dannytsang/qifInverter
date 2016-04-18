package uk.co.dannytsang.qifinverter;

import uk.co.dannytsang.qifinverter.data.Setting;

public class ParameterChecker {

	public static Setting check(String[] arguments) {
		Setting settings = new Setting();

		// Check it has at the minimum required arguments passed in
		if (!checkMinimumArgumentsPresent(arguments)) {
			// Exit if it fails this test
			return null;
		}

		// Check source file is valid
		if (checkValidString(arguments[0]) != null) {
			settings.setOriginalFile(arguments[0]);
		}

		// Check if destination
		if (arguments.length > 1 && checkValidString(arguments[1]) != null) {
			// Check destination file is valid
			settings.setOutputFile(arguments[1]);
		}

		return settings;
	}

	/**
	 * Checks the minimum number of arguments have been met.
	 * 
	 * @param arguments
	 *          Array of String arguments
	 * @return true = valid, false = invalid
	 */
	private static boolean checkMinimumArgumentsPresent(String[] arguments) {
		boolean isValid = false;

		if (arguments != null && arguments.length > 0) {
			isValid = true;
		}

		return isValid;
	}

	/**
	 * Check string value is valid.
	 * 
	 * @param string
	 *          String to be checked.
	 * @return null if it's invalid otherwise the original string.
	 */
	private static String checkValidString(String string) {
		if (string != null && string.trim().length() > 0) {
			return string;
		} else {
			return null;
		}
	}
}
