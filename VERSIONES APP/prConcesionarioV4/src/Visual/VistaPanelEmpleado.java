package Visual;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;

@SuppressWarnings("serial")
public class VistaPanelEmpleado extends JFrame {
	//variables
	public javax.swing.JLabel bienvenido;
	private javax.swing.JLabel title;
	private javax.swing.JButton ultimasGestiones;
	private javax.swing.JButton venta;
	private javax.swing.JButton alquiler;
	private javax.swing.JButton gestorVehiculos;
	private javax.swing.JButton gestorUsuarios;
	private javax.swing.JButton miPerfil;
	private javax.swing.JButton BtnExit;

	private javax.swing.JPanel panel0;
	private javax.swing.JPanel panel1;
	private javax.swing.JPanel panel2;
	
	public static int idVendedor;
	public static String rol;
	
	public VistaPanelEmpleado(int value, String r) {
		idVendedor = value;
		rol = r;
		//inicia componente
		initComponents();
		//escala la ventana al tamaño de la pantalla
		setExtendedState(MAXIMIZED_BOTH);
	}
	
	public void initComponents() {
		//tipografia
		Font negrita = new Font("Arial", Font.BOLD, 30);
		Font estandar = new Font("Arial", Font.PLAIN, 22);
		Font italic = new Font("Arial", Font.ITALIC, 30);
		
		bienvenido = new javax.swing.JLabel();
		bienvenido.setFont(italic);
		
		title = new javax.swing.JLabel();
		title.setFont(estandar);
		title.setText("PANEL DE CONTROL:");
		title.setFont(negrita);
		///botones
		ultimasGestiones = new javax.swing.JButton();
		venta = new javax.swing.JButton();
		alquiler = new javax.swing.JButton();
		gestorVehiculos = new javax.swing.JButton();
		gestorUsuarios = new javax.swing.JButton();
		miPerfil = new javax.swing.JButton();
		BtnExit = new javax.swing.JButton();
		
		BtnExit.setFont(estandar);
		ultimasGestiones.setFont(estandar);
		venta.setFont(estandar);
		alquiler.setFont(estandar);
		gestorVehiculos.setFont(estandar);
		gestorUsuarios.setFont(estandar);
		miPerfil.setFont(estandar);
		//boton cerrar sesion
		BtnExit.setText("Cerrar sesión");
		BtnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnExitActionPerformed(evt);
			}
		});
		//boton ultimas gestiones, donde veremos los ultimos contratos realizados
		ultimasGestiones.setText("Últimas gestiones");
		ultimasGestiones.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
					ultimasGestionesActionPerformed(evt);				
			}
		});
		//nueva venta, donde se producira una nueva gestion
		venta.setText("Nueva venta");
		venta.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ventaActionPerformed(evt);
			}
		});	
		//nuevo alquiler, donde se producirá una nueva gestión
		alquiler.setText("Nuevo alquiler");
		alquiler.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				alquilerActionPerformed(evt);
			}
		});
		//gestor vehículo, acceso a la gestión del catálogo de vehículos
		gestorVehiculos.setText("Gestor de Vehículos");
		gestorVehiculos.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gestorVehiculosActionPerformed(evt);
			}
		});
		//gestor usuarios, acceso a la gestión de todos los usuarios
		gestorUsuarios.setText("Gestor de clientes");
		gestorUsuarios.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				gestorUsuariosActionPerformed(evt);
			}
		});
		//mi perfil, nos mostrará los datos del empleado que haya iniciado sesión
		miPerfil.setText("Mi perfil");
		miPerfil.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				miPerfilActionPerformed(evt);
			}
		});
		
		panel0 = new javax.swing.JPanel();
		panel1 = new javax.swing.JPanel();
		panel2 = new javax.swing.JPanel();
		panel2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel de Control");
		
        //panel para mi perfil
        javax.swing.GroupLayout jPanel0Layout = new javax.swing.GroupLayout(panel0);
        jPanel0Layout.setHorizontalGroup(
        	jPanel0Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel0Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(bienvenido)
        			.addPreferredGap(ComponentPlacement.RELATED, 1327, Short.MAX_VALUE)
        			.addGroup(jPanel0Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(miPerfil)
        				.addComponent(BtnExit)))
        );
        jPanel0Layout.setVerticalGroup(
        	jPanel0Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel0Layout.createSequentialGroup()
        			.addGroup(jPanel0Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel0Layout.createSequentialGroup()
        					.addComponent(miPerfil)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(BtnExit))
        				.addGroup(jPanel0Layout.createSequentialGroup()
        					.addGap(50)
        					.addComponent(bienvenido)))
        			.addContainerGap(69, Short.MAX_VALUE))
        );
        panel0.setLayout(jPanel0Layout);
        //paneles centrales, donde se encuentran todos los botones
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(10, 10, 10)
                )
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(title))
                .addGap(18, 18, 18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(panel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.CENTER)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(ultimasGestiones, 300, 300, 300)
        					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, 20)
        					.addComponent(venta, 300, 300, 300)
        					.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, 20)
        					.addComponent(alquiler, 300, 300, 300))
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addComponent(gestorVehiculos, 300, 300, 300)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(gestorUsuarios, 300, 300, 300)))
        			.addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(ultimasGestiones, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(venta, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(alquiler, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, 20)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(gestorVehiculos, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(gestorUsuarios, 100, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, 20))
        );
        panel2.setLayout(jPanel2Layout);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                		.addComponent(panel0, javax.swing.GroupLayout.DEFAULT_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                		.addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                   )
                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addGroup(javax.swing.GroupLayout.Alignment.CENTER, layout.createSequentialGroup()
                    .addContainerGap(5, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    		.addGroup(layout.createSequentialGroup()
                        		 .addComponent(panel0, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        		 .addGroup(layout.createSequentialGroup()
                        		 .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        		 .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        		 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                           )
                        )
                    .addContainerGap())
            );

            pack();
            setLocationRelativeTo(null);
	}
	//botón para cerrar sesiíon
	private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {
		VistaIniciarSesion v = new VistaIniciarSesion();
		v.setVisible(true);
		dispose();
	}
	//botón que accede a ultimas gestiones
	private void ultimasGestionesActionPerformed(ActionEvent evt) {
		VistaGestorOperaciones v = new VistaGestorOperaciones(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}
	//botón que nos da acceso a una nueva venta
	private void ventaActionPerformed(ActionEvent evt) {
		VistaVenta v = new VistaVenta(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}
	//botón que nos da acceso a un nuevo alquiler
	private void alquilerActionPerformed(ActionEvent evt) {
		VistaAlquiler v = new VistaAlquiler(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}
	//botón para gestionar vehículos
	private void gestorVehiculosActionPerformed(java.awt.event.ActionEvent evt) {
		VistaGestorVehiculos v = new VistaGestorVehiculos(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}
	//botón para gestiones usuarios
	private void gestorUsuariosActionPerformed(java.awt.event.ActionEvent evt) {
		VistaGestorUsuarios v = new VistaGestorUsuarios(idVendedor,rol);
		v.setVisible(true);
		dispose();
	}
	//botón para ver datos del usuario
	private void miPerfilActionPerformed(ActionEvent evt) {
		VistaMiPerfil v = new VistaMiPerfil(idVendedor,rol);
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
            java.util.logging.Logger.getLogger(VistaPanelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPanelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPanelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPanelEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	new VistaPanelEmpleado(0,null).setVisible(true);
            }
        });
    } 
}
