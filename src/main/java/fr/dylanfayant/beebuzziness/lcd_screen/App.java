package fr.dylanfayant.beebuzziness.lcd_screen;

import fr.dylanfayant.beebuzziness.lcd_screen.exceptions.CharacterIsNotDigitException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	if(args.length != 1) {
    		System.err.println("Please enter one number in parameters.");
    		System.exit(0);
    	}
    	
        LcdSimulator simulator = new LcdSimulator();
        
        try {
			String lcdNumber = simulator.consumeNumber(args[0]);
			System.out.print(lcdNumber);
		} catch (CharacterIsNotDigitException e) {
			System.err.println("Please enter a correct number (only numerical characters)!");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
