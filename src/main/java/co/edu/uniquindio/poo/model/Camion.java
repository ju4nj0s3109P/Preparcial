package co.edu.uniquindio.poo.model;

public class Camion extends Vehiculo {
    private int ejes;
    private int capacidadCarga;

    public Camion(String placa, int numeroPeajes, int capacidadCarga, int ejes) {
        super(placa, numeroPeajes);
        this.capacidadCarga = capacidadCarga;
        this.ejes = ejes;
    }

    public int getEjes() {
        return ejes;
    }

    public void setEjes(int ejes) {
        this.ejes = ejes;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }
    @Override
    public String mostrarInfo(){
        return toString();
    }

    @Override
    public String toString() {
        return "Camion{" +
                "ejes=" + ejes +
                ", capacidadCarga=" + capacidadCarga +
                ", placa='" + placa + '\'' +
                ", numeroPeajes=" + numeroPeajes +
                '}';
    }
}
