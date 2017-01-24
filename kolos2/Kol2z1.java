/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kol2z1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author dedged
 */
public class Kol2z1 {

    /*
    * creates a file with values taken from the exercise's description
     */
    public static void createSampleFile() throws FileNotFoundException, IOException {
        File numbers = new File("liczby");
        DataOutputStream dis = new DataOutputStream(
                new FileOutputStream(numbers));

        dis.writeInt(3);
        dis.writeInt(10);
        dis.writeFloat((float) 3.1);
        dis.writeFloat((float) 2.2);
        dis.writeFloat((float) 1.3);
        dis.writeInt(2);
        dis.writeInt(4);
        dis.writeFloat((float) 2.1);
        dis.writeFloat((float) 5.2);
        dis.writeInt(2);
        dis.writeInt(100);
        dis.writeFloat((float) 5.4);
        dis.writeFloat((float) 1.4);

        dis.close();
    }

    /**
     *
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        /**
         * variable storing path to input file
         */
        String filePath;

        /**
         * number of fp numbers to analyze
         */
        int fpCount;
        
        /**
        * highest value that the local sum can get to before being ignored
        */
        int maxSum;
        
        /**
         * fp sum for a given cycle 
         */
        float curSum;
        
        /*
        * sum of all valid partial values
        */
        float endSum = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /**
         * getting the file path from the user
         */
        System.out.println("Podaj ścieżkę do pliku (gotowy plik - \"liczby\"): ");
        filePath = br.readLine();

        File numbers = new File(filePath); //opening, initiating the file

        /**
         * if the user called the example file, check if it exists, if not,
         * create it
         */
        if ("liczby".equals(filePath)) {
            if (!numbers.exists()) {
                createSampleFile();
            }
        }

        DataInputStream dis = new DataInputStream(
                new FileInputStream(numbers));
        /**
         * main calculations loop
         */
        for (; dis.available() > 0;) {
            // reset the temporary sum
            curSum = 0;
            // get the number of floats
            fpCount = dis.readInt();
            // maximum value for current partial sum
            maxSum = dis.readInt();
            
            // go through the floats, add them up until it runs out of floats, 
            // or their sum exceeds maxSum
            for(;fpCount > 0; fpCount--){
                curSum += dis.readFloat();
                // check if it exceeded maxSum, if so, reset curSum and end the
                // cycle
                if(curSum > (float)maxSum){
                    curSum = 0;
                    break;
                }
            }
            // add the current parital sum to the end result   
            endSum += curSum;
        }
        
        System.out.println("Wynik: " + endSum);
    }
}
