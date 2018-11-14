package reversi;

import java.io.File;
import java.util.Scanner;

public class Tabla {

    private char[][] t;
    
    public Tabla(String fajlNev){
        this.t = new char[8][8];
        
        try{
            Scanner f = new Scanner(new File(fajlNev));

            int db = 0;
            while (f.hasNextLine()){
                String sor = f.nextLine();
                for (int i = 0; i < sor.length(); i++) {
                    this.t[db][i] = sor.charAt(i);
                }
                db++;
            }

            f.close();
        } catch(Exception e){
            System.out.println("Hiba: " + e.getMessage());
        }
    }

    public void Megjelenit(){
        String s = "";
        
        for (int i = 0; i < this.t.length; i++) {
            for (int j = 0; j < this.t[i].length; j++) {
                s += this.t[i][j];
            }
            s+= "\n";
        }
        
        System.out.println(s);
    }
    
    public int Megszamol(char c){
        int db = 0;
        for (int i = 0; i < this.t.length; i++) {
            for (int j = 0; j < this.t[i].length; j++) {
                if (t[i][j] == c){
                    db++;
                }
            }
        }

        return db;
    }
    
    public boolean VanForditas(char jatekos, int sor, int oszlop, int iranySor, int iranyOszlop){
        int aktSor, aktOszlop;
        char ellenfel;
        boolean nincsEllenfel;

        aktSor =sor + iranySor;
        aktOszlop =oszlop + iranyOszlop;
        ellenfel ='K';
        if (jatekos=='K') {
            ellenfel='F';
        }
        //ellenfel = jatekos=='F' ? 'K' : 'F';
        nincsEllenfel = true;

        while (aktSor>0 && aktSor<8 && aktOszlop>0 && aktOszlop<8 && 
                t[aktSor][aktOszlop]==ellenfel){
            aktSor =aktSor + iranySor;
            aktOszlop =aktOszlop + iranyOszlop;
            nincsEllenfel=false;
        }

        if (nincsEllenfel || aktSor<0 || aktSor>7 || aktOszlop<0 || aktOszlop>7 || t[aktSor][aktOszlop]!=jatekos){
            return false;
        }
        
        return true;
    }
    
    
}
