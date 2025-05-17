package co.edu.uniquindio.poo.model;

public class Carro extends Vehiculo {
    private boolean electrico;
    private boolean publico;

    public Carro(String placa, int numeroPeajes, boolean electrico, boolean publico) {
        super(placa, numeroPeajes);
        this.electrico = electrico;
        this.publico = publico;
    }


    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }
    @Override
    public String mostrarInfo() {
        return toString();
    }

    @Override
    public String toString() {
        return "Carro{" +
                "Electrico=" + electrico +
                ", publico=" + publico +
                ", placa='" + placa + '\'' +
                ", numeroPeajes=" + numeroPeajes +
                '}';
    }
}
