package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import Conexion.Conectar;
import javax.swing.JPanel;
import java.awt.Color;

@SuppressWarnings("serial")
public class VistaVenta2 extends JFrame {
	private javax.swing.JLabel title;
	
	private javax.swing.JLabel texto_Vehiculo;
	private javax.swing.JLabel texto_Marca;
	private javax.swing.JLabel txtMarca;
	private javax.swing.JLabel texto_Modelo;
	private javax.swing.JLabel txtModelo;
	private javax.swing.JLabel texto_Estado;
	private javax.swing.JLabel txtEstado;
	private javax.swing.JLabel texto_TipoOferta;
	private javax.swing.JLabel txtTipoOferta;
	private javax.swing.JLabel texto_Kilometros;
	private javax.swing.JLabel txtKilometros;
	private javax.swing.JLabel texto_Cilindrada;
	private javax.swing.JLabel txtCilindrada;
	private javax.swing.JLabel texto_Precio;
	private javax.swing.JLabel txtPrecio;
	private javax.swing.JLabel texto_tipoCombustible;
	private javax.swing.JLabel txtCombustible;
	private javax.swing.JLabel texto_Cambio;
	private javax.swing.JLabel txtCambio;
	private javax.swing.JLabel texto_Anyo;
	private javax.swing.JLabel txtAnyo;
	
	private javax.swing.JLabel texto_Cliente;
	private javax.swing.JLabel texto_Dni;
	private javax.swing.JLabel txtDni;
	private javax.swing.JLabel texto_correo;
	private javax.swing.JLabel txtCorreo;
	private javax.swing.JLabel texto_Nombre;
	private javax.swing.JLabel txtNombre;
	private javax.swing.JLabel texto_Apellidos;
	private javax.swing.JLabel txtApellidos;
	private javax.swing.JLabel texto_FecNac;
	private javax.swing.JLabel txtFecNac;
	private javax.swing.JLabel texto_Movil;
	private javax.swing.JLabel txtMovil;
	private javax.swing.JLabel texto_Direccion;
	private javax.swing.JLabel txtDireccion;
	private javax.swing.JLabel texto_CodPostal;
	private javax.swing.JLabel txtCodPostal;
	private javax.swing.JLabel texto_Ciudad;
	private javax.swing.JLabel txtCiudad;
	private javax.swing.JLabel texto_Provincia;
	private javax.swing.JLabel txtProvincia;
	
	private javax.swing.JLabel textoFecha;
	private com.toedter.calendar.JDateChooser fecActual;
	private javax.swing.JLabel texto_EntregaVehiculo;
	private javax.swing.JComboBox<String> opciones;
	private javax.swing.JTextField txtPrecioOldCar;
	private javax.swing.JButton calcular;
	private javax.swing.JLabel texto_PrecioFinal;
	private javax.swing.JLabel txtPrecioFinal;
	
	private javax.swing.JPanel panel1;
	private javax.swing.JPanel panel2;
	private javax.swing.JPanel panel3;
	private javax.swing.JPanel panel4;
	
	private javax.swing.JButton BtnBack;
	private javax.swing.JButton BtnSig;
	public int codigoV;
	public int codigoC;
	public int idVendedor;
	public String tipoRol;
	private JPanel panel;
	private JPanel panel_1;
	
	public VistaVenta2(int codV, int codC, int id, String rol) {
		getContentPane().setBackground(new Color(224, 255, 255));
		setExtendedState(MAXIMIZED_BOTH);	
		codigoV = codV;
		codigoC = codC;
		idVendedor = id;
		tipoRol = rol;
		System.out.println(codigoV +" ---" + codigoC + "---" + idVendedor);	
		initComponents();		
	}
	
