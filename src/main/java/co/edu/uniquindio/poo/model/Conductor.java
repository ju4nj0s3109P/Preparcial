package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public record Conductor(ArrayList<Vehiculo> listaVehiculos,
                        String nombre,String apellido,String id, String fechaNacimiento) {

}
