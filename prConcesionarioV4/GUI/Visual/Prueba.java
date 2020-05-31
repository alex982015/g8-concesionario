package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Conexion.Conectar;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class Prueba extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private JLabel msg;
	
	public Prueba() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		getContentPane().add(panelSuperior, BorderLayout.NORTH);
		panelSuperior.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("CEIGT");
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.PLAIN, 40));
		panelSuperior.add(lblNewLabel);
		
		JPanel panelInferior = new JPanel();
		getContentPane().add(panelInferior, BorderLayout.SOUTH);
		
		JPanel panelCentral = new JPanel();
		getContentPane().add(panelCentral, BorderLayout.CENTER);
		
		JLabel textoUsuario = new JLabel("Usuario");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel textoPassword = new JLabel("Contrase\u00F1a");
		
		txtPassword = new JPasswordField();
		
		JButton btnNewButton = new JButton("Acceder");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnLoginActionListener(evt);
			}
		});
		
		JLabel msg = new JLabel("");
		GroupLayout gl_panelCentral = new GroupLayout(panelCentral);
		gl_panelCentral.setHorizontalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addGap(192)
							.addGroup(gl_panelCentral.createParallelGroup(Alignment.LEADING)
								.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
								.addComponent(textoPassword)
								.addComponent(textoUsuario, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPassword, 201, 201, Short.MAX_VALUE)
								.addComponent(msg, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelCentral.createSequentialGroup()
							.addGap(255)
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
							.addGap(63)))
					.addGap(192))
		);
		gl_panelCentral.setVerticalGroup(
			gl_panelCentral.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelCentral.createSequentialGroup()
					.addGap(75)
					.addComponent(textoUsuario)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textoPassword)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(msg)
					.addContainerGap(72, Short.MAX_VALUE))
		);
		panelCentral.setLayout(gl_panelCentral);
		
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
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba frame = new Prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
