package tragaperras;

import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;


public class Maquina {
    private final int numero_casillas;
    private double credito_actual;
    private double valor_de_jugada;
    private final HashSet <Premio> premios = new HashSet<>();
    
    public Maquina(int numero_casillas, double valor, Premio... premios) {
        this.numero_casillas = numero_casillas;
        this.valor_de_jugada = valor;
        Collections.addAll(this.premios, premios);
        
    }

    
    public int getNumero_casillas() { return numero_casillas; }
    public double getValor_de_jugada() { return valor_de_jugada; }
    public double getCredito_actual() { return credito_actual; }
    
    
    public void setValor_de_jugada(double valor_de_jugada) { this.valor_de_jugada = valor_de_jugada; }
    
    
    public void incrementarCredito(double credito) {
        this.credito_actual += credito;
    }
    
    private ArrayList<Fruta> generarCombinacion() {
        ArrayList<Fruta> combinacion = new ArrayList<>(this.numero_casillas);
        Random random = new Random();
        Fruta[] frutas = Fruta.values();
        for(int i = 0; i < this.numero_casillas; i++) {
            Fruta fruta = frutas[random.nextInt(frutas.length)];
            combinacion.add(fruta);
        }
        
        return combinacion;
    }
    
    public ArrayList<Fruta> jugar() {
        if(this.credito_actual >= this.valor_de_jugada) {
            this.credito_actual -= this.valor_de_jugada;
            ArrayList <Fruta> combActual, combPremio;
            combActual = this.generarCombinacion();
            for(Premio pt : this.premios) {
                combPremio = pt.getCombinacion_ganadora();
                if(combActual.equals(combPremio)) {
                    this.credito_actual += pt.getCant_dinero();
                }
            }
            return combActual;
        }
        
            return null;
    }
    
    
}
