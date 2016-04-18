package uk.co.dannytsang.qifinverter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.dannytsang.qifinverter.data.Setting;

public class ParameterCheckerTest {

	@Test
	public void testUnderMinimumParameters() {
		String[] parameters = new String[0];

		Assert.assertNull(ParameterChecker.check(parameters));
	}

	@Test
	public void testValidOriginalFile() {
		String[] parameters = {"originalFile.txt"};
		
		Setting settings = ParameterChecker.check(parameters);
		
		Assert.assertNotNull(settings);
		Assert.assertEquals(parameters[0], settings.getOriginalFile());
	}
	
	@Test
	public void testValidOriginalAndNewFile() {
		String[] parameters = {"originalFile.txt","newFile.txt"};
		
		Setting settings = ParameterChecker.check(parameters);
		
		Assert.assertNotNull(settings);
		Assert.assertEquals(parameters[0], settings.getOriginalFile());
		Assert.assertEquals(parameters[1], settings.getOutputFile());
	}
}
