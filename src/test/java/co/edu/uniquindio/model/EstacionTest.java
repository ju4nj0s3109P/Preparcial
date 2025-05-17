package co.edu.uniquindio.model;

import co.edu.uniquindio.poo.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EstacionTest {
    @Test
    public void TestCalcularPeajeCarro() {
        Estacion estacion = new Estacion("estacion1", "quindio", 0);
        Carro carro = new Carro("evp860", 2, false, true);
        int tamañoListaAntes = estacion.getVehiculosAtendidos().size();
        double peaje = estacion.calcularPeajeCarro(carro);
        assertEquals(11500, peaje, 0.1);
        assertTrue(estacion.getTotalRecolectado() > 0);
        assertEquals(tamañoListaAntes + 1, estacion.getVehiculosAtendidos().size());

    }

    @Test
    public void TestCalcularPeajeMoto() {
        Estacion estacion = new Estacion("estacion1", "quindio", 0);
        Moto moto = new Moto("ast123", 2, false);
        int tamañoListaAntes = estacion.getVehiculosAtendidos().size();
        double peaje = estacion.calcularPeajeMoto(moto);
        assertEquals(7000, peaje, 0.1);
        assertTrue(estacion.getTotalRecolectado() > 0);
        assertEquals(tamañoListaAntes + 1, estacion.getVehiculosAtendidos().size());
    }

    @Test
    public void TestCalcularPeajeCamion() {
        Estacion estacion = new Estacion("estacion1", "quindio", 0);
        Camion camion = new Camion("ast123", 2, 11, 2);
        int tamañoListaAntes = estacion.getVehiculosAtendidos().size();
        double peaje = estacion.calcularPeajeCamion(camion);
        assertEquals(15400, peaje, 0.1);
        assertTrue(estacion.getTotalRecolectado() > 0);
        assertEquals(tamañoListaAntes + 1, estacion.getVehiculosAtendidos().size());
    }

    @Test
    public void TestAsignarVehiculo() {
        Estacion estacion = new Estacion("estacion1", "quindio", 0);
        Conductor conductor = new Conductor(new ArrayList<>(), "juan", "rengifo", "12345", "12/02/2007");
        Vehiculo vehiculo = new Carro("evp860", 2, false, true);
        estacion.asignarVehiculo(vehiculo, conductor);
        assertTrue(conductor.listaVehiculos().contains(vehiculo));
    }
    @Test
    public void TestListadoDetallado() {
        Estacion estacion = new Estacion("estacion1", "quindio", 0);

        Vehiculo vehiculo = new Carro("evp860", 2, false, true);
        Vehiculo vehiculo2 = new Moto("evp861", 2, true);
        Vehiculo vehiculo3 = new Camion("evp862", 2, 9, 2);
        assertTrue(estacion.listadodetallado().contains("No ha pasado nadie"));
        estacion.calcularPeajeCamion((Camion) vehiculo3);
        estacion.calcularPeajeCarro((Carro) vehiculo);
        estacion.calcularPeajeMoto((Moto) vehiculo2);
        String listado = estacion.listadodetallado();
        assertTrue(listado.contains("evp860"));
        assertTrue(listado.contains("evp861"));
        assertTrue(listado.contains("evp862"));
    }
    @Test
    public void TestTotalPagadoPorVehiculo() {
        Estacion estacion = new Estacion("estacion1", "quindio", 0);
        Conductor conductor = new Conductor(new ArrayList<>(), "juan", "rengifo", "12345", "12/02/2007");
        Vehiculo vehiculo = new Carro("evp860", 2, false, true);
        Vehiculo vehiculo2 = new Moto("evp861", 2, true);
        assertTrue(estacion.totalPagadoPorVehiculo(conductor).contains("No tiene vehículos"));
        estacion.asignarVehiculo(vehiculo, conductor);
        estacion.asignarVehiculo(vehiculo2, conductor);
        assertTrue(estacion.totalPagadoPorVehiculo(conductor).contains("evp860"));
        assertTrue(estacion.totalPagadoPorVehiculo(conductor).contains("evp861"));
    }
    @Test
    public void TestVehiculosConductorSegunTipoVehiculo(){
        Estacion estacion = new Estacion("estacion1", "quindio", 0);
        Conductor conductor = new Conductor(new ArrayList<>(), "juan", "rengifo", "12345", "12/02/2007");
        Vehiculo vehiculo = new Carro("evp860", 2, false, true);
        Vehiculo vehiculo2 = new Moto("evp861", 2, true);
        estacion.asignarVehiculo(vehiculo, conductor);
        estacion.asignarVehiculo(vehiculo2, conductor);
        String resultadoCarro= estacion.vehiculosConductorSegunTipoVehiculo(conductor,"carro");
        String resultadoMoto=estacion.vehiculosConductorSegunTipoVehiculo(conductor,"moto");
        String resultadoCamion=estacion.vehiculosConductorSegunTipoVehiculo(conductor,"camion");
        assertTrue(resultadoCarro.contains("carro"));
        assertTrue(resultadoMoto.contains("moto"));
        assertTrue(resultadoCamion.contains("No tiene"));
    }
@Test
    public void TestBuscarRecaudadorPorNombreCompleto(){
        Estacion estacion = new Estacion("estacion1", "quindio", 0);
        Recaudador recaudador= new Recaudador("jose","ruiz","9876","12/02/2000",100000);
        estacion.getListaRecaudadores().add(recaudador);
        String resultado= estacion.buscarRecaudadorPorNombreCompleto("jose","ruiz");
        assertTrue(resultado.contains("9876"));

}
@Test
    public void TestListaConductoresVehiculoMasDiezToneladas(){
        Estacion estacion = new Estacion("estacion1", "quindio", 0);
        Conductor conductor = new Conductor(new ArrayList<>(), "juan", "rengifo", "12345", "12/02/2007");
        Conductor conductor2 = new Conductor(new ArrayList<>(), "juan", "rengifo", "12345", "12/02/2007");
        Conductor conductor3 = new Conductor(new ArrayList<>(), "juan", "rengifo", "12345", "12/02/2007");
        Vehiculo vehiculo = new Carro("evp860", 2, false, true);
        Vehiculo vehiculo2 = new Moto("evp861", 2, true);
        Vehiculo vehiculo3 = new Camion("evp862", 2, 9, 2);
        Vehiculo vehiculo4 = new Camion("evp862", 2, 15, 2);
        Vehiculo vehiculo5 = new Camion("evp862", 2, 16, 2);
        estacion.getListaConductores().add(conductor);
        estacion.getListaConductores().add(conductor2);
        estacion.getListaConductores().add(conductor3);
        estacion.asignarVehiculo(vehiculo, conductor3);
        estacion.asignarVehiculo(vehiculo2, conductor3);
        estacion.asignarVehiculo(vehiculo3, conductor);
        estacion.asignarVehiculo(vehiculo4, conductor);
        estacion.asignarVehiculo(vehiculo5, conductor2);
        int numConductresEnLaLista = estacion.listaConductoresVehiculoMasDiezToneladas().size();
        assertEquals(2,numConductresEnLaLista );


    }
}



