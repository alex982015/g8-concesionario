package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Model.GestorVehiculos;
import Model.Vehiculo;
import Tabla.TablaGestorVehiculos;

public class VistaGestorVehiculos extends JFrame {

	  private javax.swing.JButton BtnFoto;
	    private javax.swing.JButton BtnAdd;
	    private javax.swing.JButton BtnEdit;
	    private javax.swing.JButton BtnDel;
	    private javax.swing.JButton BtnClean;
	    private javax.swing.JButton BtnExit;
	    private javax.swing.JButton BtnSearch;
	    private javax.swing.JButton calcular;
	    
	    private javax.swing.JLabel texto_Modelo;
	    private javax.swing.JLabel texto_Precio;
	    private javax.swing.JLabel texto_Marca;
	    private javax.swing.JLabel texto_Codigo;
	    private javax.swing.JLabel texto_Estado;
	    private javax.swing.JLabel texto_TipoOferta;
	    private javax.swing.JLabel texto_Kilometros;
	    private javax.swing.JLabel texto_Cilindrada;
	    private javax.swing.JLabel texto_TipoCombustible;
	    private javax.swing.JLabel texto_TipoCambio;
	    private javax.swing.JLabel texto_AnyoFabricacion;
	    private javax.swing.JLabel texto_PrecioSinIva;
	    private javax.swing.JLabel texto_Matricula;
	    private javax.swing.JLabel texto_Unidades;
	    
	    private javax.swing.JPanel jPanel1;
	    private javax.swing.JPanel jPanel2;
	    
	    private javax.swing.JScrollPane jScrollPane1;
	    
	    private javax.swing.JTable tabla;
	    
	    private javax.swing.JTextField txtc;
	    private javax.swing.JTextField txtMarca;
	    private javax.swing.JTextField txtModelo;
	    private javax.swing.JComboBox<String> txtEstado;
	    private javax.swing.JTextField txtPrecio;
	    private javax.swing.JTextField txtRuta;
	    private javax.swing.JComboBox<String> txtTipoOferta;
	    private javax.swing.JTextField txtKilometros;
	    private javax.swing.JTextField txtCilindrada;
	    private javax.swing.JComboBox<String> txtTipoCombustible;
	    private javax.swing.JComboBox<String> txtTipoCambio;
	    private javax.swing.JTextField txtAnyoFabricacion;
	    private javax.swing.JTextField txtPrecioSinIva;
	    private javax.swing.JTextField txtMatricula;
	    private javax.swing.JTextField txtUnidades;
	    
	    private JComboBox<String> filtro;
  
  GestorVehiculos dao;
  Vehiculo vo = new Vehiculo();
  TablaGestorVehiculos t = new TablaGestorVehiculos();
  
  int codigo = 0;
  
