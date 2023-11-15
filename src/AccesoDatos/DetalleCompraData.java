
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
        
        String sql="SELECT  producto.idProducto, producto.nombreProducto, producto.descripcion FROM detallecompra JOIN producto ON (detallecompra.idProducto = producto.idProducto) WHERE idCompra = ?;";
        
        try{
        PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1, idCompra);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            
            DetalleCompra dcompra= new DetalleCompra();
            Compras cmp= new Compras();
           
            
                    
                        
            Producto prod= new Producto();
            prod.setIdProducto(rs.getInt("idProducto"));
            prod.setNombreProducto(rs.getString("nombreProducto"));
            prod.setDescripcion(rs.getString("descripcion"));
            dcompra.setProducto(prod);
            
                    
            
            detalles.add(dcompra);
            
        }
        ps.close();
        
        
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA DETALLECOMPRA");
                }
        return detalles;   
}
  public List<DetalleCompra> obtenerProveedorPorProducto(int idProducto){
        
        ArrayList<DetalleCompra> detalles=new ArrayList<>();
        
        String sql="SELECT proveedor.idProveedor, proveedor.razonSocial, proveedor.domicilio FROM detallecompra INNER JOIN compras ON detallecompra.idCompra= compras.idCompra INNER JOIN proveedor ON compras.idproveedor WHERE detallecompra.idProducto = ?";
        
        try{
        PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1, idProducto);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            
            DetalleCompra dcompra= new DetalleCompra();
            Compras cmp= new Compras();
             
            Proveedor prov= new Proveedor();
            prov.setIdProveedor(rs.getInt("idProveedor"));
            prov.setRazonSocial(rs.getString("razonsocial"));
            prov.setDomicilio(rs.getString("Domicilio"));
            
            cmp.setProveedor(prov);
            dcompra.setCompras(cmp);
            
                    
            
            detalles.add(dcompra);
            
        }
        ps.close();
        
        
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA DETALLECOMPRA");
                }
        return detalles;   
}
}

