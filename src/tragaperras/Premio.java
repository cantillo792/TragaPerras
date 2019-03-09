package tragaperras;

import java.util.ArrayList;
import java.util.Objects;

public class Premio {
    private final ArrayList <Fruta> combinacion_ganadora;
    private final double cant_dinero;
    
    public Premio(double cant_dinero, Fruta... frutas) {
        this.cant_dinero = cant_dinero;
        combinacion_ganadora = new ArrayList<>();
        for(Fruta fru : frutas) {
           this.combinacion_ganadora.add(fru);
        }
      
    }
    
    
    public ArrayList<Fruta> getCombinacion_ganadora() { return combinacion_ganadora; }
    public double getCant_dinero() { return cant_dinero; }
    
   
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.combinacion_ganadora);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.cant_dinero) ^ (Double.doubleToLongBits(this.cant_dinero) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Premio other = (Premio) obj;
        return Objects.equals(this.combinacion_ganadora, other.combinacion_ganadora);
    }
}
