package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import Conexion.Conectar;
import Model.GestorUsuarios;
import Model.Usuario;

import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

@SuppressWarnings("serial")
public class VistaMiPerfil extends JFrame {
	//variables
		private java.awt.Button BtnBack;
	    private java.awt.Button BtnSave;
	    private javax.swing.JLabel title;
	    private javax.swing.JLabel logo;
	    private javax.swing.JLabel texto_correo;
	    private javax.swing.JLabel texto_password;
	    private javax.swing.JLabel texto_dni;
	    private javax.swing.JLabel texto_nombre;
	    private javax.swing.JLabel texto_apellidos;
	    private javax.swing.JLabel texto_fecNac;
	    private javax.swing.JLabel texto_movil;
	    private javax.swing.JLabel texto_direccion;
	    private javax.swing.JLabel texto_codPostal;
	    private javax.swing.JLabel texto_ciudad;
	    private javax.swing.JLabel texto_provincia;
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    private com.toedter.calendar.JDateChooser txtFecNac;
	    private javax.swing.JTextField txtCorreo;
	    private javax.swing.JTextField txtPassword;
	    private javax.swing.JTextField txtDni;
	    private javax.swing.JTextField txtNombre;
	    private javax.swing.JTextField txtApellidos;
	    private javax.swing.JTextField txtMovil;
	    private javax.swing.JTextField txtDireccion;
	    private javax.swing.JTextField txtCodPostal;
	    private javax.swing.JTextField txtCiudad;
	    private javax.swing.JTextField txtProvincia;
	    private javax.swing.JLabel result;
	    
	    private JLabel ruta;
	    
	    public int idVendedor;
	    public String tipoRol;
	    private JButton BtnFoto;
	    //objeto tipo gestorusuarios
	    GestorUsuarios gu;
   
    public VistaMiPerfil(int id, String rol) {
      	idVendedor = id;
      	tipoRol = rol;
	    //inicia componentes
        initComponents();
	    //escala la ventana al tamaño maximo de la pantalla
        setExtendedState(MAXIMIZED_BOTH);
    }

