package reversi;

import java.util.Scanner;

public class Reversi {

    public static void main(String[] args) {

        Tabla t = new Tabla("allas.txt");
        System.out.println("5. feladat: A betöltött tábla:");
        t.Megjelenit();

        System.out.println("6. feladat: Összegzés:");
        System.out.println("Kék korongok száma:" + t.Megszamol('K'));
        System.out.println("Fehér korongok száma:" + t.Megszamol('F'));
        System.out.println("Üres mezők száma:" + t.Megszamol('#'));

        Scanner sc = new Scanner(System.in);
        System.out.println("például: F;4;1;0;1");
        System.out.print("8. feladat: [jatekos;sor;oszlop;iranySor;iranyOszlop] = ");
        String kovetkezoLepes = sc.nextLine();
        
        String[] adatok = kovetkezoLepes.split(";");
        
        char jatekos = adatok[0].charAt(0);
        int sor = Integer.parseInt(adatok[1]); 
        int oszlop = Integer.parseInt(adatok[2]); 
        int iranySor = Integer.parseInt(adatok[3]); 
        int iranyOszlop = Integer.parseInt(adatok[4]); 
        
        boolean vanEForditas = t.VanForditas(jatekos, sor, oszlop, iranySor, iranyOszlop);
        if (vanEForditas){
            System.out.println("Van fordítás!");
        }else{
            System.out.println("Nincs fordítás!");
        }
        
        
    
    }
    
}
