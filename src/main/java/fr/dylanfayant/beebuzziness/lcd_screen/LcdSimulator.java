package fr.dylanfayant.beebuzziness.lcd_screen;

import fr.dylanfayant.beebuzziness.lcd_screen.digits.*;
import fr.dylanfayant.beebuzziness.lcd_screen.exceptions.CharacterIsNotDigitException;

public class LcdSimulator {
	/**
	 * Functions names to call to get each digits lines 
	 */
	String[] functionLinesNames = {"topLine", "middleLine", "bottomLine"};
	
	
	/**
	 * Main method of this class used to generate a string representing the LCD digits 
	 * line by line (top, middle and bottom)
	 * @param number : string representing the number we want to show in LCD way 
	 * @return String containing 3 lines 
	 * @throws Exception : all exceptions possible containing our CharacterIsNotDigit exception
	 */
	public String consumeNumber(String number) throws Exception {
		String formatedLcdString = "";

		// reports an exception to the caller if the string is not a number
		Digit[] digitsArray = convertStringToDigits(number);
		
		// for each 3 lines get the strings of each digit
		for(String functionName : functionLinesNames) {
			
			for(int index = 0; index < digitsArray.length; index++) {
				
				formatedLcdString += digitsArray[index].getClass().getMethod(functionName).invoke(digitsArray[index]);
				
				// while it's not the last digit, add the space between two digits
				if(index < digitsArray.length-1) {
					formatedLcdString += " ";
				}
			}
			
			formatedLcdString += "\n";
			
		}
		
		return formatedLcdString;
	}

	/**
	 * Method which transforms a string containing a number to an array of digit objects
	 * @param number : string representing a number
	 * @return an array of digits
	 * @throws CharacterIsNotDigitException : parameter string is not a number
	 */
	private Digit[] convertStringToDigits(String number) throws CharacterIsNotDigitException {
		// The string transformed to an array
		char[] charsArray = number.toCharArray();
		// The resulting digit array
		Digit[] digitsArray = new Digit[charsArray.length];
		
		for(int index = 0; index < charsArray.length; index++) {
			if(!Character.isDigit(charsArray[index]))
				throw new CharacterIsNotDigitException();
			
			int digit = Integer.parseInt(String.valueOf(charsArray[index]));
			
			switch(digit) {
				case 0:
					digitsArray[index] = new Digit0();
					break;
				case 1:
					digitsArray[index] = new Digit1();
					break;
				case 2:
					digitsArray[index] = new Digit2();
					break;
				case 3:
					digitsArray[index] = new Digit3();
					break;
				case 4:
					digitsArray[index] = new Digit4();
					break;
				case 5:
					digitsArray[index] = new Digit5();
					break;
				case 6:
					digitsArray[index] = new Digit6();
					break;
				case 7:
					digitsArray[index] = new Digit7();
					break;
				case 8:
					digitsArray[index] = new Digit8();
					break;
				case 9:
					digitsArray[index] = new Digit9();
					break;
			}
		}
		
		return digitsArray;
	}
	
}
