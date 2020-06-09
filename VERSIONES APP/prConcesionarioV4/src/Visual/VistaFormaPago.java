package Visual;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Conexion.Conectar;
import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class VistaFormaPago extends JFrame {
	//variables
	private javax.swing.JLabel title;
	private javax.swing.JLabel textoPago;
	private javax.swing.JComboBox<String> tipoPago;
	
	private javax.swing.JLabel financiacion;
	private javax.swing.JComboBox<String> opcion;
	
	private javax.swing.JLabel periodo;
	private javax.swing.JTextField txtPeriodo;
	
	private javax.swing.JPanel panel1;
	
	private javax.swing.JButton BtnBack;
	private javax.swing.JButton BtnSig;
	private javax.swing.JButton BtnMenu;
	
	private javax.swing.JLabel result;
	
	public int idVendedor;
	public int idVehiculo;
	public int idCliente;
	public String date;
	public int numDias;
	public double importe;
	public String tipoOferta;
	public String tipoRol;
	
	public VistaFormaPago(int codV, int codC, int idV, String d, int numDias, double p, String t, String rol) {
		//variables
		idVendedor = idV;
		idVehiculo = codV;
		idCliente = codC;
		date = d;
		this.numDias = numDias;
		importe = p;
		tipoOferta = t;
		tipoRol = rol;
		//inicializar componentes
		initComponents();
	}
	
	private void initComponents() {
		//escalar a tamaño maximo de la pantalla
		setExtendedState(MAXIMIZED_BOTH);
		//iniciar variables
		textoPago = new javax.swing.JLabel();
		textoPago.setText("Forma de pago:");
		tipoPago = new javax.swing.JComboBox<String>();
		tipoPago.addItem("Efectivo");
		tipoPago.addItem("Tarjeta");
		tipoPago.addItem("Transferencia");
		financiacion = new javax.swing.JLabel();
		financiacion.setText("Financiación:");
		opcion = new javax.swing.JComboBox<String>();
		opcion.addItem("Si");
		opcion.addItem("No");
		periodo = new javax.swing.JLabel();
		periodo.setText("Financiación en meses:");
		txtPeriodo = new javax.swing.JTextField();
		
		Font negrita = new Font("Calibri", Font.BOLD, 30);
		
		title = new javax.swing.JLabel();
		title.setText("ASISTENTE DE PAGO:");
		title.setFont(negrita);
	//boton volver
		BtnBack = new javax.swing.JButton();
		BtnBack.setText("Atrás");
		BtnBack.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnBackActionPerformed(evt);
			}
		});
		//boton confirmar
		BtnSig = new javax.swing.JButton();
		BtnSig.setText("Confirmar");
		BtnSig.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnSigActionPerformed(evt);
			}
		});
		
		panel1 = new javax.swing.JPanel();
		panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DE PAGO"));
		//boton menu principal
		BtnMenu = new JButton("Menú principal");
		BtnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				BtnMenuActionPerformed(evt);
			}
		});
		
		result = new JLabel("");
		//panel horizontal
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(panel1);
		jPanel1Layout.setHorizontalGroup(
			jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(textoPago)
								.addComponent(financiacion)
								.addComponent(periodo)
								.addGroup(jPanel1Layout.createSequentialGroup()
									.addGap(13)
									.addComponent(BtnBack)
									.addGap(37)
									.addComponent(BtnMenu)))
							.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
									.addGap(5)
									.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(opcion, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(tipoPago, 0, 118, Short.MAX_VALUE)))
								.addGroup(jPanel1Layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPeriodo, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
								.addGroup(jPanel1Layout.createSequentialGroup()
									.addGap(30)
									.addComponent(BtnSig)))
							.addContainerGap())
						.addGroup(jPanel1Layout.createSequentialGroup()
							.addComponent(result)
							.addGap(54))))
		);
		//panel vertical
		jPanel1Layout.setVerticalGroup(
			jPanel1Layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textoPago)
						.addComponent(tipoPago, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(financiacion)
						.addComponent(opcion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(periodo)
						.addComponent(txtPeriodo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(BtnMenu)
						.addComponent(BtnSig)
						.addComponent(BtnBack))
					.addGap(18)
					.addComponent(result)
					.addGap(195))
		);
	      panel1.setLayout(jPanel1Layout);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FORMA DE PAGO");
        
	     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	     layout.setHorizontalGroup(
	     	layout.createParallelGroup(Alignment.TRAILING)
	     		.addGroup(layout.createSequentialGroup()
	     			.addGroup(layout.createParallelGroup(Alignment.LEADING)
	     				.addGroup(layout.createSequentialGroup()
	     					.addGap(40)
	     					.addComponent(title, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
	     				.addGroup(layout.createSequentialGroup()
	     					.addGap(215)
	     					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)))
	     			.addContainerGap(230, Short.MAX_VALUE))
	     );
	     layout.setVerticalGroup(
	     	layout.createParallelGroup(Alignment.TRAILING)
	     		.addGroup(layout.createSequentialGroup()
	     			.addGap(22)
	     			.addComponent(title, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
	     			.addGap(81)
	     			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
	     			.addContainerGap())
	     );
	      getContentPane().setLayout(layout);

	      pack();
	      setLocationRelativeTo(null);
	  }
	
	//boton volver, vuelve a alquiler o venta, según que operación se esté realizando
	private void BtnBackActionPerformed(ActionEvent evt) {
		switch(tipoOferta) {
			case "Alquiler": VistaAlquiler2 v1 = new VistaAlquiler2(idVehiculo, idCliente, idVendedor, tipoRol); v1.setVisible(true); dispose(); break;
			case "Venta": VistaVenta2 v2 = new VistaVenta2(idVehiculo, idCliente, idVendedor, tipoRol); v2.setVisible(true); dispose(); break;
		}
	}
	//boton siguiente, registra la operación el la base de datos
	private void BtnSigActionPerformed(ActionEvent evt) {
		 insertarOperacion();
		 result.setText("Operación registrada correctamente");
	}
	//insertar operacion
	private void insertarOperacion() {
		Conectar conec = new Conectar();
		//orden de variables
        String sql = "INSERT INTO operacion (IDoperacion, Idvendedor, IDvehiculo, IDcliente, Date, Numdias, Importe, Financiacion, Meses, Formapago, Tipooferta)\n" +
"VALUES (NULL,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        try{
		//conectamos a la bse de datos
            ps = conec.getConnection().prepareStatement(sql);
		//vamos guardando cada variable por el orden establecido
            ps.setInt(1, idVendedor);
            ps.setInt(2, idVehiculo);
            ps.setInt(3, idCliente);
            ps.setString(4, date);
            ps.setInt(5, numDias);
            ps.setDouble(6, importe);
            ps.setString(7, opcion.getSelectedItem().toString());
            if(opcion.getSelectedItem().equals("Si")) {
            	ps.setInt(8, Integer.parseInt(txtPeriodo.getText()));
            } else {
            	ps.setInt(8, 0);
            }
            ps.setString(9, tipoPago.getSelectedItem().toString());
            ps.setString(10, tipoOferta);
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
	}
	//boton menu, nos devuelve al menu principal
	private void BtnMenuActionPerformed(ActionEvent evt) {
		VistaPanelEmpleado e = new VistaPanelEmpleado(idVendedor,tipoRol); 
		String n = VistaIniciarSesion.ponerNombre(idVendedor);
		e.bienvenido.setText("Bienvenido, " + n);
		e.setVisible(true);
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
	          java.util.logging.Logger.getLogger(VistaFormaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      } catch (InstantiationException ex) {
	          java.util.logging.Logger.getLogger(VistaFormaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      } catch (IllegalAccessException ex) {
	          java.util.logging.Logger.getLogger(VistaFormaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	          java.util.logging.Logger.getLogger(VistaFormaPago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	      }

	      java.awt.EventQueue.invokeLater(new Runnable() {
	          public void run() {
	        	 VistaFormaPago v = new VistaFormaPago(0,0,0,null,0,0,null,null);
	          	v.setVisible(true);

	          }
	      });
	  } 
}
