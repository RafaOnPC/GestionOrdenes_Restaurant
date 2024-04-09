/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import clases.Venta;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USUARIO
 */
public class Tiendita extends javax.swing.JFrame {

    String platos[] = {"Ceviche", "Chilcano", "Leche de Tigre", "Duo Marino", "Trio Marino", "Chicha Morada"};
    double precios[] = {16.00, 7.00, 8.00, 18.50, 23.50, 4.00};
    double precio = 0;
    int cantidad = 0;
    int filaSeleccionada = 0;
    DefaultTableModel modelo = new DefaultTableModel();
    ArrayList<Venta> listaVentas = new ArrayList<Venta>();
    
    
    public Tiendita() {
        initComponents();
        setImagen(btnAdd, "/img/iconoMas.png");
        setComboBox(cbComidas, platos);
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO U.");
        modelo.addColumn("CANTIDAD");
        modelo.addColumn("IMPORTE");
        actualizarTabla();
        calcularPrecio();
    }
    
    private void setImagen(JButton btn, String src){
        ImageIcon imagen = new ImageIcon(getClass().getResource(src));
        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_DEFAULT));
        btn.setIcon(icono);
    }
    
    private void setComboBox(JComboBox cb, String[] lista){
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel(lista);
        cbComidas.setModel(comboModel);
    }
    
    private void calcularPrecio(){
        precio = precios[cbComidas.getSelectedIndex()];
        cantidad = Integer.parseInt(spnCantidad.getValue().toString());
        lbPrecio.setText(monedaNacional(precio));
        lbImporte.setText(monedaNacional(precio*cantidad));
    }
    
    private String monedaNacional(double precio){
        return "S/ " + precio + " soles";
    }
    
    private void actualizarTabla(){
        while(modelo.getRowCount()>0){
            modelo.removeRow(0);
        }
        double subtotal = 0;
        for(Venta v: listaVentas){
            Object x[] = new Object[4];
            x[0]=v.getDesripcion();
            x[1]=monedaNacional(v.getPrecio());
            x[2]=v.getCantidad();
            x[3]=monedaNacional(v.getImporte());
            subtotal+=v.getImporte();
            modelo.addRow(x);
        }
        double total = subtotal;
        lbTotal.setText(monedaNacional(total));
        tableComidas.setModel(modelo);
    }
    
    private void nuevaVenta(){
        precio = 0;
        cantidad = 1;
        cbComidas.setSelectedIndex(0);
        spnCantidad.setValue(1);
        calcularPrecio();
    }
    
    private boolean buscarVenta(Venta vt){
        for(Venta v: listaVentas){
            if(v.getId() == vt.getId()){
                int nuevaCantidad = v.getCantidad() + vt.getCantidad();
                v.setCantidad(nuevaCantidad);
                v.setImporte(v.getPrecio()*nuevaCantidad);
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbComidas = new javax.swing.JComboBox<>();
        spnCantidad = new javax.swing.JSpinner();
        lbTotal = new javax.swing.JTextField();
        lbPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableComidas = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lbImporte = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("CEVICHERIA \"EL SABOR REAL\"");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setText("Cantidad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel3.setText("Importe");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel4.setText("Platillos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel5.setText("Precio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        cbComidas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbComidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbComidasActionPerformed(evt);
            }
        });
        jPanel1.add(cbComidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 160, -1));

        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        spnCantidad.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCantidadStateChanged(evt);
            }
        });
        jPanel1.add(spnCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 160, -1));

        lbTotal.setEditable(false);
        lbTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lbTotalActionPerformed(evt);
            }
        });
        jPanel1.add(lbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 130, -1));

        lbPrecio.setEditable(false);
        lbPrecio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(lbPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 160, -1));

        tableComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableComidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableComidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableComidas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 570, 190));

        jLabel6.setText("Total a Pagar");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 440, 90, 20));

        lbImporte.setEditable(false);
        lbImporte.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jPanel1.add(lbImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 160, -1));

        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 140, 140));

        btnReset.setText("Nueva Orden");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        Venta venta = new Venta();
        venta.setId(cbComidas.getSelectedIndex());
        venta.setDesripcion(cbComidas.getSelectedItem().toString());
        venta.setPrecio(precio);
        venta.setCantidad(cantidad);
        venta.setImporte(precio*cantidad);
        if(!buscarVenta(venta)){
            listaVentas.add(venta);
        }
        actualizarTabla();
        nuevaVenta();
    }//GEN-LAST:event_btnAddActionPerformed

    private void cbComidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbComidasActionPerformed
        calcularPrecio();
    }//GEN-LAST:event_cbComidasActionPerformed

    private void spnCantidadStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCantidadStateChanged
        calcularPrecio();
    }//GEN-LAST:event_spnCantidadStateChanged

    private void lbTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lbTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbTotalActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        precio = 0;
        cantidad = 1;
        cbComidas.setSelectedIndex(0);
        spnCantidad.setValue(1);
        lbTotal.setText(monedaNacional(0));
        modelo.setRowCount(0);
        tableComidas.setModel(modelo);
        listaVentas.clear();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableComidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableComidasMouseClicked
        filaSeleccionada = tableComidas.getSelectedRow(); 
        System.out.println(filaSeleccionada);
    }//GEN-LAST:event_tableComidasMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tiendita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cbComidas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lbImporte;
    private javax.swing.JTextField lbPrecio;
    private javax.swing.JTextField lbTotal;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tableComidas;
    // End of variables declaration//GEN-END:variables
}