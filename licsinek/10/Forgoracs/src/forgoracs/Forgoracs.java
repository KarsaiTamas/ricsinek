package forgoracs;

import java.io.File;
import java.util.Scanner;

public class Forgoracs {

    public static void main(String[] args) {
        String szoveg = "";
        try{
            Scanner f = new Scanner(new File("szoveg.txt"));
    
            szoveg = f.nextLine();
            
            f.close();
        } catch (Exception e){
            System.out.println("Hiba" + e);
        }
        
        System.out.println("5. feladat:");
        System.out.println(szoveg);
        
        
        Fracs forgoRacs = new Fracs("kodlemez.txt", szoveg);

        System.out.println("7. feladat:");
        forgoRacs.KiirKodlemez();
        
        System.out.println("8. feladat:");
        forgoRacs.KiirAtalakitott();
        
        
        System.out.println("10. feladat:");
        forgoRacs.Titkosit();
        forgoRacs.KiirTitkositott();
        
    }
    
}
