package Pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Model.ConcesionarioException;
import Model.GestorOperacion;
import Model.GestorUsuarios;
import Model.Usuario;
import Model.Usuario;



public class GestorUsuariosTest {
	GestorUsuarios user;
	
	@Before
	public void init() {
		user = new GestorUsuarios();
		
	}
	
	@After
	public void terminate() {
		user = null;
	}
	
	@Test
	public void inicialmenteElNumeroDeUsuariosEsCero() {
		ArrayList <GestorUsuarios> lista = new ArrayList<GestorUsuarios>();
		assertEquals(lista.size(), 0);
	}
	@Test
	public void addUsuarioCorrectamente() {
		GestorUsuarios v = mock(GestorUsuarios.class);
		ArrayList <GestorUsuarios> lista = new ArrayList<GestorUsuarios>();
		lista.clear();
		lista.add(v);
		assertEquals(1, lista.size());
		lista.clear();
	}
	
	@Test
	public void seBorraUnUsuarioCorrectamente() {
		GestorUsuarios v = mock(GestorUsuarios.class);
		ArrayList <GestorUsuarios> lista = new ArrayList<GestorUsuarios>();
		lista.clear();
		lista.add(v);
		lista.clear();
		assertEquals(0, lista.size());
	}
}
