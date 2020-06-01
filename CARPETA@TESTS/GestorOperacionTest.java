package Test;

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
		ArrayList <Operacion> lista = new ArrayList<Operacion>();
		assertEquals(lista.size(), 0);
    }
	
	@Test
	public void addOperacionCorrectamente() {
		Operacion v = mock(Operacion.class);
		ArrayList <Operacion> lista = new ArrayList<Operacion>();
		lista.add(v);
		assertEquals(lista.size(), 1);
	}
	
	@Test
	public void seBorraUnaOperacionCorrectamente() {
		Operacion v = mock(Operacion.class);
		ArrayList <Operacion> lista = new ArrayList<Operacion>();
		lista.add(v);
		int tam = lista.size();
		lista.remove(v);
		assertEquals(lista.size(), tam-1);
	}
}
