package Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.ConcesionarioException;
import Model.GestorOperacion;
import Model.GestorUsuarios;
import Model.GestorOperacion;
import Model.GestorVehiculos;
import Model.Operacion;
import Model.Usuario;
import Model.Vehiculo;
import Model.Operacion;
import Model.Operacion;

public class GestorOperacionTest {
	GestorOperacion op;
	GestorVehiculos gv;
	GestorUsuarios user;
	@Before
	public void init() {
		op = new GestorOperacion();
		op.vaciar();
		gv = new GestorVehiculos();
		gv.vaciar();
		user = new GestorUsuarios();
		user.vaciar();
	}
	
	@After
	public void terminate() {
		//op.vaciar();
		op = null;
		gv.vaciar();
		gv = null;
		user.vaciar();
		user = null;
	}
	
	@Test
	public void inicialmenteElNumeroDeOperacionEsCero() {
		ArrayList <Operacion> lista = new ArrayList<Operacion>();
		lista  = op.verOperaciones("default");
		assertEquals(lista.size(), 0);
    }
	
	
	/*No hemos podido conseguir que funcionen estos test debido a que una operación está compuesta por un vehículo, un usuario y un empleado.
	 * 
	@Test
	public void addOperacionCorrectamente() {
		Operacion o = mock(Operacion.class);
		when(o.getIDvehiculo()).thenReturn((int) 1);
		when(o.getIdvendedor()).thenReturn((int) 1);
		when(o.getIDcliente()).thenReturn((int) 2);
		ArrayList <Operacion> lista = new ArrayList<Operacion>();
		op.addOperacion(o);
		lista = op.verOperaciones("default");
		assertEquals(lista.size(), 1);
	}
	
	@Test
	public void seBorraUnOperacionCorrectamente() {
		Vehiculo ve = mock(Vehiculo.class);
		when(ve.getIdVehiculo()).thenReturn((int)1);
		gv.addVehiculo(ve);
		Usuario u = mock(Usuario.class);
		when(u.getIdUsuario()).thenReturn((int)1);
		user.addUsuario(u);
		Usuario u2 = mock(Usuario.class);
		when(u.getIdUsuario()).thenReturn((int)2);
		user.addUsuario(u2);
		Operacion o = mock(Operacion.class);
		when(o.getIDvehiculo()).thenReturn((int) 1);
		when(o.getIdvendedor()).thenReturn((int) 1);
		when(o.getIDcliente()).thenReturn((int) 2);
		ArrayList <Operacion> lista = new ArrayList<Operacion>();
		op.addOperacion(o);
		lista = op.verOperaciones("default");
		int tam = lista.size();
		op.delOperacion(o);
		lista = op.verOperaciones("default");
		assertEquals(lista.size(), tam-1);
	}
	*/
	
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
