package szakemberszimulator;

public class VizVezetekSzerelo extends MesterEmber{

    private int tapasztalat;
    
    public VizVezetekSzerelo(String nev, int napiDij, int tapasztalat){
        super(nev, napiDij);
        this.tapasztalat = tapasztalat;
    }

    @Override
    public boolean munkatVallal(int nap) {
        if (nap>1 && nap< 31 && 
            !foglaltNapok[nap-2] && !foglaltNapok[nap-1] && !foglaltNapok[nap]){
            foglaltNapok[nap-2] = true;
            foglaltNapok[nap-1] = true;
            foglaltNapok[nap] = true;
            return true;
        }
        return false;
    }
}
