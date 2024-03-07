/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Map;
import java.util.HashMap;
/**
 *
 * @author dhruv
 */
public class RomanNumeral {
    private static Map<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static void main(String[] args) {
        RomanNumeral romanNumeral = new RomanNumeral();

        // Test cases
        System.out.println("Conversion result: " + romanNumeral.romanToInt("XXIV")); // Valid
        System.out.println("Conversion result: " + romanNumeral.romanToInt("XI")); // Valid
        System.out.println("Conversion result: " + romanNumeral.romanToInt("IV")); // Valid
        System.out.println("Conversion result: " + romanNumeral.romanToInt("XIV")); // Valid
        System.out.println("Conversion result: " + romanNumeral.romanToInt("II")); // Valid
        System.out.println("Conversion result: " + romanNumeral.romanToInt("I")); // Valid
        System.out.println("Conversion result: " + romanNumeral.romanToInt("Z")); // Invalid
        System.out.println("Conversion result: " + romanNumeral.romanToInt("XIZ")); // Invalid
        System.out.println("Conversion result: " + romanNumeral.romanToInt("VV")); // Invalid
        System.out.println("Conversion result: " + romanNumeral.romanToInt(null)); // Invalid
    }
    //Check if it is null
    public int romanToInt(String s) {
        if (s == null) {
            System.out.println("Input is null. Please provide a valid Roman numeral.");
            return 0; 
        }

        int convertedNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Check if the letter is a valid Roman numeral character
            if (!map.containsKey(currentChar)) {
                System.out.println("Invalid Roman numeral character: " + currentChar);
                return 0; 
            }

            int currentNumber = map.get(currentChar);
            int next = i + 1 < s.length() ? map.get(s.charAt(i + 1)) : 0;

            // Check for invalid subtractive notation
            if (currentNumber < next) {
                if (!isValidSubtractiveNotation(currentChar, s.charAt(i + 1))) {
                    System.out.println("Invalid subtractive notation: " + currentChar + s.charAt(i + 1));
                    return 0; 
                }

                convertedNumber += next - currentNumber;
                i++; // Skip the next character since it's already considered
            } else {
                convertedNumber += currentNumber;
            }
        }

        return convertedNumber;
    }

    // Check if the subtractive notation is valid
    private boolean isValidSubtractiveNotation(char currentChar, char nextChar) {
        return (currentChar == 'I' && (nextChar == 'V' || nextChar == 'X'))
                || (currentChar == 'X' && (nextChar == 'L' || nextChar == 'C'))
                || (currentChar == 'C' && (nextChar == 'D' || nextChar == 'M'));
    }
}


    
    
}
