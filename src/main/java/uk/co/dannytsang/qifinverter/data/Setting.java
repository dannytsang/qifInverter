package uk.co.dannytsang.qifinverter.data;

/**
 * Class to hold settings to how program should operate which can be changed at
 * runtime.
 * 
 * @author dannytsang<danny@dannytsang.co.uk>
 *
 */
public class Setting {
	
	private String originalFile;
	private String outputFile;

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}

	public String getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(String outputFile) {
		this.outputFile = outputFile;
	}
}
