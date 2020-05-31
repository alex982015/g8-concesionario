
package Visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Conexion.Conectar;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class VistaIniciarSesion extends JFrame {
	private javax.swing.JLabel title;	
	private javax.swing.JLabel texto_Usuario;
	private javax.swing.JLabel texto_Password;
	private javax.swing.JLabel msg;
	public javax.swing.JTextField txtUsuario;
	public javax.swing.JPasswordField txtPassword;
	private javax.swing.JLabel logo;
	private javax.swing.JPanel panel0;
	private javax.swing.JPanel panel1;
	private javax.swing.JPanel panel2;
	private javax.swing.JButton BtnLogin;
	
	public VistaIniciarSesion() {
		getContentPane().setBackground(new Color(224, 255, 255));
		initComponents();
		setExtendedState(MAXIMIZED_BOTH);
		System.out.println(this.getWidth());
	}
	
	private void initComponents() {
		Font negrita = new Font("Arial", Font.BOLD, 30);
		Font estandar = new Font("Arial", Font.PLAIN, 20);
		Font italic = new Font("Arial", Font.ITALIC, 20);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		
        ImageIcon imagen=new ImageIcon("imagenes"+File.separator+"logo.png");
		
		texto_Usuario = new javax.swing.JLabel();
		texto_Usuario.setForeground(Color.WHITE);
		texto_Usuario.setFont(new Font("Arial", Font.BOLD, 25));
		texto_Password = new javax.swing.JLabel();
		texto_Password.setForeground(Color.WHITE);
		texto_Password.setFont(new Font("Arial", Font.BOLD, 25));
		msg = new javax.swing.JLabel();
		msg.setFont(italic);
		msg.setBackground(Color.red);
		msg.setOpaque(true);
		
		txtUsuario = new javax.swing.JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtPassword = new javax.swing.JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		BtnLogin = new javax.swing.JButton();
		BtnLogin.setText("Acceder");
		BtnLogin.setFont(new Font("Arial", Font.BOLD, 25));
		BtnLogin.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnLoginActionListener(evt);
			}
		});
				
		panel0 = new javax.swing.JPanel();
		panel0.setBackground(new Color(224, 255, 255));
		panel2 = new javax.swing.JPanel();
		panel2.setBackground(Color.DARK_GRAY);
		
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar sesion");
        
        texto_Usuario.setText("Usuario:");
        texto_Password.setText("Contrase\u00F1a:");
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(224, 255, 255));
        
        title = new javax.swing.JLabel();
        title.setText("Concesionario Grupo 8");
        title.setFont(new Font("Arial", Font.BOLD, 50));
        logo = new javax.swing.JLabel(imagen);
        panel1 = new javax.swing.JPanel();
        panel1.setBackground(new Color(224, 255, 255));
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(logo)
        			.addGap(676))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(logo)
        			.addContainerGap(90, Short.MAX_VALUE))
        );
        
        
        int panel1X = (getWidth()-panel1.getWidth() - getInsets().left - getInsets().right) /2;
        int panel1Y = (getHeight() - panel1.getHeight() - getInsets().top -getInsets().bottom) / 2;
        panel1.setLocation(panel1X, panel1Y);
        panel1.setLayout(jPanel1Layout);
        
        System.out.println(d.width/4);
        
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        		groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panel0, 1, 1, 1))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addComponent(panel, GroupLayout.PREFERRED_SIZE, d.width/4, 1000)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 653, GroupLayout.PREFERRED_SIZE)
        					.addGap(480)
        					)))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap((d.width/2)-60)
        			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(800, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(407)
        			.addComponent(title)
        			.addContainerGap(800, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(panel0, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(title)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addGap(6)
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap())
        );
        
        JLabel lblNewLabel = new JLabel("INICIO DE SESION");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("D:\\Im\u00E1genes\\prConcesionarioV4\\imagenes\\logo.png"));
        
        JLabel msg_1 = new JLabel();
        msg_1.setOpaque(true);
        msg_1.setFont(new Font("Arial", Font.ITALIC, 20));
        msg_1.setBackground(Color.RED);
        GroupLayout gl_panel2 = new GroupLayout(panel2);
        gl_panel2.setHorizontalGroup(
        	gl_panel2.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addContainerGap(377, Short.MAX_VALUE)
        			.addComponent(lblNewLabel_1)
        			.addGap(274))
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addContainerGap(166, Short.MAX_VALUE)
        			.addComponent(lblNewLabel)
        			.addGap(151))
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addGap(119)
        			.addComponent(msg_1)
        			.addContainerGap(532, Short.MAX_VALUE))
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addGap(84)
        			.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
        				.addComponent(texto_Password)
        				.addComponent(texto_Usuario)
        				.addComponent(txtUsuario))
        			.addGap(75))
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addContainerGap(270, Short.MAX_VALUE)
        			.addComponent(BtnLogin)
        			.addGap(250))
        );
        gl_panel2.setVerticalGroup(
        	gl_panel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel2.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel_1)
        			.addGap(18)
        			.addComponent(lblNewLabel)
        			.addGap(36)
        			.addComponent(texto_Usuario)
        			.addGap(18)
        			.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(texto_Password)
        			.addGap(18)
        			.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addComponent(BtnLogin, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        			.addGap(82)
        			.addComponent(msg_1)
        			.addGap(27))
        );
        panel2.setLayout(gl_panel2);
        GroupLayout gl_panel0 = new GroupLayout(panel0);
        gl_panel0.setHorizontalGroup(
        	gl_panel0.createParallelGroup(Alignment.LEADING)
        		.addGap(0, 1903, Short.MAX_VALUE)
        );
        gl_panel0.setVerticalGroup(
        	gl_panel0.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 135, Short.MAX_VALUE)
        );
        panel0.setLayout(gl_panel0);
        getContentPane().setLayout(groupLayout);

            pack();
            setLocationRelativeTo(null);
	}
	
	@SuppressWarnings("deprecation")
	private void BtnLoginActionListener(java.awt.event.ActionEvent evt) {
		if(ok(txtUsuario.getText(),txtPassword.getText())) {
			String rol = rol(txtUsuario.getText(),txtPassword.getText());
			String n;
			switch(rol) {
			case "Empleado": 
				VistaPanelEmpleado e = new VistaPanelEmpleado(pasarId(txtUsuario.getText(),txtPassword.getText()),rol); 
				n = ponerNombre(pasarId(txtUsuario.getText(),txtPassword.getText()));
				e.bienvenido.setText("Bienvenido, " + n);
				e.setVisible(true);
				dispose();
				break;
			case "Mecánico": 
				VistaPanelMecanico m = new VistaPanelMecanico(pasarId(txtUsuario.getText(),txtPassword.getText()),rol);
				n = ponerNombre(pasarId(txtUsuario.getText(),txtPassword.getText()));
				m.bienvenido.setText("Bienvenido, " + n);
				m.setVisible(true);
				dispose();
				break;
			}
		} else {
			msg.setText("ERROR: usuario o contraseña incorrrectos");
		}
	}
	
	public static String ponerNombre(int id) {
		String n = null;
		Conectar conec = new Conectar();
        String sql = "SELECT nombre FROM usuario WHERE idUsuario = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            rs.next();
            n = rs.getString(1);
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
        return n;
	}
	
	public int pasarId(String user, String pass) {
		int id = 0; 
		Conectar conec = new Conectar();
	        String sql = "SELECT idUsuario FROM usuario WHERE correo = ? AND password = ?";
	        ResultSet rs = null;
	        PreparedStatement ps = null;
	        try{
	            ps = conec.getConnection().prepareStatement(sql);
	            ps.setString(1, user);
	            ps.setString(2, pass);
	            rs = ps.executeQuery();
	            rs.next();
	            id = rs.getInt(1);
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
			return id;
	}
	
	private boolean ok(String user, String pass) {
		boolean ok = false;
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM usuario WHERE correo = ? AND password = ?";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
            	ok = true;
            } else {
            	ok = false;
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
		return ok;
	}
	
	private String rol(String user, String password) {
		String rol = null;
		 Conectar conec = new Conectar();
	        String sql = "SELECT tipoRol FROM usuario WHERE correo = ? AND password = ?";
	        ResultSet rs = null;
	        PreparedStatement ps = null;
	        try{
	        	ps = conec.getConnection().prepareStatement(sql);
	            ps.setString(1, user);
	            ps.setString(2, password);
	        	rs = ps.executeQuery();
	            rs.next();
	            rol = rs.getString(1);
	        }catch(SQLException ex1){
	            System.out.println(ex1.getMessage());
	        }catch(Exception ex){
	            System.out.println(ex.getMessage());
	        }finally{
	            try{
	                ps.close();
	                rs.close();
	                conec.desconectar();
	            }catch(Exception ex){}
	        }   
			return rol;
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
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaIniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	VistaIniciarSesion v = new VistaIniciarSesion();
            	v.setVisible(true);

            }
        });
    }
}

