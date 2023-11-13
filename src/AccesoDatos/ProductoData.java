
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

public class ProductoData {
    private Connection con = null;
    
 public ProductoData(){   
  con=Conexion.getConexion();
 }
 
    
    
    public void resgistrarProducto(Producto producto){  
     String sql = "INSERT INTO producto(nombreProducto, descripcion, precioActual, stock, estado)"
             + "VALUE(?,?,?,?,?)";
     
     try { 
        PreparedStatement ps  = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, producto.getNombreProducto());
        ps.setString(2, producto.getDescripcion());
        ps.setDouble(3, producto.getPrecioActual());
        ps.setInt(4, producto.getStock());
        ps.setBoolean(5, producto.isEstado());
        ps.executeUpdate();
           
        ResultSet rs =ps.getGeneratedKeys();
        
         if (rs.next()) {
             producto.setIdProducto(rs.getInt(1));
             JOptionPane.showMessageDialog(null, "Producto Registrado");
         }
        ps.close();
         
        
     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error Al Registrar El Producto");
     }
   }
  public void modificarProducto(Producto producto){
     String sql="UPDATE producto SET nombreProducto = ?, descripcion = ?, precioActual = ?, stock = ?, estado = ? "
             + "WHERE idProducto = ?";
     
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getPrecioActual());
            ps.setInt(4,producto.getStock());
            ps.setBoolean(5, producto.isEstado());
            int exito = ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Producto modificado");
            }
            ps.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "ERROR al modificar el producto");
        }  
}
  public void eliminarProducto (int id){
     String sql="DELETE FROM producto  WHERE idProducto = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Producto eliminado");
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al eliminar producto");
        }
}
  public Producto buscarProducto(int id){
     String sql="SELECT nombreProducto, descripcion, precioActual, stock, estado FROM producto WHERE idProducto = ? AND estado = 1";
     Producto producto=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next()){
                producto= new Producto(); 
                producto.setIdProducto(id);
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getInt("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null, "No existe el producto");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al buscar el producto");
        }
        return producto;
 }
 
  public List<Producto> listarProductos(){
     String sql="SELECT * FROM producto WHERE estado = 1";
     ArrayList<Producto> productos=new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Producto producto=new Producto();
               producto.setIdProducto(rs.getInt("idProducto"));
               producto.setNombreProducto(rs.getString("nombreProducto"));
               producto.setDescripcion(rs.getString("descripcion"));
               producto.setPrecioActual(rs.getInt("precioActual"));
               producto.setStock(rs.getInt("stock"));
               producto.setEstado(rs.getBoolean("estado"));
               productos.add(producto);
            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al listar Productos");
        }
        return productos;
 }
}
