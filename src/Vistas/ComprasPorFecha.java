
package Vistas;

import AccesoDatos.ComprasData;
import AccesoDatos.DetalleCompraData;
import Entidades.Compras;
import Entidades.Proveedor;
import Entidades.Producto;
import Entidades.DetalleCompra;
import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author elihe
 */
public class ComprasPorFecha extends javax.swing.JInternalFrame {
   private DefaultTableModel modelo;
    private List<DetalleCompra> listaDC;
    private List<Compras> listaC;
    
    private DetalleCompraData dcompraData;
    private ComprasData compraData;
   
    public ComprasPorFecha() {
        initComponents();
        modelo = new DefaultTableModel();
        armarCabeceraTabla();
        dcompraData = new DetalleCompraData();
        compraData = new ComprasData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabla = new javax.swing.JTable();
        JRBfecha = new javax.swing.JRadioButton();
        JRBdosfechas = new javax.swing.JRadioButton();
        JRBcodigo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        JTcodigo = new javax.swing.JTextField();
        JBbuscar = new javax.swing.JButton();
        JBsalir = new javax.swing.JButton();
        JDCporfecha = new com.toedter.calendar.JDateChooser();
        JDCfecha1 = new com.toedter.calendar.JDateChooser();
        JDCfecha2 = new com.toedter.calendar.JDateChooser();
        JTlimpiar = new javax.swing.JButton();

        jLabel1.setText("♦ BUSQUEDA POR ♦");

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

        JRBfecha.setText("Por fecha:");
        JRBfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBfechaActionPerformed(evt);
            }
        });

        JRBdosfechas.setText("Entre dos fechas:");
        JRBdosfechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBdosfechasActionPerformed(evt);
            }
        });

        JRBcodigo.setText("Por código de compra:");
        JRBcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRBcodigoActionPerformed(evt);
            }
        });

        jLabel2.setText("♦ Elija una opción:");

        JTcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTcodigoActionPerformed(evt);
            }
        });

        JBbuscar.setText("Buscar");
        JBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBbuscarActionPerformed(evt);
            }
        });

        JBsalir.setText("Salir");
        JBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBsalirActionPerformed(evt);
            }
        });

        JDCporfecha.setDateFormatString("yyyy-MM-dd");

        JDCfecha1.setDateFormatString("yyyy-MM-dd");

        JDCfecha2.setDateFormatString("yyyy-MM-dd");

        JTlimpiar.setText("Limpiar");
        JTlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(191, 191, 191))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(JRBcodigo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(JTcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(JBbuscar)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(JRBdosfechas)
                                                .addComponent(JRBfecha))
                                            .addGap(26, 26, 26)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(JDCfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(JDCfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(JDCporfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(JTlimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JDCporfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JRBfecha)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JRBdosfechas)
                            .addComponent(JDCfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JRBcodigo)
                            .addComponent(JTcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(JDCfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(JBbuscar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JBsalir)
                    .addComponent(JTlimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_JBsalirActionPerformed

    private void JRBfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBfechaActionPerformed
        // TODO add your handling code here:
        JRBcodigo.setEnabled(false);
        JRBdosfechas.setEnabled(false);
    }//GEN-LAST:event_JRBfechaActionPerformed

    private void JRBdosfechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBdosfechasActionPerformed
        // TODO add your handling code here:
        JRBcodigo.setEnabled(false);
        JRBfecha.setEnabled(false);
    }//GEN-LAST:event_JRBdosfechasActionPerformed

    private void JTcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTcodigoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JTcodigoActionPerformed

    private void JBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBbuscarActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        if (JRBcodigo.isSelected()){
            borrarFilaTabla();
        Integer codigo=Integer.parseInt(JTcodigo.getText());
        listaDC = (ArrayList) dcompraData.obtenerProductoPorCodigo(codigo);
        for(DetalleCompra dc: listaDC){
            modelo.addRow(new Object[]{dc.getProducto().getIdProducto(),dc.getProducto().getNombreProducto(), dc.getProducto().getDescripcion()});
        }
        }else if(JRBfecha.isSelected()){
            borrarFilaTabla();
        java.util.Date sfecha=JDCporfecha.getDate();
        LocalDate fecha=sfecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        listaDC = (ArrayList) dcompraData.obtenerProductosPorFecha(fecha);
        for (DetalleCompra c : listaDC) {
         modelo.addRow(new Object[]{c.getProducto().getIdProducto(),c.getProducto().getNombreProducto(),c.getProducto().getDescripcion()});
  
}
        }else if(JRBdosfechas.isSelected()){
            borrarFilaTabla();
        java.util.Date sfecha=JDCfecha1.getDate();
        java.util.Date sfecha2=JDCfecha2.getDate();
        LocalDate fecha1=sfecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate fecha2=sfecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        listaDC = (ArrayList) dcompraData.obtenerProductosEntreFechas(fecha1, fecha2);
        for (DetalleCompra c : listaDC) {
         modelo.addRow(new Object[]{c.getProducto().getIdProducto(),c.getProducto().getNombreProducto(),c.getProducto().getDescripcion()});
        }
        }

    }//GEN-LAST:event_JBbuscarActionPerformed

    private void JRBcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRBcodigoActionPerformed
        // TODO add your handling code here:
        JRBfecha.setEnabled(false);
        JRBdosfechas.setEnabled(false);
    }//GEN-LAST:event_JRBcodigoActionPerformed

    private void JTlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTlimpiarActionPerformed
        // TODO add your handling code here:
        borrarFilaTabla();
        JRBcodigo.setEnabled(true);
        JRBfecha.setEnabled(true);
        JRBdosfechas.setEnabled(true);
    }//GEN-LAST:event_JTlimpiarActionPerformed
    private void armarCabeceraTabla(){
      ArrayList<Object> filaCabecera = new ArrayList<>();
      
      filaCabecera.add("ID PRODUCTO");
      filaCabecera.add("NOMBRE");
      filaCabecera.add("DESCRIPCION");
      for(Object it:filaCabecera){
          modelo.addColumn(it);
      }
      JTabla.setModel(modelo);
    }
    private void borrarFilaTabla(){
     int indice = modelo.getRowCount()-1;
     
     for(int i= indice;i>=0;i--){
         modelo.removeRow(i);
     }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBbuscar;
    private javax.swing.JButton JBsalir;
    private com.toedter.calendar.JDateChooser JDCfecha1;
    private com.toedter.calendar.JDateChooser JDCfecha2;
    private com.toedter.calendar.JDateChooser JDCporfecha;
    private javax.swing.JRadioButton JRBcodigo;
    private javax.swing.JRadioButton JRBdosfechas;
    private javax.swing.JRadioButton JRBfecha;
    private javax.swing.JTable JTabla;
    private javax.swing.JTextField JTcodigo;
    private javax.swing.JButton JTlimpiar;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
