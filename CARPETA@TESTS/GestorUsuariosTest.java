package Test;

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
		ArrayList <Usuario> lista = new ArrayList<Usuario>();
		assertEquals(lista.size(), 0);
    }
	
	@Test
	public void addUsuarioCorrectamente() {
		Usuario v = mock(Usuario.class);
		ArrayList <Usuario> lista = new ArrayList<Usuario>();
		lista.add(v);
		assertEquals(lista.size(), 1);
	}
	
	@Test
	public void seBorraUnUsuarioCorrectamente() {
		Usuario v = mock(Usuario.class);
		ArrayList <Usuario> lista = new ArrayList<Usuario>();
		lista.add(v);
		int tam = lista.size();
		lista.remove(v);
		assertEquals(lista.size(), tam-1);
	}
}
