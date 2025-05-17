package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Estacion {

    private String nombre;
    private String departamento;
    private double  totalRecolectado;
    private ArrayList<Vehiculo> vehiculosAtendidos=new ArrayList<>();
    private ArrayList<Recaudador> listaRecaudadores = new ArrayList<>();
    private ArrayList<Conductor> listaConductores=new ArrayList<>();
    private Map<Vehiculo, Double> peajesPorVehiculo = new HashMap<>();


    public Estacion(String nombre, String departamento, double totalRecolectado) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.totalRecolectado = totalRecolectado;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public ArrayList<Vehiculo> getVehiculosAtendidos() {
        return vehiculosAtendidos;
    }

    public void setVehiculosAtendidos(ArrayList<Vehiculo> vehiculosAtendidos) {
        this.vehiculosAtendidos = vehiculosAtendidos;
    }

    public ArrayList<Recaudador> getListaRecaudadores() {
        return listaRecaudadores;
    }

    public void setListaRecaudadores(ArrayList<Recaudador> listaRecaudadores) {
        this.listaRecaudadores = listaRecaudadores;
    }

    public ArrayList<Conductor> getListaConductores() {
        return listaConductores;
    }

    public void setListaConductores(ArrayList<Conductor> listaConductores) {
        this.listaConductores = listaConductores;
    }

    public double getTotalRecolectado() {
        return totalRecolectado;
    }

    public void setTotalRecolectado(double totalRecolectado) {
        this.totalRecolectado = totalRecolectado;
    }
    public double calcularPeajeCarro(Carro carro) {
        double peaje = 10000;
        if (carro.isElectrico()==true&& carro.isPublico()==true) {
            peaje *= 0.05;
        }else if (carro.isElectrico()==true&&carro.isPublico()==false) {
            peaje *= 0.2;
        }else if (carro.isElectrico()==false&&carro.isPublico()==true) {
            peaje = (peaje*0.15)+peaje;
        }
        return peaje;
    }
    public double calcularPeajeMoto(Moto moto) {
        double peaje = 5000;
        if(moto.isCilindrajemenordocientos()==false) {
            peaje+=2000;
        }
        return peaje;

    }
    public double calcularPeajeCamion(Camion camion) {
        double peaje = 7000*camion.getEjes();
        if(camion.getCapacidadCarga()>10){
            peaje= (peaje*0.1)+peaje;
        }
        return peaje;
    }
    public void registrarPeajeVehiculo(Vehiculo vehiculo, double peaje) {
        vehiculosAtendidos.add(vehiculo);
        peajesPorVehiculo.put(vehiculo, peaje);
        totalRecolectado += peaje;
        vehiculo.setNumeroPeajes(vehiculo.getNumeroPeajes() + 1);
    }

    public void asignarVehiculo(Vehiculo vehiculo,Conductor conductor){
        conductor.listaVehiculos().add(vehiculo);
    }
    public String listadodetallado(){
        if (vehiculosAtendidos.isEmpty()) {
            return "No ha pasado nadie";
        }
        String listado="Total recolectado: "+totalRecolectado;
        for(Vehiculo vehiculo:vehiculosAtendidos){
            String tipo= vehiculo instanceof Carro ? "Carro" :
                    vehiculo instanceof Moto ? "Moto":
                    vehiculo instanceof Camion ? "Camion":
                    "Desconocido";
            listado+=vehiculo.toString() + "Tipo Vehiculo: "+tipo + "Costo peaje"+ peajesPorVehiculo.get(vehiculo)+"\n";
        }
        return listado;
    }
    public String totalPagadoPorVehiculo(Conductor conductor) {
        if (conductor.listaVehiculos().isEmpty()) {
            return "No tiene vehículos";
        }

        String mensaje = "";

        for (Vehiculo vehiculo : conductor.listaVehiculos()) {
            double peajeUnitario = 0;

            if (vehiculo instanceof Carro) {
                peajeUnitario = calcularPeajeCarro((Carro) vehiculo);
            } else if (vehiculo instanceof Moto) {
                peajeUnitario = calcularPeajeMoto((Moto) vehiculo);
            } else if (vehiculo instanceof Camion) {
                peajeUnitario = calcularPeajeCamion((Camion) vehiculo);
            }

            int numPeajes = vehiculo.getNumeroPeajes();
            double totalPagado = peajeUnitario * numPeajes;

            mensaje += vehiculo.toString() + " Total pagado: " + totalPagado + "\n";
        }

        return mensaje;
    }



    public String vehiculosConductorSegunTipoVehiculo(Conductor conductor,String tipoVehiculo){
        String mensaje="vehiculos de tipo: "+tipoVehiculo.toLowerCase()+"Del conductor"+(conductor.nombre()+conductor.apellido())+" son:"+"\n";
        for(int i = 0; i<conductor.listaVehiculos().size(); i++){
            if(conductor.listaVehiculos().get(i) instanceof Carro&& tipoVehiculo.equalsIgnoreCase("carro")){
                mensaje+=conductor.listaVehiculos().get(i).toString()+"\n";
            }else if (conductor.listaVehiculos().get(i) instanceof Moto&& tipoVehiculo.equalsIgnoreCase("moto")){
                mensaje+=conductor.listaVehiculos().get(i).toString()+"\n";
            } else if (conductor.listaVehiculos().get(i) instanceof Camion && tipoVehiculo.equalsIgnoreCase("camion")){
                mensaje+=conductor.listaVehiculos().get(i).toString()+"\n";
            }else{ mensaje+= "No tiene";}
        }
        return mensaje;
    }

    public String buscarRecaudadorPorNombreCompleto(String nombre, String apellido) {
        for (Recaudador r : listaRecaudadores) {
            if (r.nombre().equals(nombre) && r.apellido().equals(apellido)) {
                return "El Recaudador con nombre: " + nombre + " " + apellido + " es:\n" + r.toString();
            }
        }
            return "No existe un Recaudador con nombre: " + nombre + " " + apellido;
    }



        public ArrayList<Conductor> listaConductoresVehiculoMasDiezToneladas(){
        ArrayList<Conductor>lista=new ArrayList<>();
        for (int i = 0; i <listaConductores.size() ; i++) {
            for (int j = 0; j < listaConductores.get(i).listaVehiculos().size(); j++) {
                if (listaConductores.get(i).listaVehiculos().get(j) instanceof Camion&&((Camion) listaConductores.get(i).listaVehiculos().get(j)).getCapacidadCarga()>10){
                    lista.add(listaConductores.get(i));
                    break;
                }
            }
        }
        return lista;
    }



    @Override
    public String toString() {
        return "Estacion{" +
                "nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", totalRecolectado=" + totalRecolectado +
                '}';
    }
}
