package intsfileio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author dedged
 */
public class IntsFileIO {

    public static void createIntsFile(int count, String filePath) throws FileNotFoundException, IOException {
        Random rnd = new Random(); // do generowania liczb pseudolosowych

        int wylosowanaLiczba; 

        File randomInts = new File(filePath); //otwieramy plik do którego pakujemy inty
        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(randomInts));

        System.out.print("Wygenerowane liczby: ");

        for (int i = 0; i < count; i++) {
            wylosowanaLiczba = rnd.nextInt(30);
            dos.writeInt(wylosowanaLiczba);
            System.out.print(" " + wylosowanaLiczba);
        }
        dos.close();
    }

    public static double getMeanFromFile(int count, String file) throws FileNotFoundException, IOException {
        double mean = 0;
        File randomInts = new File(file);
        DataInputStream dis = new DataInputStream(
                new FileInputStream(randomInts));

        for (int i = 0; i < count; i++) {
            mean += dis.readInt();
        }

        dis.close();
        System.out.println();
        System.out.println("Ilość liczb: " + count);
        System.out.println("Wyliczona średnia: " + mean);
        return mean / count;
    }

    public static void writeMeanToFile(double mean, String file) throws FileNotFoundException, IOException {
        File intsMean = new File(file);

        DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(intsMean));

        dos.writeDouble(mean);
        dos.close();
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String filenameRand, filenameMean = new String();
        filenameRand = "data.bin"; // Plik z intami
        filenameMean = "data_mean.bin"; // Plik ze średnią
        int intCount = 10;

        createIntsFile(intCount, filenameRand);
        writeMeanToFile(getMeanFromFile(intCount, filenameRand), filenameMean);
    }

}
