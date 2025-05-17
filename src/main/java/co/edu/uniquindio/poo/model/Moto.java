package co.edu.uniquindio.poo.model;

public class Moto extends Vehiculo {
    private boolean cilindrajemenordocientos;

    public Moto(String placa, int numeroPeajes, boolean cilindrajemenordocientos) {
        super(placa, numeroPeajes);
        this.cilindrajemenordocientos = cilindrajemenordocientos;
    }

    public boolean isCilindrajemenordocientos() {
        return cilindrajemenordocientos;
    }

    public void setCilindrajemenordocientos(boolean cilindrajemenordocientos) {
        this.cilindrajemenordocientos = cilindrajemenordocientos;
    }
    @Override
    public String mostrarInfo(){
        return toString();
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindrajemenordocientos=" + cilindrajemenordocientos +
                ", placa='" + placa + '\'' +
                ", numeroPeajes=" + numeroPeajes +
                '}';
    }
}
