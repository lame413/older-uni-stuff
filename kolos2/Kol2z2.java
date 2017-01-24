/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kol2z2;

/**
 *
 * @author dedged
 */
public class Kol2z2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Klasa jest w pliku Testowa.java
        Testowa haba = new Testowa();
        System.out.println(haba.getImieNazwisko());
        System.out.println(haba.getWiek());
        
        haba.setWiek(12);
        haba.setImieNazwisko("foobar");
        
        System.out.println(haba.getImieNazwisko());
        System.out.println(haba.getWiek());
    }
    
}
