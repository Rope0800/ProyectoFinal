package AccesoDatos;
import Entidades.Producto;
import Entidades.DetalleCompra;
import Entidades.Compras;
import Entidades.Proveedor;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ComprasData {
    private Connection con = null;
    private ProveedorData pd=new ProveedorData();
    
 public ComprasData(){   
  con=Conexion.getConexion();
 }
 

    public void registrarComprasProveedores(Compras compras){  
     String sql = "INSERT INTO compras(idCompra, idProveedor, fecha_compra )"
             + "VALUE(?,?,?)";
     
     try { 
        PreparedStatement ps  = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1, compras.getIdCompra());
        ps.setInt(2, compras.getProveedor().getIdProveedor());
        ps.setDate(3, Date.valueOf(compras.getFecha_compra()));
        ps.executeUpdate();
           
        ResultSet rs =ps.getGeneratedKeys();
        
         if (rs.next()) {
             compras.setIdCompra(rs.getInt(1));
             JOptionPane.showMessageDialog(null, "Compra Registrada");
         }
        ps.close();
         
        
     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error al Registrar la compra");
     }
   }
    
    
    
}
    