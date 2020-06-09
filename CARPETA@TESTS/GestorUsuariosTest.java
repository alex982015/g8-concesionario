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
import Model.GestorUsuarios;
import Model.Usuario;
import Model.Usuario;
import Model.Usuario;



public class GestorUsuariosTest {
	GestorUsuarios user;
	
	@Before
	public void init() {
		user = new GestorUsuarios();
		user.vaciar();
	}
	
	@After
	public void terminate() {
		user.vaciar();
		user = null;
	}
	
	@Test
	public void inicialmenteElNumeroDeUsuariosEsCero() {
		ArrayList <Usuario> lista = new ArrayList<Usuario>();
		lista  = user.verUsuarios("default");
		assertEquals(lista.size(), 0);
    }
	
	@Test
	public void addUsuarioCorrectamente() {
		Usuario v = mock(Usuario.class);
		when(v.getTipoRol()).thenReturn(("Cliente"));
		ArrayList <Usuario> lista = new ArrayList<Usuario>();
		user.addUsuario(v);
		lista = user.verUsuarios("default");
		assertEquals(lista.size(), 1);
	}
	
	@Test
	public void seBorraUnUsuarioCorrectamente() {
		Usuario v = mock(Usuario.class);
		when(v.getIdUsuario()).thenReturn((int)1);
		//Como el id se autoincrementa, la prueba funciona solo la primera vez.Habría que borrar las tablas de base de datos y volver a crearlas.
		ArrayList <Usuario> lista = new ArrayList<Usuario>();
		user.addUsuario(v);
		user.delUsuario(v);
		lista = user.verUsuarios("default");
		assertEquals(lista.size(), 0);
	}
	
	/*Metodo Vaciar. Solo se usa para los test.

    public void vaciar(){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM operacion";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
    */
}
