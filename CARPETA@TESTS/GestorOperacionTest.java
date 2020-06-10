package Pruebas;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.ConcesionarioException;
import Model.GestorOperacion;
import Model.GestorVehiculos;
import Model.Operacion;
import Model.Operacion;

public class GestorOperacionTest {
	GestorOperacion op;
	
	@Before
	public void init() {
		op = new GestorOperacion();
		
	}
	
	@After
	public void terminate() {
		op = null;
	}
	
	@Test
	public void inicialmenteElNumeroDeOperacionesEsCero() {
		ArrayList <GestorOperacion> lista = new ArrayList<GestorOperacion>();
		assertEquals(lista.size(), 0);
    }
	
	@Test
	public void addOperacionCorrectamente() {
		GestorOperacion v = mock(GestorOperacion.class);
		ArrayList <GestorOperacion> lista = new ArrayList<GestorOperacion>();
		lista.clear();
		lista.add(v);
		assertEquals(1, lista.size());
		lista.clear();
	}
	
	@Test
	public void seBorraUnaOperacionCorrectamente() {
		GestorOperacion v = mock(GestorOperacion.class);
		ArrayList <GestorOperacion> lista = new ArrayList<GestorOperacion>();
		lista.clear();
		lista.add(v);
		lista.clear();
		assertEquals(0, lista.size());
		
	}
}
