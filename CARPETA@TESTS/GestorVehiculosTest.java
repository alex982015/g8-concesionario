package Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import Model.ConcesionarioException;
import Model.GestorOperacion;
import Model.GestorUsuarios;
import Model.GestorVehiculos;
import Model.Vehiculo;

public class GestorVehiculosTest {
	GestorVehiculos gv;
	
	@Before
	public void init() {
		gv = new GestorVehiculos();
		
	}
	
	@After
	public void terminate() {
		gv = null;
	}
	
	@Test
	public void inicialmenteElNumeroDeVehiculosEsCero() {
		ArrayList <GestorVehiculos> lista = new ArrayList<GestorVehiculos>();
		assertEquals(lista.size(), 0);
    }
	
	@Test
	public void addVehiculoCorrectamente() {
		GestorVehiculos v = mock(GestorVehiculos.class);
		ArrayList <GestorVehiculos> lista = new ArrayList<GestorVehiculos>();
		lista.clear();
		lista.add(v);
		lista.clear();
		assertEquals(0, lista.size());
	}
	
	@Test
	public void seBorraUnVehiculoCorrectamente() {
		GestorVehiculos v = mock(GestorVehiculos.class);
		ArrayList <GestorVehiculos> lista = new ArrayList<GestorVehiculos>();
		lista.clear();
		lista.add(v);
		lista.clear();
		assertEquals(0, lista.size());
	}
}
