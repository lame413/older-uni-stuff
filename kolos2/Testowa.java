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
public class Testowa {
    private int wiek;
    private String imieNazwisko;
    
    Testowa(){
        wiek = -1;
        imieNazwisko = "Tutaj imię i nazwisko";
    }
    
    // get wiek
    int getWiek(){
        return wiek;
    }
    
    // get imieNazwisko
    String getImieNazwisko(){
        return imieNazwisko;
    }
    
    // set wiek
    Testowa setWiek(int newWiek){
        wiek = newWiek;
        return this;
    }
    
    // set imieNazwisko
    Testowa setImieNazwisko(String newImieNazwisko){
        imieNazwisko = newImieNazwisko;
        return this;
    }
}
