/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Color;

/**
 *
 * @author elihe
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMproducto = new javax.swing.JMenu();
        JMIproducto = new javax.swing.JMenuItem();
        JMproveedores = new javax.swing.JMenu();
        JMIproveedor = new javax.swing.JMenuItem();
        JMcompras = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        JMconsultas = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        JMcomprasxprov = new javax.swing.JMenuItem();
        JMprovporproducto = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        JMsalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        JMproducto.setText("Productos");

        JMIproducto.setText("Formulario de Producto");
        JMIproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIproductoActionPerformed(evt);
            }
        });
        JMproducto.add(JMIproducto);

        jMenuBar1.add(JMproducto);

        JMproveedores.setText("Proveedores");

        JMIproveedor.setText("Formulario de Proveedor");
        JMIproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMIproveedorActionPerformed(evt);
            }
        });
        JMproveedores.add(JMIproveedor);

        jMenuBar1.add(JMproveedores);

        JMcompras.setText("Compras");

        jMenuItem1.setText("Administrar compras");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMcompras.add(jMenuItem1);

        jMenuBar1.add(JMcompras);

        JMconsultas.setText("Consultas");

        jMenuItem2.setText("Compras por fecha");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        JMconsultas.add(jMenuItem2);

        JMcomprasxprov.setText("Compras por Proveedor");
        JMcomprasxprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMcomprasxprovActionPerformed(evt);
            }
        });
        JMconsultas.add(JMcomprasxprov);

        JMprovporproducto.setText("Proveedores por Producto");
        JMprovporproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMprovporproductoActionPerformed(evt);
            }
        });
        JMconsultas.add(JMprovporproducto);

        jMenuItem4.setText("Stock");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        JMconsultas.add(jMenuItem4);

        jMenuBar1.add(JMconsultas);

        JMsalir.setText("Salir");
        JMsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMsalirActionPerformed(evt);
            }
        });
        jMenuBar1.add(JMsalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMIproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIproductoActionPerformed
        // TODO add your handling code here:
         escritorio.removeAll();
         escritorio.repaint();
         FormularioProductos producto = new FormularioProductos();
         producto.setVisible(true);
         producto.getContentPane().setBackground(new Color(68, 167, 132));
         escritorio.add(producto);
    }//GEN-LAST:event_JMIproductoActionPerformed

    private void JMsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_JMsalirActionPerformed

    private void JMIproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMIproveedorActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
         escritorio.repaint();
         FormularioProveedor proveedor = new FormularioProveedor();
         proveedor.setVisible(true);
         proveedor.getContentPane().setBackground(new Color(68, 167, 132));
         escritorio.add(proveedor);
    }//GEN-LAST:event_JMIproveedorActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
         escritorio.removeAll();
         escritorio.repaint();
         FormularioCompras compras = new FormularioCompras();
         compras.setVisible(true);
         compras.getContentPane().setBackground(new Color(68, 167, 132));
         escritorio.add(compras); 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void JMcomprasxprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMcomprasxprovActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        ComprasPorProveedor compras = new ComprasPorProveedor();
        compras.setVisible(true);
        compras.getContentPane().setBackground(new Color(68, 167, 132));
        escritorio.add(compras);
    }//GEN-LAST:event_JMcomprasxprovActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        Stock stock = new Stock();
        stock.setVisible(true);
        stock.getContentPane().setBackground(new Color(68, 167, 132));
        escritorio.add(stock); 
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        ComprasPorFecha comporfecha = new ComprasPorFecha();
        comporfecha.setVisible(true);
        comporfecha.getContentPane().setBackground(new Color(68, 167, 132));
        escritorio.add(comporfecha); 
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void JMprovporproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMprovporproductoActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        ProveedoresPorProductos proxprod = new ProveedoresPorProductos();
        proxprod.setVisible(true);
        proxprod.getContentPane().setBackground(new Color(68, 167, 132));
        escritorio.add(proxprod);
    }//GEN-LAST:event_JMprovporproductoActionPerformed

  
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-foldescritorio="collapsed" desc=" Look and feel setting code (optional) ">
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMIproducto;
    private javax.swing.JMenuItem JMIproveedor;
    private javax.swing.JMenu JMcompras;
    private javax.swing.JMenuItem JMcomprasxprov;
    private javax.swing.JMenu JMconsultas;
    private javax.swing.JMenu JMproducto;
    private javax.swing.JMenu JMproveedores;
    private javax.swing.JMenuItem JMprovporproducto;
    private javax.swing.JMenu JMsalir;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    // End of variables declaration//GEN-END:variables
}
