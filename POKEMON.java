package pokemon;
/*
* @author dedged
*/
public class POKEMON {
    public static void main(String[] args) {
        // string bazowy, którego przekonwertujemy na 'poke'string
        String strBaza = new String("Ala ma kota asdfasdfsda");

        //Nowy, póki co pusty string, który będzie trzymać 'poketekst'
        String strPoke = new String();

        /* 
        * Musimy przelecieć przez cały oryginalny string, dla każdego
        * znaku sprawdzić czy jest dużą czy małą literą i albo go 'przemienić'
        * na małą/dużą literę, albo go zostawić jak jest. Jako iż stringów nie
        * da się modyfikować, to trzeba stworzyć drugiego stringa i w nim 
        * zapisywać kolejne znaki 'poketekstu', tj. gdzie co drugi znak jest
        * pisany z małej litery (prościej, małe znaki na pozycjach parzystych, 
        * duże na nieparzystych).
        * 
        * Co do samej konwersji znaku, jest to proste - by zamienić małą literę
        * w dużą wystarzy od niej odjąć 32, a dużą w małą - odjąć 32. Wynika to
        * z pozycji znaków w tabeli ASCII http://www.bibase.com/images/ascii.gif
        * Każdy widoczny tam znak jest przypisany do danej wartości i można na
        * nich operować jak na liczbach. Efektywnie dodając do 'A' (pozycja 65)
        * liczbę 3 dostaniemy 'D' (pozycja 68). Tak samo odejmując 'A' od 'a' 
        * dostaniemy 'odległość' pomiędzy dużymi i małymi literami, tj. 32.
        */
        
        System.out.println((char) ('E' + 3)); // wyświetli "H"
        System.out.println((char) ('A' + ('a' - 'A'))); // wyświetli "a"
        System.out.println((char) ('B' + 32)); // wyświetli "b"
        System.out.println((char) ('a' - 32)); // wyświetli "A"

        /*
        * Jak widać, jeżeli na charze się wykonało jakąś operację, to trzeba go
        * potem znów rzutować na char - inaczej program nam wyświetli wartość
        * znaku a nie znak:
        */
        
        System.out.println('g' + 8); // chcemy 'o', ale program wyświetla 111

        /*
        * Teraz jest kwestia przeszukania bazowego stringa i sprawdzenia, który
        * znak ma być pisany wielką, a który małą literą.
        * Najprościej do tego podejść przez sprawdzanie w każdej iteracji pętli,
        * czy aktualnie jesteśmy na znaku na parzystym/nieparzystym miejscu
        * i zależnie od tego spróbować przekonwertować owy znak na mały/duży:
        */
        
        for (int i = 0; i < strBaza.length(); i++) {
            if (strBaza.charAt(i) % 2 == 0) { // jeżeli jest parzysta pozycja
                /*
                * Wpierw sprawdzamy czy litera jest duża, 
                * jak tak to ją konwertujemy na małą:
                 */
                if (strBaza.charAt(i) >= 'A' && strBaza.charAt(i) < 'a') { // jeżeli jest duża...
                    /* 
                    * ...to dodajemy do niej 32, zamieniając ją 
                    * na małą, i wpisujemy to do nowego stringa
                     */
                    strPoke += (char) (strBaza.charAt(i) + 32);
                } else { // jeżeli jest mała...
                    // ...to po prostu ją wpisujemy do nowego stringa
                    strPoke += strBaza.charAt(i);
                }
            } else { // jeżeli nieparzysta
                if (strBaza.charAt(i) >= 'a') { // jeżeli litera jest mała...
                    /* 
                    * ...to odejmujemy 32, zamieniając ją na 
                    * dużą i wpisujemy to do nowego stringa
                     */
                    strPoke += (char) (strBaza.charAt(i) - 32);
                } else { // jeżeli jest duża...
                    // ...to po prostu ją wpisujemy do nowego stringa
                    strPoke += strBaza.charAt(i);
                }
            }
        }
        // Na koniec, wypisujemy nowopowstały pokestring
        System.out.println(strPoke);
    }
}