	private void initComponents() {
		
		Font negrita = new Font("Calibri", Font.BOLD, 30);
		
		title = new javax.swing.JLabel();
		title.setText("ASISTENTE DE ALQUILER");
		title.setFont(negrita);
		
		texto_Vehiculo = new javax.swing.JLabel();
		texto_Vehiculo.setText("DATOS DEL VEHÍCULO");
		
		fichaVehiculo(codigoV);
		
		texto_Cliente = new javax.swing.JLabel();
		texto_Cliente.setText("DATOS DEL CLIENTE");
		
		fichaCliente(codigoC);
 
		BtnBack = new javax.swing.JButton();
		BtnBack.setText("Atrás");
		BtnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnBackActionPerformed(evt);
			}
		});
		
		BtnSig = new javax.swing.JButton();
		BtnSig.setText("Siguiente");
		BtnSig.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnSigActionPerformed(evt);
			}
		});
	
		 panel4 = new javax.swing.JPanel();
		 panel4.setBackground(new Color(175, 238, 238));
		 panel4.setBorder(null);
		 javax.swing.GroupLayout jpanel4Layout = new javax.swing.GroupLayout(panel4);
		 jpanel4Layout.setHorizontalGroup(
		 	jpanel4Layout.createParallelGroup(Alignment.TRAILING)
		 		.addGroup(jpanel4Layout.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(BtnBack)
		 			.addGap(880)
		 			.addComponent(BtnSig)
		 			.addContainerGap(206, Short.MAX_VALUE))
		 );
		 jpanel4Layout.setVerticalGroup(
		 	jpanel4Layout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(jpanel4Layout.createSequentialGroup()
		 			.addContainerGap()
		 			.addGroup(jpanel4Layout.createParallelGroup(Alignment.BASELINE)
		 				.addComponent(BtnSig)
		 				.addComponent(BtnBack))
		 			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		 );
         panel4.setLayout(jpanel4Layout);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ASISTENTE DE VENTA");
	     
	     panel = new JPanel();
	     panel.setBackground(new Color(175, 238, 238));
	      textoFecha = new javax.swing.JLabel();
	      textoFecha.setText("Fecha actual:");
	      fecActual = new com.toedter.calendar.JDateChooser();
	      texto_EntregaVehiculo = new javax.swing.JLabel();
	      texto_EntregaVehiculo.setText("Entrega algún vehículo:");
	      opciones = new javax.swing.JComboBox<String>();
	      opciones.addItem("Si");
	      opciones.addItem("No");
	      txtPrecioOldCar = new javax.swing.JTextField();
	      txtPrecioOldCar.setText("···TASACIÓN···");
	      texto_PrecioFinal = new javax.swing.JLabel();
	      texto_PrecioFinal.setText("Precio final:");
	      txtPrecioFinal = new javax.swing.JLabel();
	      txtPrecioFinal.setText("···PRECIO FINAL···");
	      
	      calcular = new javax.swing.JButton();
	      calcular.setText("Calcular importe");
	      calcular.addActionListener(new java.awt.event.ActionListener() {
	      	public void actionPerformed(ActionEvent evt) {
	      		BtnCalcActionPerformed(evt);
	      	}
	      });
	      
	        panel3 = new javax.swing.JPanel();
	        panel3.setBorder(javax.swing.BorderFactory.createTitledBorder("FICHA DE ALQUILER"));
	        javax.swing.GroupLayout jpanel3Layout = new javax.swing.GroupLayout(panel3);
	        panel3.setLayout(jpanel3Layout);
	        jpanel3Layout.setHorizontalGroup(
	            jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jpanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addGroup(jpanel3Layout.createSequentialGroup()
	                        .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    		.addComponent(textoFecha)
	                    		.addComponent(texto_EntregaVehiculo)
	                    		.addComponent(txtPrecioOldCar)
	                    		.addComponent(texto_PrecioFinal)
	                    		  )
	                        .addGap(18, 18, 18)
	                        .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(fecActual)
	                            .addComponent(opciones)
	                            .addComponent(calcular)
	                            .addComponent(txtPrecioFinal)
			                    )))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	      );
	        jpanel3Layout.setVerticalGroup(
	            jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(textoFecha)
	                    .addComponent(fecActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(texto_EntregaVehiculo)
	                        .addComponent(opciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGap(18, 18, 18) 
	                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(txtPrecioOldCar)
	                        .addComponent(calcular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              		  .addGap(18, 18, 18) 
              		.addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
  	                      .addComponent(texto_PrecioFinal)
  	                      .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
		          .addContainerGap())
	        );
	      texto_Dni = new javax.swing.JLabel();
	      texto_Dni.setText("DNI:");
	      txtDni = new javax.swing.JLabel();
	      texto_correo = new javax.swing.JLabel();
	      texto_correo.setText("Correo:");
	      txtCorreo = new javax.swing.JLabel();
	      texto_Nombre = new javax.swing.JLabel();
	      texto_Nombre.setText("Nombre");
	      txtNombre = new javax.swing.JLabel();
	      texto_Apellidos = new javax.swing.JLabel();
	      texto_Apellidos.setText("Apellido:");
	      txtApellidos = new javax.swing.JLabel();
	      texto_FecNac = new javax.swing.JLabel();
	      texto_FecNac.setText("Fecha de nacimiento:");
	      txtFecNac = new javax.swing.JLabel();
	      texto_Movil = new javax.swing.JLabel();
	      texto_Movil.setText("Móvil:");
	      txtMovil = new javax.swing.JLabel();
	      texto_Direccion = new javax.swing.JLabel();
	      texto_Direccion.setText("Dirección:");
	      txtDireccion = new javax.swing.JLabel();
	      texto_CodPostal = new javax.swing.JLabel();
	      texto_CodPostal.setText("Código postal:");
	      txtCodPostal = new javax.swing.JLabel();
	      texto_Ciudad = new javax.swing.JLabel();
	      texto_Ciudad.setText("Ciudad:");
	      txtCiudad = new javax.swing.JLabel();
	      texto_Provincia = new javax.swing.JLabel();
	      texto_Provincia.setText("Provincia:");
	      txtProvincia = new javax.swing.JLabel();
	      
	      panel2 = new javax.swing.JPanel();
	      panel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DEL CLIENTE"));
	      
	      JDesktopPane desktopPane = new JDesktopPane();
	      javax.swing.GroupLayout jpanel2Layout = new javax.swing.GroupLayout(panel2);
	      jpanel2Layout.setHorizontalGroup(
	      	jpanel2Layout.createParallelGroup(Alignment.LEADING)
	      		.addGroup(jpanel2Layout.createSequentialGroup()
	      			.addContainerGap()
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.LEADING)
	      				.addComponent(texto_correo)
	      				.addComponent(texto_Dni)
	      				.addComponent(texto_Nombre)
	      				.addComponent(texto_Apellidos)
	      				.addComponent(texto_FecNac)
	      				.addComponent(texto_Movil)
	      				.addComponent(texto_Direccion)
	      				.addComponent(texto_CodPostal)
	      				.addComponent(texto_Ciudad)
	      				.addComponent(texto_Provincia))
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.LEADING)
	      				.addGroup(jpanel2Layout.createSequentialGroup()
	      					.addGap(18)
	      					.addGroup(jpanel2Layout.createParallelGroup(Alignment.LEADING, false)
	      						.addComponent(txtCorreo)
	      						.addComponent(txtDni)
	      						.addComponent(txtNombre)
	      						.addComponent(txtApellidos)
	      						.addComponent(txtFecNac)
	      						.addComponent(txtMovil)
	      						.addComponent(txtDireccion)
	      						.addComponent(txtCodPostal)
	      						.addComponent(txtCiudad)
	      						.addComponent(txtProvincia))
	      					.addContainerGap(228, Short.MAX_VALUE))
	      				.addGroup(Alignment.TRAILING, jpanel2Layout.createSequentialGroup()
	      					.addPreferredGap(ComponentPlacement.RELATED)
	      					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
	      					.addGap(61))))
	      );
	      jpanel2Layout.setVerticalGroup(
	      	jpanel2Layout.createParallelGroup(Alignment.TRAILING)
	      		.addGroup(jpanel2Layout.createSequentialGroup()
	      			.addContainerGap()
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.TRAILING)
	      				.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
	      				.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      					.addComponent(texto_correo)
	      					.addComponent(txtCorreo)))
	      			.addGap(18)
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(texto_Dni)
	      				.addComponent(txtDni))
	      			.addGap(18)
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(texto_Nombre)
	      				.addComponent(txtNombre))
	      			.addGap(20)
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(texto_Apellidos)
	      				.addComponent(txtApellidos))
	      			.addGap(18)
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(texto_FecNac)
	      				.addComponent(txtFecNac))
	      			.addGap(18)
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(texto_Movil)
	      				.addComponent(txtMovil))
	      			.addGap(18)
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(texto_Direccion)
	      				.addComponent(txtDireccion))
	      			.addGap(18)
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(texto_CodPostal)
	      				.addComponent(txtCodPostal))
	      			.addGap(18)
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(texto_Ciudad)
	      				.addComponent(txtCiudad))
	      			.addGap(18)
	      			.addGroup(jpanel2Layout.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(texto_Provincia)
	      				.addComponent(txtProvincia))
	      			.addContainerGap())
	      );
	      panel2.setLayout(jpanel2Layout);
	      texto_Marca = new javax.swing.JLabel();
	      texto_Marca.setText("Marca:");
	      txtMarca = new javax.swing.JLabel();
	      texto_Modelo = new javax.swing.JLabel();
	      texto_Modelo.setText("Modelo:");
	      txtModelo = new javax.swing.JLabel();
	      texto_Estado = new javax.swing.JLabel();
	      texto_Estado.setText("Estado:");
	      txtEstado = new javax.swing.JLabel();
	      texto_TipoOferta = new javax.swing.JLabel();
	      texto_TipoOferta.setText("Tipo de oferta:");
	      txtTipoOferta = new javax.swing.JLabel();
	      texto_Kilometros = new javax.swing.JLabel();
	      texto_Kilometros.setText("Kilómetros:");
	      txtKilometros = new javax.swing.JLabel();
	      texto_Cilindrada = new javax.swing.JLabel();
	      texto_Cilindrada.setText("Cilindrada:");
	      txtCilindrada = new javax.swing.JLabel();
	      texto_Precio = new javax.swing.JLabel();
	      texto_Precio.setText("Precio:");
	      txtPrecio = new javax.swing.JLabel();
	      texto_tipoCombustible = new javax.swing.JLabel();
	      texto_tipoCombustible.setText("Combustible:");
	      txtCombustible = new javax.swing.JLabel();
	      texto_Cambio = new javax.swing.JLabel();
	      texto_Cambio.setText("Cambio:");
	      txtCambio = new javax.swing.JLabel();
	      texto_Anyo = new javax.swing.JLabel();
	      texto_Anyo.setText("Año de fabricación:");
	      txtAnyo = new javax.swing.JLabel();
	      
	      panel1 = new javax.swing.JPanel();
	      panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DEL VEHÍCULO"));
	      javax.swing.GroupLayout jpanel1Layout = new javax.swing.GroupLayout(panel1);
	      panel1.setLayout(jpanel1Layout);
	      jpanel1Layout.setHorizontalGroup(
	          jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	          .addGroup(jpanel1Layout.createSequentialGroup()
	              .addContainerGap()
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                  .addGroup(jpanel1Layout.createSequentialGroup()
	                      .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                  		.addComponent(texto_Marca)
	                  		.addComponent(texto_Modelo)
	                  		.addComponent(texto_Estado)
	                  		.addComponent(texto_TipoOferta)
	                  		.addComponent(texto_Kilometros)
	                  		.addComponent(texto_Cilindrada)
	                  		.addComponent(texto_Precio)
	                  		.addComponent(texto_tipoCombustible)
	                  		.addComponent(texto_Cambio)
	                  		.addComponent(texto_Anyo)    
	                          )
	                      .addGap(18, 18, 18)
	                      .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                          .addComponent(txtMarca)
	                          .addComponent(txtModelo)
	                          .addComponent(txtEstado)
	                          .addComponent(txtTipoOferta)
	                          .addComponent(txtKilometros)
	                          .addComponent(txtCilindrada)
	                          .addComponent(txtPrecio)
	                          .addComponent(txtCombustible)
	                          .addComponent(txtCambio)
	                          .addComponent(txtAnyo)
	                          )))
	              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	      );
	      jpanel1Layout.setVerticalGroup(
	          jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel1Layout.createSequentialGroup()
	              .addContainerGap()
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                  .addComponent(texto_Marca)
	                  .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	              .addGap(18, 18, 18)
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                      .addComponent(texto_Modelo)
	                      .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                  .addGap(18, 18, 18) 
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                      .addComponent(texto_Estado)
	                      .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
		            .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(texto_TipoOferta)
		                    .addComponent(txtTipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addGap(18, 18, 18)
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(texto_Kilometros)
		                    .addComponent(txtKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addGap(18, 18, 18)
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
		                    .addComponent(texto_Cilindrada)
		                    .addComponent(txtCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
		                .addGap(18, 18, 18)
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                  .addComponent(texto_Precio)
	                  .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	              .addGap(18, 18, 18)
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                      .addComponent(texto_tipoCombustible)
	                      .addComponent(txtCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                  .addGap(18, 18, 18)
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                      .addComponent(texto_Cambio)
	                      .addComponent(txtCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                  .addGap(18, 18, 18)
	              .addGroup(jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                      .addComponent(texto_Anyo)
	                      .addComponent(txtAnyo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                  .addGap(18, 18, 18)
	              .addContainerGap())
	      );
	      GroupLayout gl_panel = new GroupLayout(panel);
	      gl_panel.setHorizontalGroup(
	      	gl_panel.createParallelGroup(Alignment.TRAILING)
	      		.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
	      			.addContainerGap()
	      			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED)
	      			.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.UNRELATED)
	      			.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(71, Short.MAX_VALUE))
	      );
	      gl_panel.setVerticalGroup(
	      	gl_panel.createParallelGroup(Alignment.LEADING)
	      		.addGroup(gl_panel.createSequentialGroup()
	      			.addContainerGap()
	      			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
	      			.addContainerGap(12, Short.MAX_VALUE))
	      );
	      panel.setLayout(gl_panel);
	      
	      panel_1 = new JPanel();
	      panel_1.setBackground(new Color(224, 255, 255));
	      GroupLayout groupLayout = new GroupLayout(getContentPane());
	      groupLayout.setHorizontalGroup(
	      	groupLayout.createParallelGroup(Alignment.LEADING)
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	      				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	      					.addContainerGap()
	      					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1901, Short.MAX_VALUE))
	      				.addGroup(groupLayout.createSequentialGroup()
	      					.addGap(435)
	      					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	      						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1040, GroupLayout.PREFERRED_SIZE)
	      						.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 1040, GroupLayout.PREFERRED_SIZE)))
	      				.addGroup(groupLayout.createSequentialGroup()
	      					.addGap(799)
	      					.addComponent(title)))
	      			.addContainerGap())
	      );
	      groupLayout.setVerticalGroup(
	      	groupLayout.createParallelGroup(Alignment.LEADING)
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addGap(137)
	      			.addComponent(title)
	      			.addGap(18)
	      			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      			.addGap(18)
	      			.addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	      			.addGap(71)
	      			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap())
	      );
	      getContentPane().setLayout(groupLayout);

	      pack();
	      setLocationRelativeTo(null);
	  }
	
	private void fichaVehiculo(int codigoV) {
		Conectar conec = new Conectar();
        String sql = "SELECT * FROM vehiculo WHERE idVehiculo = '" + codigoV + "'";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            txtMarca.setText(rs.getString(2));
            txtModelo.setText(rs.getString(3));
            txtEstado.setText(rs.getString(4));
            txtTipoOferta.setText(rs.getString(5));
            txtKilometros.setText(String.valueOf(rs.getInt(6)));
            txtCilindrada.setText(rs.getString(7));
            txtPrecio.setText(String.valueOf(rs.getDouble(8)));
            txtCombustible.setText(rs.getString(9));
            txtCambio.setText(rs.getString(10));
            txtAnyo.setText(String.valueOf(rs.getInt(11)));
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
	
	private void fichaCliente(int codigoC) {
		Conectar conec = new Conectar();
        String sql = "SELECT * FROM usuario WHERE idUsuario = '" + codigoC + "'";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            txtCorreo.setText(rs.getString(2));
            txtDni.setText(rs.getString(4));
            txtNombre.setText(rs.getString(5));
            txtApellidos.setText(rs.getString(6));
            txtFecNac.setText(rs.getString(7));
            txtMovil.setText(String.valueOf(rs.getInt(8)));
            txtDireccion.setText(rs.getString(9));
            txtCodPostal.setText(String.valueOf(rs.getInt(10)));
            txtCiudad.setText(rs.getString(11));
            txtProvincia.setText(rs.getString(12));
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
	
	private void BtnBackActionPerformed(ActionEvent evt) {
		VistaVenta v = new VistaVenta(idVendedor,tipoRol);
		v.setVisible(true);
		dispose();
	}
	
	private void BtnSigActionPerformed(ActionEvent evt) {
		Date date = fecActual.getDate();
		String strDate = DateFormat.getDateInstance().format(date);
		VistaFormaPago v = new VistaFormaPago(codigoV,codigoC,idVendedor,strDate,0,Double.parseDouble(txtPrecioFinal.getText()),"Venta",tipoRol);
		v.setVisible(true);
		dispose();
	}
	
	private void BtnCalcActionPerformed(ActionEvent evt) {
		double precioFinal = Double.parseDouble(txtPrecio.getText()) - Double.parseDouble(txtPrecioOldCar.getText());
		txtPrecioFinal.setText(String.valueOf(precioFinal));
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
	          java.util.logging.Logger.getLogger(VistaVenta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      } catch (InstantiationException ex) {
	          java.util.logging.Logger.getLogger(VistaVenta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      } catch (IllegalAccessException ex) {
	          java.util.logging.Logger.getLogger(VistaVenta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	          java.util.logging.Logger.getLogger(VistaVenta2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      }

	     java.awt.EventQueue.invokeLater(new Runnable() {
	          public void run() {
	        	 VistaVenta2 v = new VistaVenta2(0,0,0,null);
	          	v.setVisible(true);

	          }
	      });
	  } 
}