/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kol2z3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dedged
 */
public class Kol2z3 {

    public static String abcStringConversion(String sourceStr) {
        // check if the source string should be set to the exaple a/b/c 
        // combination
        if (sourceStr.equalsIgnoreCase("x")){
            sourceStr = "abaabbaaabbbcaacc";
        }
        
        // Stores the end lenght of the new array and string
        int newCharArrayLength = 0;

        char curChar; // stores currently analyzed char
        char nextChar; // stores the next char

        String convertedString = new String();

        // Analyze the string to get the new strings' lenght.
        for (int i = 0; i < sourceStr.length(); i++) {
            curChar = sourceStr.charAt(i);
            if (i < sourceStr.length() - 1) {
                nextChar = sourceStr.charAt(i + 1);
            } else {
                nextChar = 'x';
            }

            switch (curChar) {
                case 'a':
                    if (nextChar == 'a') {
                        convertedString = new String(convertedString + "a");
                        i++;
                    }
                    break;
                case 'b':
                    if (nextChar == 'b') {
                        convertedString = new String(convertedString + "bbb");
                        i++;
                    } else {
                        convertedString = new String(convertedString + "b");
                    }
                    break;
                case 'c':
                    if (nextChar == 'c') {
                        convertedString = new String(convertedString + "ba");
                        i++;
                    } else {
                        convertedString = new String(convertedString + "ab");
                    }
                    break;
                default:
                    System.out.println("Inny znak niż a/b/c w inpucie!");
                    break;
            }

        }

        return convertedString;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Podaj ciąg a/b/c ('x' dla napisu z polecenia): ");
        System.out.println("\n" + abcStringConversion(br.readLine()));
    }

}
