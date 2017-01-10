
package objectsintro;

/**
 *
 * @author dedged
 */
public class ObjectsIntro {

    public static void main(String[] args) {
        kaczka haba = new kaczka("dziwaczka");
        kaczka pep = new kaczka();
        
        System.out.println(haba.dajKolor());
        System.out.println(haba.dajImie());
    }
    
}
