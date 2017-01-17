/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cypher;

/**
 *
 * @author dedged
 */
public class Cypher {
    /**
     * 
     * @param inputArray - a char array that will be 
     *                     swapped, and that will be returned
     * @param multiplier - if the array is split into parts, send the part size 
     *                     as the multiplier
     * @param firstChar - the first of the chars to be swapped
     * @param secondChar - the second of the chars to be swapped
     * @return - returns a char array, with the two chars swapped
     */
    public static char[] swapPlaces(char[] inputArray, int multiplier, int firstChar, int secondChar){
        /*
        * a variable to temporarily store char's for swapping them around
        */
        char tempChar;
        
        tempChar = inputArray[(firstChar-1)+(5*multiplier)];
        inputArray[(firstChar-1)+(5*multiplier)] = inputArray[(secondChar-1)+(5*multiplier)];
        inputArray[(secondChar-1)+(5*multiplier)] = tempChar;
        
        return inputArray;    
    }
    
    public static String cypher(String sourceString) {

        /**
         * Stores which cycle the loop is on - it's used to calculate the
         * character positions in the string when swapping places.
         */
        int cycle = 0;
        
        /*
        * a variable to temporarily store char's for swapping them around
        */
        char tempChar;
        
        /**
         * Stores the new, 'encrypted' array
         */
        String encodedString = new String();
        
        /*
        * checks if the input string is divisible by 5, if not, stores how 
        * many characters need to be added to make it so
         */
        short missingCharsCount = 0;
        if (sourceString.length() % 5 > 0) {
            missingCharsCount = (short) ((5 - (sourceString.length()) % 5));
        }

        /**
         * Stores the source string, converted into a char array, with 20
         * substracted from each char and with added 0's to make it divisible by
         * 5
         */
        char stringConvertedToChar[] = new char[sourceString.length() + missingCharsCount];

        /**
         * convert the input string to a char array,
         */
        for (int i = 0; i < sourceString.length(); i++) {
            stringConvertedToChar[i] = (char) ((int) (sourceString.charAt(i) - 20));
        }
        
        /**
         * fill in blank spots in the array with 0's
         */
        if (missingCharsCount > 0) {
            for (; missingCharsCount > 0; missingCharsCount--) {
                stringConvertedToChar[sourceString.length() + missingCharsCount - 1] = '0';
            }
        }
        
        /**
         * move elements of the char array around, in 5's, as such:
         * 1 with 3
         * 2 with 5
         * 3 with 2
         * 4 with 1
         * 5 with 4
         */
        for(int i = stringConvertedToChar.length/5; i > 0; i--, cycle++){
            //1 with 3
            stringConvertedToChar = swapPlaces(stringConvertedToChar, cycle, 1, 3);
            
            //2 with 5
            stringConvertedToChar = swapPlaces(stringConvertedToChar, cycle, 2, 5);
            
            //3 with 2
            stringConvertedToChar = swapPlaces(stringConvertedToChar, cycle, 3, 2);
            
            //4 with 1
            stringConvertedToChar = swapPlaces(stringConvertedToChar, cycle, 4, 1);
            
            //5 with 4
            stringConvertedToChar = swapPlaces(stringConvertedToChar, cycle, 5, 4);
        }
        
        
        /**
         * Save the resulting char array to a string, and convert the chars to
         * their respective values
         */
        for(int i = 0; i < stringConvertedToChar.length; i++){
            encodedString += new String((int) stringConvertedToChar[i]+" ");
        }
        
        return encodedString;
    }

    public static void main(String[] args) {
        String haba = "Haba baba";
        System.out.print(cypher(haba));
    }

}

