
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
public void registrardetalleDeCompra(DetalleCompra detallecompra){  
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
  public List<DetalleCompra> obtenerProductoPorCodigo(int idCompra){
        
        ArrayList<DetalleCompra> detalles=new ArrayList<>();
        
        String sql="SELECT producto.idProducto, producto.nombreProducto, cantidad, precioCosto FROM detallecompra JOIN producto ON (detallecompra.idProducto = producto.idProducto) WHERE idCompra = 1;";
        
        try{
        PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1, idCompra);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            
            DetalleCompra dcompra = new DetalleCompra();
            
            dcompra.setCantidad(rs.getInt("cantidad"));
            dcompra.setPrecioCostos(rs.getInt("precioCosto"));
            
                        
            Producto prod= new Producto();
            prod.setIdProducto(rs.getInt("idProducto"));
            prod.setNombreProducto(rs.getString("nombreProducto"));
            dcompra.setProducto(prod);
            
            Compras com=new Compras();
            com.setIdCompra(rs.getInt("idCompra"));
            dcompra.setCompras(com);
                  
            
            detalles.add(dcompra);
            
        }
        ps.close();
        
        
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA DETALLECOMPRA");
                }
        return detalles;   
}
}

