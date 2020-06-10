package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Conexion.Conectar;
import Model.ConcesionarioException;
import Model.GestorVehiculos;
import Model.Vehiculo;

public class GestorVehiculosTest {
	GestorVehiculos gv;
	
	@Before
	public void init() {
		gv = new GestorVehiculos();
		gv.vaciar();
	}
	
	@After
	public void terminate() {
		gv.vaciar();
		gv = null;
	}
	
	@Test
	public void inicialmenteElNumeroDeVehiculosEsCero() {
		ArrayList <Vehiculo> lista = new ArrayList<Vehiculo>();
		lista  = gv.verVehiculos("default", "all", "Empleado");
		assertEquals(lista.size(), 0);
    }
	
	@Test
	public void addVehiculoCorrectamente() {
		Vehiculo v = mock(Vehiculo.class);
		when(v.getDisponibilidad()).thenReturn((int)1);
		ArrayList <Vehiculo> lista = new ArrayList<Vehiculo>();
		gv.addVehiculo(v);
		lista = gv.verVehiculos("default", "all", "Empleado");
		assertEquals(lista.size(), 1);
	}
	
	@Test
	public void seBorraUnVehiculoCorrectamente() {
		Vehiculo v = mock(Vehiculo.class);
		when(v.getDisponibilidad()).thenReturn((int)1);
		when(v.getIdVehiculo()).thenReturn((int)1);
		//Como el id se autoincrementa, la prueba funciona solo la primera vez.Habría que borrar las tablas de base de datos y volver a crearlas.
		ArrayList <Vehiculo> lista = new ArrayList<Vehiculo>();
		gv.addVehiculo(v);
		gv.delVehiculo(v);
		lista = gv.verVehiculos("default", "all", "Empleado");
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
