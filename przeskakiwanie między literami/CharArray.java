/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgchar.array;

import java.util.Scanner;

/**
 *
 * @author dedged
 */
public class CharArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int tableSize;

        System.out.print("Podaj rozmiar tablicy: ");
        tableSize = sc.nextInt();

        char[] charTable = new char[tableSize];

        char currentChar = 'z';

        
        for (int i = 0; i < tableSize; i++) {

            
            charTable[i] = currentChar;
            
            currentChar = (char) (currentChar - 3);
            
            
            
            System.out.print((int) currentChar + " "); // debug
            
            if (currentChar < 'a') { // check if it looped
                currentChar = (char) (currentChar + ('z' - 'a'));
                System.out.print("looped "); // debug
            }
        }
        
        System.out.println();
            
        // draw the table
        for (int i = 0; i < tableSize; i++) {
            System.out.print(charTable[i] + ", ");
        }
       /*
       int i, j, z, k;
       i = 2;
       j = ++i;
       z = 0;
       k = 0;
       
       for(;i < 10; i++){
           z -= j++ + ++i;
           k++;
       }
       
       System.out.println(i);
       System.out.println(j);
       System.out.println(z);
       System.out.println(k);*/
    }

}
