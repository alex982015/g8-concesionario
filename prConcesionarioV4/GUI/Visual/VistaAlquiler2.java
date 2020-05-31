package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JFrame;
import com.toedter.calendar.JDateChooser;

import Conexion.Conectar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import java.awt.Color;

@SuppressWarnings("serial")
public class VistaAlquiler2 extends JFrame {
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
	
	private javax.swing.JLabel texto_FechaActual;
	private javax.swing.JLabel texto_NumDias;
	private javax.swing.JTextField txtNumDias;
	private javax.swing.JButton calcularPrecio;
	private javax.swing.JLabel precio;
	
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
	
	private com.toedter.calendar.JDateChooser txtFechaActual;
	private JPanel panel;
	private JPanel panel_1;
	
	public VistaAlquiler2(int codV, int codC, int id, String rol) {
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
		texto_Vehiculo.setText("DATOS DEL VEH�CULO");
		
		fichaVehiculo(codigoV);
		
		texto_Cliente = new javax.swing.JLabel();
		texto_Cliente.setText("DATOS DEL CLIENTE");
		
		fichaCliente(codigoC);
 
		BtnBack = new javax.swing.JButton();
		BtnBack.setText("Atr�s");
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
         panel4.setLayout(jpanel4Layout);
         jpanel4Layout.setHorizontalGroup(
             jpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel4Layout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(BtnBack)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1400, Short.MAX_VALUE)
                 .addComponent(BtnSig)
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                 .addGap(10, 10, 10)
                 )
         );
         jpanel4Layout.setVerticalGroup(
             jpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(jpanel4Layout.createSequentialGroup()
                 .addContainerGap()
                 .addGroup(jpanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(BtnBack)
                     .addComponent(BtnSig))
                 .addGap(18, 18, 18)
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
         );
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ASISTENTE DE ALQUILER");
	      
	      panel = new JPanel();
	      panel.setBackground(new Color(175, 238, 238));
	      texto_FechaActual = new javax.swing.JLabel();
	      texto_FechaActual.setText("Fecha actual");
	      txtFechaActual = new JDateChooser();
	      texto_NumDias = new javax.swing.JLabel();
	      texto_NumDias.setText("N�mero de d�as:");
	      txtNumDias = new javax.swing.JTextField();
	      calcularPrecio = new javax.swing.JButton();
	      calcularPrecio.setText("Calcular importe");
	      calcularPrecio.addActionListener(new java.awt.event.ActionListener() {
	      	public void actionPerformed(ActionEvent evt) {
	      		BtnCalcActionPerformed(evt);
	      	}
	      });
	      
	      precio = new javax.swing.JLabel();
	      precio.setText("���PRECIO FINAL���");
	      
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
	                    		.addComponent(texto_FechaActual)
	                    		.addComponent(texto_NumDias)
	                    		.addComponent(calcularPrecio)
	                    		  )
	                        .addGap(18, 18, 18)
	                        .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(txtFechaActual)
	                            .addComponent(txtNumDias)
	                            .addComponent(precio)
			                    )))
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	      );
	        jpanel3Layout.setVerticalGroup(
	            jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpanel3Layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(texto_FechaActual)
	                    .addComponent(txtFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
	                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(texto_NumDias)
	                        .addComponent(txtNumDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                    .addGap(18, 18, 18) 
	                .addGroup(jpanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                        .addComponent(calcularPrecio)
	                        .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
	      texto_Movil.setText("M�vil:");
	      txtMovil = new javax.swing.JLabel();
	      texto_Direccion = new javax.swing.JLabel();
	      texto_Direccion.setText("Direcci�n:");
	      txtDireccion = new javax.swing.JLabel();
	      texto_CodPostal = new javax.swing.JLabel();
	      texto_CodPostal.setText("C�digo postal:");
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
	      texto_Kilometros.setText("Kil�metros:");
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
	      texto_Anyo.setText("A�o de fabricaci�n:");
	      txtAnyo = new javax.swing.JLabel();
	      
	      panel1 = new javax.swing.JPanel();
	      panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DEL VEH�CULO"));
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
	      	gl_panel.createParallelGroup(Alignment.LEADING)
	      		.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
	      			.addContainerGap(25, Short.MAX_VALUE)
	      			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
	      			.addGap(18)
	      			.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
	      			.addGap(18)
	      			.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
	      			.addGap(491))
	      );
	      gl_panel.setVerticalGroup(
	      	gl_panel.createParallelGroup(Alignment.LEADING)
	      		.addGroup(gl_panel.createSequentialGroup()
	      			.addContainerGap()
	      			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	      				.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)))
	      );
	      panel.setLayout(gl_panel);
	      
	      panel_1 = new JPanel();
	      panel_1.setBackground(new Color(224, 255, 255));
	      GroupLayout groupLayout = new GroupLayout(getContentPane());
	      groupLayout.setHorizontalGroup(
	      	groupLayout.createParallelGroup(Alignment.LEADING)
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addContainerGap()
	      			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 1886, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	      		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	      			.addContainerGap(428, Short.MAX_VALUE)
	      			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	      				.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 1055, GroupLayout.PREFERRED_SIZE)
	      				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1055, GroupLayout.PREFERRED_SIZE))
	      			.addGap(423))
	      		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	      			.addContainerGap(803, Short.MAX_VALUE)
	      			.addComponent(title)
	      			.addGap(796))
	      );
	      groupLayout.setVerticalGroup(
	      	groupLayout.createParallelGroup(Alignment.LEADING)
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addGap(120)
	      			.addComponent(title, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
	      			.addGap(18)
	      			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
	      			.addGap(18)
	      			.addComponent(panel4, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
	      			.addPreferredGap(ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
	      			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
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
		VistaAlquiler v = new VistaAlquiler(idVendedor, tipoRol);
		v.setVisible(true);
		dispose();
	}
	
	private void BtnSigActionPerformed(ActionEvent evt) {
		Date date = txtFechaActual.getDate();
		String strDate = DateFormat.getDateInstance().format(date);
		VistaFormaPago v = new VistaFormaPago(codigoV,codigoC,idVendedor,strDate,Integer.parseInt(txtNumDias.getText()),Double.parseDouble(precio.getText()),"Alquiler", tipoRol);
		v.setVisible(true);
		dispose();
	}
	
	private void BtnCalcActionPerformed(ActionEvent evt) {
		double precioFinal = Double.parseDouble(txtPrecio.getText()) * Double.parseDouble(txtNumDias.getText());
		precio.setText(String.valueOf(precioFinal));
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
	          java.util.logging.Logger.getLogger(VistaAlquiler2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      } catch (InstantiationException ex) {
	          java.util.logging.Logger.getLogger(VistaAlquiler2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      } catch (IllegalAccessException ex) {
	          java.util.logging.Logger.getLogger(VistaAlquiler2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	          java.util.logging.Logger.getLogger(VistaAlquiler2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      }

	     java.awt.EventQueue.invokeLater(new Runnable() {
	          public void run() {
	        	 VistaAlquiler2 v = new VistaAlquiler2(0,0,0,null);
	          	v.setVisible(true);

	          }
	      });
	  } 
}