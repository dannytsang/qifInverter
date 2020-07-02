package uk.co.dannytsang.qifinverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import uk.co.dannytsang.qifinverter.data.Setting;

public class ParameterCheckerTest {

	@Test
	public void testUnderMinimumParameters() {
		String[] parameters = new String[0];

		assertNull(ParameterChecker.check(parameters));
	}

	@Test
	public void testValidOriginalFile() {
		String[] parameters = {"originalFile.txt"};
		
		Setting settings = ParameterChecker.check(parameters);
		
		assertNotNull(settings);
		assertEquals(parameters[0], settings.getOriginalFile());
	}
	
	@Test
	public void testValidOriginalAndNewFile() {
		String[] parameters = {"originalFile.txt","newFile.txt"};
		
		Setting settings = ParameterChecker.check(parameters);
		
		assertNotNull(settings);
		assertEquals(parameters[0], settings.getOriginalFile());
		assertEquals(parameters[1], settings.getOutputFile());
	}
}
