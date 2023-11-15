/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoDatos.ComprasData;
import AccesoDatos.DetalleCompraData;
import AccesoDatos.ProductoData;
import AccesoDatos.ProveedorData;
import Entidades.Compras;
import Entidades.DetalleCompra;
import Entidades.Producto;
import Entidades.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elihe
 */
public class ProveedoresPorProductos extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    private List<Proveedor> listaProv;
    private List<Compras> listaComp;
    private List<Producto> listaProd;
    private List<DetalleCompra> listaDC;
    
    private ProveedorData provData;
    private ComprasData comprasData;
    private ProductoData prodData;
    private DetalleCompraData dcompraData;
    

    /**
     * Creates new form ComprasPorProveedor
     */
    public ProveedoresPorProductos() {
        initComponents();
        modelo = new DefaultTableModel();
        armarCabeceraTabla();
        prodData = new ProductoData();
        provData= new ProveedorData();
        comprasData= new ComprasData();
        dcompraData = new DetalleCompraData();
        listaProd = prodData.listarProductos();
        cargaProveedores();
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
        JCBproductos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabla = new javax.swing.JTable();
        JBsalir = new javax.swing.JButton();

        JLcompras.setText("PRODUCTO POR PROVEEDOR");

        JCBproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCBproductosActionPerformed(evt);
            }
        });

        JTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(JTabla);

        JBsalir.setText("Salir");
        JBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JLcompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JCBproductos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(115, 115, 115))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JBsalir)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLcompras)
                .addGap(18, 18, 18)
                .addComponent(JCBproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(JBsalir)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JCBproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCBproductosActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
       Producto selec = (Producto)JCBproductos.getSelectedItem();
        listaDC = (ArrayList) dcompraData.obtenerProveedorPorProducto(selec.getIdProducto());
        for(DetalleCompra dc: listaDC){
            modelo.addRow(new Object[]{dc.getCompras().getProveedor().getIdProveedor(),dc.getCompras().getProveedor().getRazonSocial(),dc.getCompras().getProveedor().getDomicilio()});
        }
    }//GEN-LAST:event_JCBproductosActionPerformed

    private void JBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_JBsalirActionPerformed

private void armarCabeceraTabla(){
      ArrayList<Object> filaCabecera = new ArrayList<>();
      filaCabecera.add("ID PROVEEDOR");
      filaCabecera.add("RAZON SOCIAL");
      filaCabecera.add("DOMICILIO");
      
      for(Object it:filaCabecera){
          modelo.addColumn(it);
      }
      JTabla.setModel(modelo);
      
    }
private void cargaProveedores(){
        for(Producto item: listaProd){
            JCBproductos.addItem(item);
        }
    }
private void borrarFilaTabla(){
     int indice = modelo.getRowCount()-1;
     
     for(int i= indice;i>=0;i--){
         modelo.removeRow(i);
     }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBsalir;
    private javax.swing.JComboBox<Producto> JCBproductos;
    private javax.swing.JLabel JLcompras;
    private javax.swing.JTable JTabla;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}