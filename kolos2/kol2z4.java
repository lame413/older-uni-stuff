/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kol2z4;

/**
 *
 * @author dedged
 */
public class kol2z4 {
    /**
     * 
     * @param inputArray - a char array that will be 
     *                     swapped, and that will be returned
     * @param multiplier - if the array is split into parts, set the multiplier 
     *                     as the current set of chars to be considered
     * @param partSize - if the array is split into parts, set the part size 
     *                   as partSize
     * @param firstChar - the first of the chars to be swapped
     * @param secondChar - the second of the chars to be swapped
     * @return - returns a char array, with the two chars swapped
     */
    public static char[] swapPlaces(char[] inputArray, int multiplier, int partSize, int firstChar, int secondChar){
        /*
        * a variable to temporarily store char's for swapping them around
        */
        char tempChar;
        
        tempChar = inputArray[(firstChar-1)+(partSize*multiplier)];
        inputArray[(firstChar-1)+(partSize*multiplier)] = inputArray[(secondChar-1)+(partSize*multiplier)];
        inputArray[(secondChar-1)+(partSize*multiplier)] = tempChar;
        
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
         * Stores the new, 'encrypted' string
         */
        String encodedString = new String();
        
        /*
        * checks if the input string is divisible by 4, if not, stores how 
        * many characters need to be added to make it so
         */
        short missingCharsCount = 0;
        if (sourceString.length() % 4 > 0) {
            missingCharsCount = (short) ((4 - (sourceString.length()) % 4));
        }

        /**
         * Stores the source string, converted into a char array, with 5
         * added to each char and with added 0's to make it divisible by
         * 4
         */
        char stringConvertedToChar[] = new char[sourceString.length() + missingCharsCount];

        /**
         * convert the input string to a char array,
         */
        for (int i = 0; i < sourceString.length(); i++) {
            stringConvertedToChar[i] = (char) ((int) (sourceString.charAt(i)));
        }
        
        /**
         * fill in blank spots in the array with 0's
         */
        if (missingCharsCount > 0) {
            for (; missingCharsCount > 0; missingCharsCount--) {
                stringConvertedToChar[sourceString.length() + missingCharsCount - 1] = (char) 0;
            }
        }
        
        /**
         * offset all chars in the array by 5
         */
        for(int i = 0;i < stringConvertedToChar.length;i++){
            stringConvertedToChar[i] = (char)(stringConvertedToChar[i] + 5);
        }
        
        /**
         * swap elements of the char array around, in 4's, so that in the end:
         * 1 with be swapped with 3
         * 2 with 1
         * 3 with 4
         * 4 with 2
         * 
         * it can be accomplished by doing the following:
         * swap 1 with 3,
         * 1 with 4,
         * 1 with 2
         */
        for(int i = stringConvertedToChar.length/4; i > 0; i--, cycle++){
            //1 with 3
            stringConvertedToChar = swapPlaces(stringConvertedToChar, cycle, 4, 1, 3);
            
            //2 with 5
            stringConvertedToChar = swapPlaces(stringConvertedToChar, cycle, 4, 1, 4);
            
            //3 with 2
            stringConvertedToChar = swapPlaces(stringConvertedToChar, cycle, 4, 1, 2);
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
        String haba = "napis wejsciowy";
        System.out.print(cypher(haba));
    }

}
