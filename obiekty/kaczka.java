package objectsintro;


import static java.lang.Math.random;


/**
 *
 * @author dedged
 */
public class kaczka {

    private String kolor;
    private String imie;
    private final char plec;

    kaczka() {
        kolor = "czarny";
        imie = null;
        plec = (random()<0.5?'F':'M');
    }
    
    kaczka(String userImie){
        kolor = "czarny";
        imie = userImie;
        plec = (random()<0.5?'F':'M');
    }

    public String dajKolor(){
        return this.kolor;
    }
    
    public String dajImie(){
        return this.imie;
    }
    
    public char dajPlec(){
        return this.plec;
    }
    
    public kaczka ustawImie(String userImie){
        imie = userImie;
        return this;
    }
    
    public kaczka ustawKolor(String userKolor){
        kolor = userKolor;
        return this;
    }
    
    
}
