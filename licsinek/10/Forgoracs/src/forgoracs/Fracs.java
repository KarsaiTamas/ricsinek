package forgoracs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Fracs {

    private char[][] Kodlemez; 
    private char[][] Titkositott;
    private String Titkositando;
    
    public Fracs(String fajlNev, String titkositandoSzoveg){
        //a
        this.Kodlemez = new char[8][8];
        this.Titkositott = new char[8][8];

        
        //b
        /*
        try{
            FileReader fr = new FileReader(fajlNev);
            BufferedReader br = new BufferedReader(fr);

            String sor = br.readLine();
            int db = 0;
            while (sor != null){
                for (int i = 0; i < sor.length(); i++) {
                    this.Kodlemez[db][i] = sor.charAt(i);                
                }
                
                sor = br.readLine();
                db++;
            }

            br.close();
            fr.close();
        } catch(Exception e){
            System.out.println("Hiba:" + e.getMessage());
        }
        */
        
        try{
            Scanner f = new Scanner(new File(fajlNev));

            int db = 0;
            while (f.hasNextLine()){
                String sor = f.nextLine();
                for (int i = 0; i < sor.length(); i++) {
                    this.Kodlemez[db][i] = sor.charAt(i);
                }
                db++;
            }

            //c
            this.Titkositando = titkositandoSzoveg;

            //d
            this.Atalakit();
            
            f.close();
        } catch(Exception e){
            System.out.println("Hiba: " + e.getMessage());
        }
        
        
        
    }
    
    public void Atalakit() throws Exception{
        String s = "";
        for (int i = 0; i < this.Titkositando.length(); i++) {
            char c = this.Titkositando.charAt(i);

            if (c != ' ' && c != '.' && c != ','){
                s += c;
            }
        }
        this.Titkositando = s;
        
        if (this.Titkositando.length() > 64){
            throw new Exception("Túl hosszú a titkosítandó szöveg!");
        }
        
        for (int i = this.Titkositando.length(); i < 64; i++) {
            this.Titkositando += "X";
        }
        
    }
    
    public void KiirKodlemez(){
        String s = "";
        
        for (int i = 0; i < this.Kodlemez.length; i++) {
            for (int j = 0; j < this.Kodlemez[i].length; j++) {
                s += this.Kodlemez[i][j];
            }
            s+= "\n";
        }
        
        System.out.println(s);
    }
    
    public void KiirAtalakitott(){
        System.out.println(this.Titkositando);
    }
    
    public char[][] ForgatKodlemez(){
        char[][] ujKodlemez = new char[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ujKodlemez[7-j][i] = this.Kodlemez[i][j];
            }
        }
        
        return ujKodlemez;
    }

    public void Titkosit(){
        int i = 0;
        while (i < this.Titkositando.length()){

            for (int sor = 0; sor < 8; sor++) {
                for (int oszlop = 0; oszlop < 8; oszlop++) {
                    if (this.Kodlemez[sor][oszlop] == 'A' ){
                        this.Titkositott[sor][oszlop] = this.Titkositando.charAt(i);
                        i++;
                    }
                }
            }
            if (i % 16 == 0){
                this.Kodlemez = this.ForgatKodlemez();
            }
            
        }
    }
    
    public void KiirTitkositott(){
        String s = "";
        
        for (int i = 0; i < this.Titkositott.length; i++) {
            for (int j = 0; j < this.Titkositott[i].length; j++) {
                s += this.Titkositott[i][j] + " ";
            }
            s+= "\n";
        }
        
        System.out.println(s);
    }

    
    
}
