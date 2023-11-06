
package AccesoDatos;
import Entidades.Producto;
import Entidades.DetalleCompra;
import Entidades.Compras;
import Entidades.Proveedor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 *
 * @author elihe
 */
public class DetalleCompraData {
    private Connection con = null;
    
 public DetalleCompraData(){   
  con=Conexion.getConexion();
 } 
public void detalleDeCompra(DetalleCompra detallecompra){  
     String sql = "INSERT INTO detallecompra(idDetalle, cantidad, precioCosto, idCompra, idProducto)"
             + "VALUE(?,?,?,?,?)";
     
     try { 
        PreparedStatement ps  = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1, detallecompra.getIdDetalle());
        ps.setInt(2, detallecompra.getCantidad());
        ps.setDouble(3, detallecompra.getPrecioCostos());
        ps.setInt(4, detallecompra.getCompras().getIdCompra());
        ps.setInt(5, detallecompra.getProducto().getIdProducto());
        ps.executeUpdate();
           
        ResultSet rs =ps.getGeneratedKeys();
        
         if (rs.next()) {
             detallecompra.setIdDetalle(rs.getInt(1));
             JOptionPane.showMessageDialog(null, "Detalles de compra REGISTRADOS");
         }
        ps.close();
         
        
     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error Al Registrar DETALLES DE COMPRA");
     }
   }
     
}

