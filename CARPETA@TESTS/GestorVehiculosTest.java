package Test;

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
		ArrayList <Vehiculo> lista = new ArrayList<Vehiculo>();
		assertEquals(lista.size(), 0);
    }
	
	@Test
	public void addVehiculoCorrectamente() {
		Vehiculo v = mock(Vehiculo.class);
		when(v.getDisponibilidad()).thenReturn((int)1);
		ArrayList <Vehiculo> lista = new ArrayList<Vehiculo>();
		lista.add(v);
		assertEquals(lista.size(), 1);
	}
	
	@Test
	public void seBorraUnVehiculoCorrectamente() {
		Vehiculo v = mock(Vehiculo.class);
		ArrayList <Vehiculo> lista = new ArrayList<Vehiculo>();
		lista.add(v);
		int tam = lista.size();
		lista.remove(v);
		assertEquals(lista.size(), tam-1);
	}
}