  public VistaGestorVehiculos() {
      initComponents();
      filtro.setSelectedIndex(0);
      
      t.verVehiculos(tabla, filtro.getSelectedItem().toString());
      
      setExtendedState(MAXIMIZED_BOTH);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  
  public void limpiar(){
      txtc.setText("");
      txtMarca.setText("");
      txtModelo.setText("");
      txtKilometros.setText("");
      txtCilindrada.setText("");
      txtAnyoFabricacion.setText("");
      txtPrecioSinIva.setText("");
      txtPrecio.setText("");
      txtMatricula.setText("");
      txtUnidades.setText("");
      txtRuta.setText("");
      codigo = 0;
  }
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

      jScrollPane1 = new javax.swing.JScrollPane();
      tabla = new javax.swing.JTable();
      jPanel1 = new javax.swing.JPanel();
      jPanel2 = new javax.swing.JPanel();
      
      BtnAdd = new javax.swing.JButton();
      BtnDel = new javax.swing.JButton();
      BtnEdit = new javax.swing.JButton();
      BtnClean = new javax.swing.JButton();
      BtnFoto = new javax.swing.JButton();
      BtnSearch = new javax.swing.JButton();
      BtnExit = new javax.swing.JButton();
      
      texto_Marca = new javax.swing.JLabel();
      texto_Modelo = new javax.swing.JLabel();
      texto_Precio = new javax.swing.JLabel();
      texto_Estado = new javax.swing.JLabel();
      texto_Modelo = new javax.swing.JLabel();
      texto_Codigo = new javax.swing.JLabel();
      texto_TipoOferta = new javax.swing.JLabel();
      texto_Kilometros = new javax.swing.JLabel();
      texto_Cilindrada = new javax.swing.JLabel();
      texto_TipoCombustible = new javax.swing.JLabel();
      texto_TipoCambio = new javax.swing.JLabel();
      texto_AnyoFabricacion = new javax.swing.JLabel();
      texto_PrecioSinIva = new javax.swing.JLabel();
      texto_Matricula = new javax.swing.JLabel();
      texto_Unidades = new javax.swing.JLabel();   
      
      txtRuta = new javax.swing.JTextField();
      txtMarca = new javax.swing.JTextField();
      txtPrecio = new javax.swing.JTextField();
      txtModelo = new javax.swing.JTextField();
      txtEstado = new javax.swing.JComboBox<String>();
      txtEstado.addItem("Nuevo");
      txtEstado.addItem("Seminuevo");
      txtTipoOferta = new javax.swing.JComboBox<String>();
      txtTipoOferta.addItem("Venta");
      txtTipoOferta.addItem("Alquiler");
      txtKilometros = new javax.swing.JTextField();
      txtCilindrada = new javax.swing.JTextField();
      txtTipoCombustible = new javax.swing.JComboBox<String>();
      txtTipoCombustible.addItem("Gasolina");
      txtTipoCombustible.addItem("Di�sel");
      txtTipoCombustible.addItem("GLP");
      txtTipoCombustible.addItem("El�ctrico");
      txtTipoCombustible.addItem("H�brido");
      txtTipoCambio = new javax.swing.JComboBox<String>();
      txtTipoCambio.addItem("Manual");
      txtTipoCambio.addItem("Autom�tico");
      txtAnyoFabricacion = new javax.swing.JTextField();
      txtPrecioSinIva = new javax.swing.JTextField();
      txtMatricula = new javax.swing.JTextField();
      txtUnidades = new javax.swing.JTextField();
      txtc = new javax.swing.JTextField();
      
      filtro = new JComboBox<String>();
      filtro.addItem("default");
      filtro.addItem("marca");
      filtro.addItem("modelo");
      filtro.addItem("estado");
      filtro.addItem("tipoOferta");
      filtro.addItem("kilometros");
      filtro.addItem("cilindrada");
      filtro.addItem("tipoCombustible");
      filtro.addItem("tipoCambio");
      filtro.addItem("AnyoFabricacion");
      filtro.addItem("unidades");
      
      calcular = new javax.swing.JButton();
      calcular.setText("QUITAR IVA");
      calcular.addActionListener(new ActionListener() {
    	 public void actionPerformed(ActionEvent evt) {
    		 BtnCalcActionPerformed(evt);
    	 } 
      });
      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
      setTitle("Gestor de vehiculos");

      tabla.setModel(new javax.swing.table.DefaultTableModel(
          new Object [][] {
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null},
              {null, null, null, null}
          },
          new String [] {
              "ID Vehiculo", "Marca", "Modelo", "Estado", "Tipo Oferta", "Precio", "Kilometros", "Cilindrada", "Combustible", "Cambio", "A�o", "PrecioSinIva", "Matricula","Unidades", "Imagen"
          }
      ));
      tabla.addMouseListener(new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
              tablaMouseClicked(evt);
          }
      });
      jScrollPane1.setViewportView(tabla);

      jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

      BtnAdd.setText("Agregar");
      BtnAdd.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnAddActionPerformed(evt);
          }
      });

      BtnDel.setText("Eliminar");
      BtnDel.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnDelActionPerformed(evt);
          }
      });

      BtnEdit.setText("Modificar");
      BtnEdit.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnEditActionPerformed(evt);
          }
      });

      BtnClean.setText("Limpiar");
      BtnClean.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnCleanActionPerformed(evt);
          }
      });
      
      BtnExit.setText("Atr�s");
      BtnExit.addActionListener(new java.awt.event.ActionListener() {
      	public void actionPerformed(java.awt.event.ActionEvent evt) {
      		BtnExitActionPerformed(evt);
      	}
      });
      
      BtnSearch.setText("Filtrar");
      BtnSearch.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnSearchActionPerformed(evt);
          }
      });
      
     

      javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
      jPanel1.setLayout(jPanel1Layout);
      jPanel1Layout.setHorizontalGroup(
          jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(BtnAdd)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
              .addComponent(BtnEdit)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
              .addComponent(BtnDel)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
              .addComponent(BtnClean)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
              .addComponent(BtnExit)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
              .addComponent(filtro)
              .addComponent(BtnSearch)
              .addGap(10, 10, 10)
              )
      );
      jPanel1Layout.setVerticalGroup(
          jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(BtnAdd)
                  .addComponent(BtnDel)
                  .addComponent(BtnEdit)
                  .addComponent(BtnClean)
                  .addComponent(BtnExit)
                  .addComponent(filtro)
                  .addComponent(BtnSearch))
              .addGap(18, 18, 18)
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

      txtRuta.setEditable(false);
      txtRuta.setBackground(new java.awt.Color(204, 204, 255));

      BtnFoto.setText("Foto");
      BtnFoto.addActionListener(new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
              BtnFotoActionPerformed(evt);
          }
      });

      texto_Marca.setText("Marca:");

      texto_Modelo.setText("Modelo:");
      
      texto_Estado.setText("Estado:");
      
      texto_TipoOferta.setText("Tipo Oferta:");
      
      texto_Kilometros.setText("Kil�metros");
      
      texto_Cilindrada.setText("Cilindrada:");
      
      texto_TipoCombustible.setText("Combustible:");
      
      texto_TipoCambio.setText("Cambio:");
      
      texto_AnyoFabricacion.setText("A�o de Fabricaci�n:");
      
      texto_PrecioSinIva.setText("Precio sin Iva:");
      
      texto_Matricula.setText("Matricula:");
      
      texto_Unidades.setText("Unidades:");

      texto_Precio.setText("Importe:");
      
      texto_Codigo.setText("Codigo:");

      txtc.setEditable(false);
      txtc.setBackground(new java.awt.Color(204, 204, 255));

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
          jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                      .addComponent(txtRuta, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                      .addGap(18, 18, 18)
                      .addComponent(BtnFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel2Layout.createSequentialGroup()
                      .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  		.addComponent(texto_Marca)
                  		.addComponent(texto_Modelo)
                  		.addComponent(texto_Estado)
                  		.addComponent(texto_TipoOferta)
                  		.addComponent(texto_Kilometros)
                  		.addComponent(texto_Cilindrada)
                  		.addComponent(texto_Precio)
                  		.addComponent(texto_TipoCombustible)
                  		.addComponent(texto_TipoCambio)
                  		.addComponent(texto_AnyoFabricacion)
                  		.addComponent(texto_PrecioSinIva)
                  		.addComponent(texto_Matricula)
                  		.addComponent(texto_Unidades)
                          .addComponent(texto_Codigo)
                          
                          )
                      .addGap(18, 18, 18)
                      .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                          .addComponent(txtMarca)
                          .addComponent(txtModelo)
                          .addComponent(txtEstado)
                          .addComponent(txtTipoOferta)
                          .addComponent(txtKilometros)
                          .addComponent(txtCilindrada)
                          .addComponent(txtPrecio)
                          .addComponent(txtTipoCombustible)
                          .addComponent(txtTipoCambio)
                          .addComponent(txtAnyoFabricacion)
                          .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        		  .addComponent(txtPrecioSinIva)
                        		  .addComponent(calcular))
                          .addComponent(txtMatricula)
                          .addComponent(txtUnidades)
                          .addComponent(txtc, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                          )))
              .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );
      jPanel2Layout.setVerticalGroup(
          jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(texto_Codigo)
                      .addComponent(txtc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(texto_Marca)
                  .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(texto_Modelo)
                      .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18) 
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(texto_Estado)
                      .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, 20)
	            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(texto_TipoOferta)
	                    .addComponent(txtTipoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(texto_Kilometros)
	                    .addComponent(txtKilometros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(texto_Cilindrada)
	                    .addComponent(txtCilindrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(texto_Precio)
                  .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(texto_TipoCombustible)
                      .addComponent(txtTipoCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(texto_TipoCambio)
                      .addComponent(txtTipoCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(texto_AnyoFabricacion)
                      .addComponent(txtAnyoFabricacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(texto_PrecioSinIva)
                      .addComponent(txtPrecioSinIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          			  .addComponent(calcular)
              .addGap(18, 18, 18)
              
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                      .addComponent(texto_Matricula)
                      .addComponent(txtMatricula))
                .addGap(18, 18, 18)
              
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                          .addComponent(texto_Unidades)
                          .addComponent(txtUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                      .addGap(18, 18, 18)
              .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                  .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(BtnFoto))  
              .addContainerGap())
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
              .addContainerGap()
              .addGap(18, 18, 18)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              		.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                 )
              .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addContainerGap())
      );
      layout.setVerticalGroup(
          layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
              .addContainerGap(5, 10)
              .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              		.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
              		.addGroup(layout.createSequentialGroup()
                  		 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                  		 .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                     )
                  )
              .addContainerGap())
      );

      pack();
      setLocationRelativeTo(null);
  }// </editor-fold>//GEN-END:initComponents

  private void BtnExitActionPerformed(java.awt.event.ActionEvent evt) {
  	VistaPanelEmpleado v = new VistaPanelEmpleado(0);
  	v.setVisible(true);
  	dispose();
  }
  
  private void BtnCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCleanActionPerformed
      limpiar();
  }//GEN-LAST:event_BtnCleanActionPerformed
  
  private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {
  	t.verVehiculos(tabla,filtro.getSelectedItem().toString());
  }
  
  private void BtnFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFotoActionPerformed
      
      JFileChooser j = new JFileChooser();
      FileNameExtensionFilter fil = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
      j.setFileFilter(fil);
      
      int s = j.showOpenDialog(this);
      if(s == JFileChooser.APPROVE_OPTION){
          String ruta = j.getSelectedFile().getAbsolutePath();
          txtRuta.setText(ruta);
      }
  }//GEN-LAST:event_BtnFotoActionPerformed

  private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
      
      String marca = txtMarca.getText();
      String modelo = txtModelo.getText();
      String estado = txtEstado.getSelectedItem().toString();
      String tipoOferta = txtTipoOferta.getSelectedItem().toString();
      double precio = Double.parseDouble(txtPrecio.getText());
      int kilometros = Integer.parseInt(txtKilometros.getText());
      String cilindrada = txtCilindrada.getText();
      String combustible = txtTipoCombustible.getSelectedItem().toString();
      String cambio = txtTipoCambio.getSelectedItem().toString();
      int anyo = Integer.parseInt(txtAnyoFabricacion.getText());
      double precioSinIva = Double.parseDouble(txtPrecioSinIva.getText());
      String matricula = txtMatricula.getText();
      int unidades = Integer.parseInt(txtUnidades.getText());
      File ruta = new File(txtRuta.getText());
      
      this.agregar(marca, modelo, estado, tipoOferta, precio, kilometros, cilindrada, combustible, cambio, anyo, precioSinIva, matricula,unidades,ruta);
      t.verVehiculos(tabla,filtro.getSelectedItem().toString());
      
  }//GEN-LAST:event_BtnAddActionPerformed

  private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
      int clic = tabla.rowAtPoint(evt.getPoint());
      
      codigo = (int)tabla.getValueAt(clic, 0);
      String marca = ""+tabla.getValueAt(clic, 1);
      String modelo = ""+tabla.getValueAt(clic, 2);
      String estado = ""+tabla.getValueAt(clic, 3);
      String tipoOferta = ""+tabla.getValueAt(clic, 4);
      double precio = (double)tabla.getValueAt(clic, 5);
      int kilometros = (int)tabla.getValueAt(clic, 6);
      String cilindrada = ""+tabla.getValueAt(clic, 7);
      String tipoCombustible = ""+tabla.getValueAt(clic, 8);
      String tipoCambio = ""+tabla.getValueAt(clic, 9);
      int AnyoFabricacion = (int)tabla.getValueAt(clic, 10);
      double precioSinIva = (double)tabla.getValueAt(clic, 11);
      String matricula = ""+tabla.getValueAt(clic, 12);
      int unidades = (int)tabla.getValueAt(clic, 13);
      
      txtc.setText(String.valueOf(codigo));
      System.out.println(txtc);
      txtMarca.setText(marca);
      txtModelo.setText(modelo);
      
      switch(estado) {
	      case "Nuevo": txtEstado.setSelectedIndex(0); break;
	      case "Seminuevo": txtEstado.setSelectedIndex(1); break;
      }
      
      switch(tipoOferta) {
	      case "Venta": txtTipoOferta.setSelectedIndex(0); break;
	      case "Alquiler": txtTipoOferta.setSelectedIndex(1); break;
      }

      txtKilometros.setText(String.valueOf(kilometros));
      txtCilindrada.setText(String.valueOf(cilindrada));
      txtPrecio.setText(String.valueOf(precio));
 
      switch(tipoCombustible) {
	      case "Gasolina:": txtTipoCombustible.setSelectedIndex(0); break;
	      case "Di�sel": txtTipoCombustible.setSelectedIndex(1); break;
	      case "GLP": txtTipoCombustible.setSelectedIndex(2); break;
	      case "El�ctrico": txtTipoCombustible.setSelectedIndex(3); break;
	      case "H�brido": txtTipoCombustible.setSelectedIndex(4); break;
      }

      switch(tipoCambio) {
	      case "Manual": txtTipoCambio.setSelectedIndex(0); break;
	      case "Autom�tico": txtTipoCambio.setSelectedIndex(1); break;
      }

      txtAnyoFabricacion.setText(String.valueOf(AnyoFabricacion));
      txtPrecioSinIva.setText(String.valueOf(precioSinIva));
      txtMatricula.setText(matricula);
      txtUnidades.setText(String.valueOf(unidades));
      txtRuta.setText("");
      
  }//GEN-LAST:event_tablaMouseClicked

  private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
      int id = Integer.parseInt(txtc.getText());
      String marca = txtMarca.getText();
      String modelo = txtModelo.getText();
      String estado = txtEstado.getSelectedItem().toString();
      String tipoOferta = txtTipoOferta.getSelectedItem().toString();
      double precio = Double.parseDouble(txtPrecio.getText());
      int kilometros = Integer.parseInt(txtKilometros.getText());
      String cilindrada = txtCilindrada.getText();
      String tipoCombustible = txtTipoCombustible.getSelectedItem().toString();
      String tipoCambio = txtTipoCambio.getSelectedItem().toString();
      int anyoFabricacion = Integer.parseInt(txtAnyoFabricacion.getText());
      double precioSinIva = Double.parseDouble(txtPrecioSinIva.getText());
      String matricula = txtMatricula.getText();
      int unidades = Integer.parseInt(txtUnidades.getText());
      File ruta = new File(txtRuta.getText());
      
      this.modificar(marca, modelo, estado, tipoOferta, precio, kilometros, cilindrada, tipoCombustible, tipoCambio, anyoFabricacion, precioSinIva, matricula, unidades, ruta, id);
      t.verVehiculos(tabla,filtro.getSelectedItem().toString());
      limpiar();
  }//GEN-LAST:event_BtnEditActionPerformed

  private void BtnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDelActionPerformed
      int id = Integer.parseInt(txtc.getText());
      int a = JOptionPane.showConfirmDialog(null, "Desea eliminar este producto","Mensaje",JOptionPane.OK_CANCEL_OPTION);
      if(a == 0){
          this.eliminar(id);
          limpiar();
      }
      t.verVehiculos(tabla,filtro.getSelectedItem().toString());
  }//GEN-LAST:event_BtnDelActionPerformed

  private void BtnCalcActionPerformed(ActionEvent evt) {
	  double PrecioSinIva = Double.parseDouble(txtPrecio.getText()) - (0.21*Double.parseDouble(txtPrecio.getText()));
	  txtPrecioSinIva.setText(String.valueOf(PrecioSinIva));
  }
  
  public void agregar(String marca, String modelo, String estado, String tipoOferta, double precio, int kilometros, String cilindrada, String combustible, String cambio, int anyo, double precioSinIva, String matricula, int unidades, File ruta){
      Vehiculo v = new Vehiculo();
      dao = new GestorVehiculos();
     
      v.setMarca(marca);
      v.setModelo(modelo);
      v.setEstado(estado);
      v.setTipoOferta(tipoOferta);
      v.setPrecio(precio);
      v.setKilometros(kilometros);
      v.setCilindrada(cilindrada);
      v.setTipoCombustible(combustible);
      v.setTipoCambio(cambio);
      v.setAnyoFabricacion(anyo);
      v.setPrecioSinIva(precioSinIva);
      v.setMatricula(matricula);
      v.setUnidades(unidades);
      
      try{
          byte[] icono = new byte[(int) ruta.length()];
          InputStream input = new FileInputStream(ruta);
          input.read(icono);
          v.setFoto(icono);
      }catch(Exception ex){
          v.setFoto(null);
      }
      dao.addVehiculo(v);
      limpiar();
  }
  
  public void modificar(String marca, String modelo, String estado, String tipoOferta, double precio, int kilometros, String cilindrada, String combustible, String cambio, int anyo, double precioSinIva, String matricula, int unidades, File ruta, int id){
      Vehiculo v = new Vehiculo();
      dao = new GestorVehiculos();
      
      v.setIdVehiculo(id);
      v.setMarca(marca);
      v.setModelo(modelo);
      v.setEstado(estado);
      v.setTipoOferta(tipoOferta);
      v.setPrecio(precio);
      v.setKilometros(kilometros);
      v.setCilindrada(cilindrada);
      v.setTipoCombustible(combustible);
      v.setTipoCambio(cambio);
      v.setAnyoFabricacion(anyo);
      v.setPrecioSinIva(precioSinIva);
      v.setMatricula(matricula);
      v.setUnidades(unidades);
      
      try{
          byte[] icono = new byte[(int) ruta.length()];
          InputStream input = new FileInputStream(ruta);
          input.read(icono);
          v.setFoto(icono);
      }catch(Exception ex){
          v.setFoto(null);
      }
      dao.editVehiculo(v);
  }
   
  public void eliminar(int id){
      Vehiculo v = new Vehiculo();
      dao = new GestorVehiculos();
      
      v.setIdVehiculo(codigo);
      
      dao.delVehiculo(v);
  }
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
     try {
          for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              if ("Nimbus".equals(info.getName())) {
                  javax.swing.UIManager.setLookAndFeel(info.getClassName());
                  break;
              }
          }
      } catch (ClassNotFoundException ex) {
          java.util.logging.Logger.getLogger(VistaGestorVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (InstantiationException ex) {
          java.util.logging.Logger.getLogger(VistaGestorVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
          java.util.logging.Logger.getLogger(VistaGestorVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      } catch (javax.swing.UnsupportedLookAndFeelException ex) {
          java.util.logging.Logger.getLogger(VistaGestorVehiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      }
      //</editor-fold>

      /* Create and display the form */
      java.awt.EventQueue.invokeLater(new Runnable() {
          public void run() {
          	VistaGestorVehiculos v = new VistaGestorVehiculos();
          	v.setVisible(true);

          }
      });
  } 
}