 private void initComponents() {
	//tipografía
    	Font negrita = new Font("Arial", Font.BOLD, 30);
    	//datos de los paneles
    	ruta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        texto_correo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        texto_password = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        texto_dni = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        texto_nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        texto_apellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        texto_fecNac = new javax.swing.JLabel();
        txtFecNac = new com.toedter.calendar.JDateChooser();
        texto_movil = new javax.swing.JLabel();
        txtMovil = new javax.swing.JTextField();
        texto_direccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        texto_codPostal = new javax.swing.JLabel();
        txtCodPostal = new javax.swing.JTextField();
        texto_ciudad = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        texto_provincia = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        BtnBack = new java.awt.Button();
        BtnSave = new java.awt.Button();
        title = new javax.swing.JLabel();
        result = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 107, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
	//datos del usuario
        texto_correo.setText("Correo:");

        texto_password.setText("Contraseña:");

        texto_dni.setText("DNI:");

        texto_nombre.setText("Nombre:");

        texto_apellidos.setText("Apellidos:");

        texto_fecNac.setText("Fecha de nacimiento:");

        texto_movil.setText("Móvil:");

        texto_direccion.setText("Dirección:");

        texto_codPostal.setText("Código postal:");

        texto_ciudad.setText("Ciudad:");

        texto_provincia.setText("Provincia:");
        
        logo = new javax.swing.JLabel();
	//botón para volver al panel principal
        BtnBack.setLabel("Atrás");
        BtnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		BtnBackActionPerformed(evt);
        	}
        });
        //botón para guardar modificaciones
        BtnSave.setLabel("Guardar cambios");
        BtnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		BtnSaveActionPerformed(evt);
        	}
        });
        //botón para modificar la foto
        BtnFoto = new JButton("Cambiar imagen");
        BtnFoto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		BtnFotoActionPerformed(evt);        
        	}
        });
	//paneles donde se encuentran los datos 
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(texto_movil)
        						.addComponent(texto_nombre)
        						.addComponent(texto_ciudad))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtMovil, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtCiudad, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        							.addComponent(texto_direccion)
        							.addComponent(texto_provincia))
        						.addComponent(texto_apellidos)))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(texto_correo)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(texto_password)))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(texto_codPostal, Alignment.TRAILING)
        								.addComponent(texto_fecNac, Alignment.TRAILING))
        							.addGap(18))
        						.addGroup(jPanel2Layout.createSequentialGroup()
        							.addComponent(texto_dni)
        							.addGap(31)))
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(txtFecNac, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        						.addComponent(txtDni, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        						.addComponent(txtCodPostal, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
        				.addComponent(txtProvincia, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(255)
        			.addComponent(BtnBack, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        			.addGap(88)
        			.addComponent(BtnFoto)
        			.addGap(75)
        			.addComponent(BtnSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
        			.addComponent(result)
        			.addGap(38))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(19)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(texto_correo)
        				.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(texto_password)
        				.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(texto_dni))
        			.addGap(73)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(texto_nombre)
        				.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(texto_apellidos)
        				.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtFecNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(texto_fecNac))
        			.addGap(74)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(texto_movil)
        				.addComponent(txtMovil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(texto_direccion)
        				.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(texto_codPostal)
        				.addComponent(txtCodPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(68)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(texto_ciudad)
        				.addComponent(txtCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(texto_provincia)
        				.addComponent(txtProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(74)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(BtnBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(BtnSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addComponent(result)
        					.addComponent(BtnFoto)))
        		.addContainerGap(10, Short.MAX_VALUE)
        ));
        jPanel2.setLayout(jPanel2Layout);
	//titulo mostrando que son los datos personales
        title.setText("Datos personales:");
        title.setFont(negrita);
        //rellenamos los datos a través del id 
        rellenarDatos(idVendedor);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(87)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(43)
        							.addComponent(logo))
        						.addComponent(title)))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(32)
        					.addComponent(title)
        					.addGap(18)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(226)
        					.addComponent(logo)))
        			.addContainerGap(328, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

   //acción del botón volver
    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	String n;
	    //Depende de si es empleado o mecánico volverá a una vista distinta
    	switch(tipoRol) {
		case "Empleado": 
			VistaPanelEmpleado e = new VistaPanelEmpleado(idVendedor,tipoRol); 
			n = VistaIniciarSesion.ponerNombre(idVendedor);
			e.bienvenido.setText("Bienvenido, " + n);
			e.setVisible(true);
			dispose();
			break;
		case "Mecánico": 
			VistaPanelMecanico m = new VistaPanelMecanico(idVendedor,tipoRol);
			n = VistaIniciarSesion.ponerNombre(idVendedor);
			m.bienvenido.setText("Bienvenido, " + n);
			m.setVisible(true);
			dispose();
			break;
		}
    }
	//rellenar datos, a través de un id 
    private void rellenarDatos(int id) {
	    //conectamos a la base de datos
    	Conectar conec = new Conectar();
	    //variable para el id
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
		//una vez conectado, a través de la id, nos devolverá todos los datos
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            txtCorreo.setText(rs.getString(2));
            txtPassword.setText(rs.getString(3));
            txtDni.setText(rs.getString(4));
            txtNombre.setText(rs.getString(5));
            txtApellidos.setText(rs.getString(6));
            txtMovil.setText(String.valueOf(rs.getInt(8)));
            txtDireccion.setText(rs.getString(9));
            txtCodPostal.setText(String.valueOf(rs.getString(10)));
            txtCiudad.setText(rs.getString(11));
            txtProvincia.setText(rs.getString(12));
            tipoRol = rs.getString(13);
            
            try{
                byte[] bi = rs.getBytes(14);
                BufferedImage image = null;
                InputStream in = new ByteArrayInputStream(bi);
                image = ImageIO.read(in);
                ImageIcon imgi = new ImageIcon(image.getScaledInstance(150, 150, 0));
                logo = new JLabel(imgi);
                logo.setSize(600, 400);
            }catch(Exception ex){
                logo = new JLabel("No imagen");
                logo.setSize(600, 400);
            }
        }catch(SQLException ex1){
            System.out.println(ex1.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }
            catch(Exception ex){}
        }  
    }
    //botón para añadir la foto
    private void BtnFotoActionPerformed(ActionEvent evt) {
    	JFileChooser j = new JFileChooser();
        FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        j.setFileFilter(fil);
        
        int s = j.showOpenDialog(this);
        if(s == JFileChooser.APPROVE_OPTION){
            String route = j.getSelectedFile().getAbsolutePath();
            ruta.setText(route);
        }
    }
    //botón para guardar
    private void BtnSaveActionPerformed(ActionEvent evt) {
        Date date = txtFecNac.getDate();
    	String fecNac = DateFormat.getDateInstance().format(date);
    	File route = new File(ruta.getText());
    	modificar(txtCorreo.getText(), txtPassword.getText(), txtDni.getText(), txtNombre.getText(), txtApellidos.getText(), fecNac, Integer.parseInt(txtMovil.getText()), txtDireccion.getText(), Integer.parseInt(txtCodPostal.getText()), txtCiudad.getText(), txtProvincia.getText(), tipoRol, route);
    }
    //modificar los datos 
    public void modificar(String correo, String password, String dni, String nombre, String apellidos, String fecNac, int movil, String direccion, int codPostal, String ciudad, String provincia,String tipoRol, File ruta){
    	Usuario u = new Usuario();
        gu = new GestorUsuarios();
        //se modifican y se guardan en las variables que se introducen
        u.setIdUsuario(idVendedor);
        u.setCorreo(correo);
        u.setPassword(password);
        u.setDni(dni);
        u.setNombre(nombre);
        u.setApellidos(apellidos);
        u.setFecNacimiento(fecNac);
        u.setMovil(movil);
        u.setDireccion(direccion);
        u.setCodPostal(codPostal);
        u.setCiudad(ciudad);
        u.setProvincia(provincia);
        u.setTipoRol(tipoRol);
        
        try{
            byte[] icono = new byte[(int) ruta.length()];
            InputStream input = new FileInputStream(ruta);
            input.read(icono);
            u.setFoto(icono);
            input.close();
        }catch(Exception ex){
            u.setFoto(null);
        }
        gu.editUsuario(u);
        result.setText("Cambios guardados correctamente");
        VistaMiPerfil v = new VistaMiPerfil(idVendedor,tipoRol);
        v.setVisible(true);
        dispose();
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaMiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMiPerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMiPerfil(0,null).setVisible(true);
            }
        });
    }
}
