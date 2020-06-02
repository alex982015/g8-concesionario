package Visual;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import Conexion.Conectar;

@SuppressWarnings("serial")
public class VistaFormaPago extends JFrame {
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
	
	private Dimension dim;
	
	public int idVendedor;
	public int idVehiculo;
	public int idCliente;
	public String date;
	public int numDias;
	public double importe;
	public String tipoOferta;
	public String tipoRol;
	private JPanel panel_1;
	
	public VistaFormaPago(int codV, int codC, int idV, String d, int numDias, double p, String t, String rol) {
		getContentPane().setBackground(new Color(224, 255, 255));
		idVendedor = idV;
		idVehiculo = codV;
		idCliente = codC;
		date = d;
		this.numDias = numDias;
		importe = p;
		tipoOferta = t;
		tipoRol = rol;
		initComponents();
	}
	
	private void initComponents() {
		setExtendedState(MAXIMIZED_BOTH);
		
		Font negrita = new Font("Calibri", Font.BOLD, 30);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FORMA DE PAGO");
		  
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		  panel_1 = new JPanel();
		  panel_1.setBackground(new Color(175, 238, 238));
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
	      
	      	BtnBack = new javax.swing.JButton();
	      	BtnBack.setText("Atrás");
	      	BtnBack.addActionListener(new java.awt.event.ActionListener() {
	      		public void actionPerformed(ActionEvent evt) {
	      			BtnBackActionPerformed(evt);
	      		}
	      	});
	      	
	      	BtnSig = new javax.swing.JButton();
	      	BtnSig.setText("Confirmar");
	      	BtnSig.addActionListener(new java.awt.event.ActionListener() {
	      		public void actionPerformed(ActionEvent evt) {
	      			BtnSigActionPerformed(evt);
	      		}
	      	});
	      	
	      	panel1 = new javax.swing.JPanel();
	      	panel1.setBorder(javax.swing.BorderFactory.createTitledBorder("DATOS DE PAGO"));
	      	
	      	BtnMenu = new JButton("Menú principal");
	      	BtnMenu.addActionListener(new ActionListener() {
	      		public void actionPerformed(ActionEvent evt) {
	      			BtnMenuActionPerformed(evt);
	      		}
	      	});
	      	
	      	result = new JLabel("");
	      	
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
	      								.addGap(20)
	      								.addComponent(BtnBack)
	      								.addGap(20)
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
	      								.addGap(20)
	      								.addComponent(BtnSig)))
	      						.addContainerGap())
	      					.addGroup(jPanel1Layout.createSequentialGroup()
	      						.addComponent(result)
	      						.addGap(54))))
	      	);
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
	      
	      title = new javax.swing.JLabel();
	      title.setText("ASISTENTE DE PAGO");
	      title.setFont(negrita);
	      GroupLayout gl_panel_1 = new GroupLayout(panel_1);
	      gl_panel_1.setHorizontalGroup(
	      	gl_panel_1.createParallelGroup(Alignment.LEADING)
	      		.addGroup(gl_panel_1.createSequentialGroup()
	      			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
	      				.addGroup(gl_panel_1.createSequentialGroup()
	      					.addGap(28)
	      					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE))
	      				.addGroup(gl_panel_1.createSequentialGroup()
	      					.addGap(88)
	      					.addComponent(title)))
	      			.addContainerGap(30, Short.MAX_VALUE))
	      );
	      gl_panel_1.setVerticalGroup(
	      	gl_panel_1.createParallelGroup(Alignment.LEADING)
	      		.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
	      			.addContainerGap()
	      			.addComponent(title)
	      			.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
	      			.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE)
	      			.addGap(25))
	      );
	      panel_1.setLayout(gl_panel_1);
	    
	      
	      GroupLayout groupLayout = new GroupLayout(getContentPane());
	      groupLayout.setHorizontalGroup(
	      	groupLayout.createParallelGroup(Alignment.LEADING)
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addContainerGap()
	      			.addGap((dim.width/3)+30)
	      			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 430, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap())
	      );
	      groupLayout.setVerticalGroup(
	      	groupLayout.createParallelGroup(Alignment.LEADING)
	      		.addGroup(groupLayout.createSequentialGroup()
	      			.addGap((dim.height/3)+20)
	      			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
	      			.addContainerGap(373, Short.MAX_VALUE))
	      );
	      getContentPane().setLayout(groupLayout);

	      pack();
	      setLocationRelativeTo(null);
	  }
	
	
	private void BtnBackActionPerformed(ActionEvent evt) {
		switch(tipoOferta) {
			case "Alquiler": VistaAlquiler2 v1 = new VistaAlquiler2(idVehiculo, idCliente, idVendedor, tipoRol); v1.setVisible(true); dispose(); break;
			case "Venta": VistaVenta2 v2 = new VistaVenta2(idVehiculo, idCliente, idVendedor, tipoRol); v2.setVisible(true); dispose(); break;
		}
	}
	
	private void BtnSigActionPerformed(ActionEvent evt) {
		 insertarOperacion();
		 result.setText("Operación registrada correctamente");
	}
	
	private void insertarOperacion() {
		Conectar conec = new Conectar();
        String sql = "INSERT INTO operacion (IDoperacion, Idvendedor, IDvehiculo, IDcliente, Date, Numdias, Importe, Financiacion, Meses, Formapago, Tipooferta)\n" +
"VALUES (NULL,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
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
