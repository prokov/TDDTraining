package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import app.Validator1;
import org.junit.Test;

import app.Validator;

public class ValidatorTest {

	@Test
	public void checkValidNumber10() {
		Validator val = new Validator();
		boolean res = val.checkNumber("0143108271");// master i margarita
		assertTrue( res);

		res = val.checkNumber("0451163966"); // one flew under cocoos nest
		assertTrue("secound value", res);

	}

	@Test
	public void checkValidNumber13() {
		Validator val = new Validator();
		boolean res = val.checkNumber("9780120000302");
		assertTrue("first 13 digits isbn", res);
		
		res = val.checkNumber("9781986260787");
		assertTrue("second 13 digits isbn", res);

	}
	
	@Test
	public void checkInvalidNumber13() {
		Validator val = new Validator();
		boolean res = val.checkNumber("9780120000306");
		assertFalse("invalid 13 digits isbn", res);


	}

	@Test
	public void changeOneDigitValidNumber10() {
		Validator val = new Validator();
		boolean res = val.checkNumber("0143108277");
		assertFalse(res);

	}

	@Test(expected = NumberFormatException.class)
	public void OnlyTenAreAllowed() {
		Validator val = new Validator();
		//val.checkNumber("01431087");
        val.checkNumber("0143108277");
	}

	@Test(expected = NumberFormatException.class)
	public void onlyDigitsAllowed() {
		Validator val = new Validator();
		val.checkNumber("helloworld");

	}

	@Test
	public void lastSymbolXValid10() {
		Validator1 val = new Validator1();
		boolean res = val.checkNumber("012000030X");// last of the mohicans
		assertTrue(res);

	}

}
