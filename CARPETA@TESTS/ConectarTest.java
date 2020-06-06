package Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Conexion.Conectar;
import Model.ConcesionarioException;
import Model.GestorVehiculos;
import Model.Vehiculo;
import Visual.VistaIniciarSesion;

public class ConectarTest {
	Conectar conec;
	
	@Before
	public void init() {
		conec = new Conectar();
		
	}
	
	@After
	public void terminate() {
		conec = null;
	}
	
	@Test
	public void noConexionBD() {
		assertNull(conec.getConnection());
	}
	
	@Test
	public void ConexionBD() {
		assertNotNull(conec.getConnection());
	}
}
