package fr.dylanfayant.beebuzziness.lcd_screen;

import fr.dylanfayant.beebuzziness.lcd_screen.exceptions.CharacterIsNotDigitException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testEmptyString()
    {
        LcdSimulator lcd = new LcdSimulator();
        
        try {
			lcd.consumeNumber("");
		} catch (Exception e) {
			fail("Empty string should not return error");
		}
    }

    public void testNumbersWithSpace()
    {
        LcdSimulator lcd = new LcdSimulator();
        
        try {
			lcd.consumeNumber("123 456");
			fail("Numbers with space should return error");
		} catch (Exception e) {
			assert(e instanceof CharacterIsNotDigitException);
		}
    }

    public void testAlphabeticalStrings()
    {
        LcdSimulator lcd = new LcdSimulator();
        
        try {
			lcd.consumeNumber("abcd123");
			fail("Alphabetical strings should return error");
		} catch (Exception e) {
			assert(e instanceof CharacterIsNotDigitException);
		}
    }

    public void testNegativeNumber()
    {
        LcdSimulator lcd = new LcdSimulator();
        
        try {
			lcd.consumeNumber("-30");
			fail("Negative number should return error");
		} catch (Exception e) {
			assert(e instanceof CharacterIsNotDigitException);
		}
    }

    public void testAllCorrectDigits()
    {
        LcdSimulator lcd = new LcdSimulator();
        
        try {
			String returnedNumber = lcd.consumeNumber("0123456789");
			assert(returnedNumber.contains(" _       _   _       _   _   _   _   _ \n"));
			assert(returnedNumber.contains("| |   |  _|  _| |_| |_  |_    | |_| |_|\n"));
			assert(returnedNumber.contains("|_|   | |_   _|   |  _| |_|   | |_|   |\n"));
		} catch (Exception e) {
			fail("This number should not fail...");
		}
    }
  
}
