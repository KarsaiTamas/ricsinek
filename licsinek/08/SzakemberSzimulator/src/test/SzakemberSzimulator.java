package test;

import java.util.ArrayList;
import java.util.List;
import szakemberszimulator.Burkolo;
import szakemberszimulator.MesterEmber;
import szakemberszimulator.VizVezetekSzerelo;

public class SzakemberSzimulator {

    public static void main(String[] args) {

/*   
        MesterEmber geza = new MesterEmber("Burkolo Geza", 18000);
        System.out.println(geza);
 */      
        Burkolo geza = new Burkolo("Burkolo Geza", 18000, Burkolo.Helyszin.Belso);
//        System.out.println(geza);
        geza.munkatVallal(1);
        
        geza.munkatVallal(20);
        geza.munkatVallal(21);
        geza.munkatVallal(22);
        
        geza.munkatVallal(30);
//        System.out.println(geza);

        System.out.println(geza.osszesSzabadNap());
        
        
        List<MesterEmber> szakEmberLista = new ArrayList<>();
        szakEmberLista.add(geza);
        szakEmberLista.add(new Burkolo("Kis Elemér", 60000, Burkolo.Helyszin.Kulso));
        szakEmberLista.add(new VizVezetekSzerelo("Viz Elek", 45000, 12));

        for (MesterEmber sze : szakEmberLista) {
            System.out.println(sze);
        }
        
        
        
    }
    
}
