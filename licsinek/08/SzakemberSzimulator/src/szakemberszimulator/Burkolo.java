package szakemberszimulator;

public class Burkolo extends MesterEmber {
    //Ez egy saját felsorolás típus!
    public enum Helyszin{
        Belso, 
        Kulso
    }
    
    private Helyszin szakTerulet;
    
    
    public Burkolo(String nev, int napiDij, Helyszin szakTerulet){
        super(nev, napiDij);
        this.szakTerulet = szakTerulet;
    }
    
    @Override
    public boolean munkatVallal(int nap) {
        if (!this.foglaltNapok[nap-1]){
            this.foglaltNapok[nap-1] = true;
            return true;
        }
        return false;
    }

    public int osszesSzabadNap(){
        int db = 0;
        for (int i = 0; i < this.foglaltNapok.length ; i++) {
            if (!this.foglaltNapok[i]){
                db++;
            }
        }
        return db;
    }
    
    @Override
    public String toString(){
        String s = super.toString(); //Meghívja a mesterEmber toStringjét!
        String[] sorok = s.split("]");

        if (this.szakTerulet == Helyszin.Belso){
            sorok[0] += " - Belső burkoló]";    
        }else if (this.szakTerulet == Helyszin.Kulso){
            sorok[0] += " - Külső burkoló]";                
        }
        
        return sorok[0] + sorok[1];
    } 
    
}
