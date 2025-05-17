package co.edu.uniquindio.poo.model;

public abstract class Vehiculo {
    protected String placa;
    protected int numeroPeajes;

    public Vehiculo(String placa, int numeroPeajes) {
        this.placa = placa;
        this.numeroPeajes = numeroPeajes;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroPeajes() {
        return numeroPeajes;
    }

    public void setNumeroPeajes(int numeroPeajes) {
        this.numeroPeajes = numeroPeajes;
    }
    public abstract String mostrarInfo() ;
}
