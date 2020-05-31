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
import javax.swing.JPanel;
import java.awt.Color;

@SuppressWarnings("serial")
public class VistaMiPerfil extends JFrame {
		private java.awt.Button BtnBack;
	    private java.awt.Button BtnSave;
	    private javax.swing.JLabel title;
	    private javax.swing.JLabel logo;
	    private JLabel logo_1;
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
	    
	    GestorUsuarios gu;
	    private JPanel panel_1;
   
    public VistaMiPerfil(int id, String rol) {
    	getContentPane().setBackground(new Color(224, 255, 255));
      	idVendedor = id;
      	tipoRol = rol;
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

 private void initComponents() {

    	Font negrita = new Font("Arial", Font.BOLD, 30);
    	
    	ruta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel1.setBackground(new Color(224, 255, 255));
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

        texto_correo.setText("Correo:");

        texto_password.setText("Contrase�a:");

        texto_dni.setText("DNI:");

        texto_nombre.setText("Nombre:");

        texto_apellidos.setText("Apellidos:");

        texto_fecNac.setText("Fecha de nacimiento:");

        texto_movil.setText("M�vil:");

        texto_direccion.setText("Direcci�n:");

        texto_codPostal.setText("C�digo postal:");

        texto_ciudad.setText("Ciudad:");

        texto_provincia.setText("Provincia:");
        
        logo = new javax.swing.JLabel();

        BtnBack.setLabel("Atr�s");
        BtnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		BtnBackActionPerformed(evt);
        	}
        });
        
        BtnSave.setLabel("Guardar cambios");
        BtnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		BtnSaveActionPerformed(evt);
        	}
        });
        
        BtnFoto = new JButton("Cambiar imagen");
        BtnFoto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent evt) {
        		BtnFotoActionPerformed(evt);        
        	}
        });

        title.setText("Datos personales");
        title.setFont(negrita);
        
        rellenarDatos(idVendedor);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
        gl_jPanel2.setHorizontalGroup(
        	gl_jPanel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(32)
        			.addComponent(texto_correo)
        			.addGap(10)
        			.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        			.addGap(48)
        			.addComponent(texto_password)
        			.addGap(10)
        			.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        			.addGap(115)
        			.addComponent(texto_dni)
        			.addGap(31)
        			.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(32)
        			.addComponent(texto_nombre)
        			.addGap(10)
        			.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        			.addGap(58)
        			.addComponent(texto_apellidos)
        			.addGap(10)
        			.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        			.addGap(48)
        			.addComponent(texto_fecNac)
        			.addGap(18)
        			.addComponent(txtFecNac, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(45)
        			.addComponent(texto_movil)
        			.addGap(10)
        			.addComponent(txtMovil, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        			.addGap(57)
        			.addComponent(texto_direccion)
        			.addGap(10)
        			.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        			.addGap(81)
        			.addComponent(texto_codPostal)
        			.addGap(18)
        			.addComponent(txtCodPostal, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(36)
        			.addComponent(texto_ciudad)
        			.addGap(10)
        			.addComponent(txtCiudad, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        			.addGap(57)
        			.addComponent(texto_provincia)
        			.addGap(10)
        			.addComponent(txtProvincia, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(255)
        			.addComponent(BtnBack, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        			.addGap(88)
        			.addComponent(BtnFoto)
        			.addGap(75)
        			.addComponent(BtnSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        gl_jPanel2.setVerticalGroup(
        	gl_jPanel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(19)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_correo))
        				.addComponent(txtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_password))
        				.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_dni))
        				.addComponent(txtDni, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(73)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_nombre))
        				.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_apellidos))
        				.addComponent(txtApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_fecNac))
        				.addComponent(txtFecNac, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(74)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_movil))
        				.addComponent(txtMovil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_direccion))
        				.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_codPostal))
        				.addComponent(txtCodPostal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(68)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_ciudad))
        				.addComponent(txtCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(3)
        					.addComponent(texto_provincia))
        				.addComponent(txtProvincia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(74)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addComponent(BtnBack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(BtnFoto)
        				.addComponent(BtnSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2.setLayout(gl_jPanel2);
        
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(224, 255, 255));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1776, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(751)
        					.addComponent(title))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(372)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 1012, GroupLayout.PREFERRED_SIZE)))
        			.addGap(6)
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 993, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
        					.addGap(182)
        					.addComponent(title)
        					.addGap(18)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 982, Short.MAX_VALUE))
        			.addContainerGap())
        );
        getContentPane().setLayout(groupLayout);

        pack();
    }

   
    private void BtnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
    	String n;
    	switch(tipoRol) {
		case "Empleado": 
			VistaPanelEmpleado e = new VistaPanelEmpleado(idVendedor,tipoRol); 
			n = VistaIniciarSesion.ponerNombre(idVendedor);
			e.bienvenido.setText("Bienvenido, " + n);
			e.setVisible(true);
			dispose();
			break;
		case "Mec�nico": 
			VistaPanelMecanico m = new VistaPanelMecanico(idVendedor,tipoRol);
			n = VistaIniciarSesion.ponerNombre(idVendedor);
			m.bienvenido.setText("Bienvenido, " + n);
			m.setVisible(true);
			dispose();
			break;
		}
    }

    private void rellenarDatos(int id) {
    	Conectar conec = new Conectar();
        String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
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
                logo_1 = new JLabel(imgi);
                logo_1.setSize(600, 400);
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
    
    private void BtnSaveActionPerformed(ActionEvent evt) {
        Date date = txtFecNac.getDate();
    	String fecNac = DateFormat.getDateInstance().format(date);
    	File route = new File(ruta.getText());
    	modificar(txtCorreo.getText(), txtPassword.getText(), txtDni.getText(), txtNombre.getText(), txtApellidos.getText(), fecNac, Integer.parseInt(txtMovil.getText()), txtDireccion.getText(), Integer.parseInt(txtCodPostal.getText()), txtCiudad.getText(), txtProvincia.getText(), tipoRol, route);
    }
    
    public void modificar(String correo, String password, String dni, String nombre, String apellidos, String fecNac, int movil, String direccion, int codPostal, String ciudad, String provincia,String tipoRol, File ruta){
    	Usuario u = new Usuario();
        gu = new GestorUsuarios();
        
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
