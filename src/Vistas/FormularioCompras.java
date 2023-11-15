/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.ProductoData;
import AccesoDatos.ProveedorData;
import AccesoDatos.ComprasData;
import AccesoDatos.DetalleCompraData;
import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.Compras;
import Entidades.DetalleCompra;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elihe
 */
public class FormularioCompras extends javax.swing.JInternalFrame {
    private List<Producto> listaProd;
    private List<Proveedor> listaProv;
    
    private ProveedorData provData;
    private ProductoData prodData;
    private ComprasData compraData;
    private DetalleCompraData detalleData;
    private Compras compraActual=null;
    private Compras cdetalleActual=null;
    
    

    
    public FormularioCompras() {
        initComponents();
         provData = new ProveedorData();
         prodData = new ProductoData();
         compraData = new ComprasData();
         detalleData = new DetalleCompraData();
         listaProv = provData.listarProveedores();
         listaProd = prodData.listarProductos();
         
        cargaProveedores();
        cargaProductos();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLcompras = new javax.swing.JLabel();
        JBagregar = new javax.swing.JButton();
        JBnuevo = new javax.swing.JButton();
        JBguardar = new javax.swing.JButton();
        JBsalir = new javax.swing.JButton();
        JLproveedor = new javax.swing.JLabel();
        JLfecha = new javax.swing.JLabel();
        JLdetalle = new javax.swing.JLabel();
        JCBproveedor = new javax.swing.JComboBox<>();
        JTcodigo = new javax.swing.JTextField();
        JLcodigo = new javax.swing.JLabel();
        JLcantidad = new javax.swing.JLabel();
        JTcantidad = new javax.swing.JTextField();
        JLprecio = new javax.swing.JLabel();
        JTprecio = new javax.swing.JTextField();
        JCBproductos = new javax.swing.JComboBox<>();
        JLproducto = new javax.swing.JLabel();
        jDateCfecha = new com.toedter.calendar.JDateChooser();

        JLcompras.setText("REGISTRAR COMPRAS");

        JBagregar.setText("Agregar");
        JBagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBagregarActionPerformed(evt);
            }
        });

        JBnuevo.setText("Limpiar");
        JBnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBnuevoActionPerformed(evt);
            }
        });

        JBguardar.setText("Guardar Compra");
        JBguardar.setEnabled(false);
        JBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBguardarActionPerformed(evt);
            }
        });

        JBsalir.setText("Salir");
        JBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBsalirActionPerformed(evt);
            }
        });

        JLproveedor.setText("Proveedor:");

        JLfecha.setText("Fecha:");

        JLdetalle.setText("DETALLE DE COMPRA");
        JLdetalle.setEnabled(false);

        JCBproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBproveedorActionPerformed(evt);
            }
        });

        JTcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTcodigoActionPerformed(evt);
            }
        });

        JLcodigo.setText("Código de compra:");

        JLcantidad.setText("Cantidad:");
        JLcantidad.setEnabled(false);

        JTcantidad.setEditable(false);
        JTcantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTcantidadActionPerformed(evt);
            }
        });

        JLprecio.setText("Precio de costo:");
        JLprecio.setEnabled(false);

        JTprecio.setEditable(false);

        JCBproductos.setEnabled(false);
        JCBproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBproductosActionPerformed(evt);
            }
        });

        JLproducto.setText("Producto:");
        JLproducto.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(JBagregar)
                        .addContainerGap(225, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(JLfecha)
                                .addGap(88, 88, 88)
                                .addComponent(jDateCfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLcodigo)
                                    .addComponent(JLprecio)
                                    .addComponent(JLcantidad)
                                    .addComponent(JLproducto)
                                    .addComponent(JLproveedor))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLdetalle)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(JLcompras)
                                        .addComponent(JTcantidad)
                                        .addComponent(JTprecio)
                                        .addComponent(JCBproductos, 0, 165, Short.MAX_VALUE)
                                        .addComponent(JCBproveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(JTcodigo)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(JBnuevo)
                .addGap(108, 108, 108)
                .addComponent(JBguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JBsalir)
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLcompras)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLcodigo))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JCBproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLproveedor))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLfecha)
                    .addComponent(jDateCfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(JBagregar)
                .addGap(24, 24, 24)
                .addComponent(JLdetalle)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLcantidad)
                    .addComponent(JTcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLprecio)
                    .addComponent(JTprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JCBproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(JLproducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBnuevo)
                    .addComponent(JBguardar)
                    .addComponent(JBsalir)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_JBsalirActionPerformed

    private void JBagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBagregarActionPerformed
        // TODO add your handling code here:
        Integer codigo=Integer.parseInt(JTcodigo.getText());
        Proveedor selec=(Proveedor)JCBproveedor.getSelectedItem();
        java.util.Date sfecha=jDateCfecha.getDate();
        LocalDate fecha=sfecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(codigo!=1){
            
            Compras compraActual =new Compras(codigo,selec,fecha);
            compraData.registrarComprasProveedores(compraActual);
        } 
        JBguardar.setEnabled(true);
        JLdetalle.setEnabled(true);
        JLcantidad.setEnabled(true);
        JTcantidad.setEditable(true);
        JLprecio.setEnabled(true);
        JTprecio.setEditable(true);
        JCBproductos.setEnabled(true);
        JLproducto.setEnabled(true);
    }//GEN-LAST:event_JBagregarActionPerformed

    private void JCBproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBproveedorActionPerformed

    private void JTcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTcodigoActionPerformed

    private void JTcantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTcantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTcantidadActionPerformed

    private void JCBproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBproductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCBproductosActionPerformed

    private void JBnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBnuevoActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
        JBguardar.setEnabled(false);
        JLdetalle.setEnabled(false);
        JLcantidad.setEnabled(false);
        JTcantidad.setEditable(false);
        JLprecio.setEnabled(false);
        JTprecio.setEditable(false);
        JCBproductos.setEnabled(false);
        JLproducto.setEnabled(false);
        
    }//GEN-LAST:event_JBnuevoActionPerformed

    private void JBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBguardarActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.parseInt(JTcodigo.getText());
        int cantidad = Integer.parseInt(JTcantidad.getText());
        int precio = Integer.parseInt(JTprecio.getText());
        Producto selec = (Producto) JCBproductos.getSelectedItem();
          Compras compras = compraData.buscarCompras(codigo);


    if (compras != null && compras.getIdCompra()!= 1) {
        DetalleCompra cdetalleActual = new DetalleCompra(cantidad, precio, compras, selec);
        detalleData.registrardetalleDeCompra(cdetalleActual);
              
        }   
    }//GEN-LAST:event_JBguardarActionPerformed
    private void cargaProveedores(){
        for(Proveedor item: listaProv){
            JCBproveedor.addItem(item);
        }
    }
    private void cargaProductos(){
        for(Producto item: listaProd){
            JCBproductos.addItem(item);
        }
    }
    private void limpiarCampos(){
        JTcodigo.setText("");
        jDateCfecha.setDate(new Date());
        JTcantidad.setText("");
        JTprecio.setText("");
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBagregar;
    private javax.swing.JButton JBguardar;
    private javax.swing.JButton JBnuevo;
    private javax.swing.JButton JBsalir;
    private javax.swing.JComboBox<Producto> JCBproductos;
    private javax.swing.JComboBox<Proveedor> JCBproveedor;
    private javax.swing.JLabel JLcantidad;
    private javax.swing.JLabel JLcodigo;
    private javax.swing.JLabel JLcompras;
    private javax.swing.JLabel JLdetalle;
    private javax.swing.JLabel JLfecha;
    private javax.swing.JLabel JLprecio;
    private javax.swing.JLabel JLproducto;
    private javax.swing.JLabel JLproveedor;
    private javax.swing.JTextField JTcantidad;
    private javax.swing.JTextField JTcodigo;
    private javax.swing.JTextField JTprecio;
    private com.toedter.calendar.JDateChooser jDateCfecha;
    // End of variables declaration//GEN-END:variables
}
