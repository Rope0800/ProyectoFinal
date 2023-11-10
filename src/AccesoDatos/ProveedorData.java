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

public class ProveedorData {
    private Connection con = null;
    
 public ProveedorData(){   
  con=Conexion.getConexion();
 }
 

    public void agregarProveedor(Proveedor proveedor){  
     String sql = "INSERT INTO proveedor( razonSocial, domicilio, telefono, idProducto)"
             + "VALUE(?,?,?,?)";
     
     try { 
        PreparedStatement ps  = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setString(1, proveedor.getRazonSocial());
        ps.setString(2, proveedor.getDomicilio());
        ps.setInt(3, proveedor.getTelefono());
        ps.setInt(4, proveedor.getProducto().getIdProducto());
        ps.executeUpdate();
           
        ResultSet rs =ps.getGeneratedKeys();
        
         if (rs.next()) {
             proveedor.setIdProveedor(rs.getInt(1));
             JOptionPane.showMessageDialog(null, "Proveedor Agregado");
         }
        ps.close();
         
        
     } catch (SQLException e) {
         JOptionPane.showMessageDialog(null, "Error Al Agregar Proveedor");
     }
   }

    public void eliminarProveedor (int id){
     String sql="DELETE FROM proveedor WHERE idProveedor = ?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Proveedor ELIMINADO");
            } 
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL eliminar Proveedor");
        }
     
 }
    
    public void actualizarProveedor(Proveedor proveedor) {
     String sql="UPDATE proveedor SET razonSocial = ?, domicilio = ?, telefono = ?, idProducto = ? "
             + "WHERE idProveedor = ?";
     
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1, proveedor.getRazonSocial());
            ps.setString(2, proveedor.getDomicilio());
            ps.setInt(3, proveedor.getTelefono());
            ps.setInt(4, proveedor.getProducto().getIdProducto());
            ps.setInt(5, proveedor.getIdProveedor());
            int exito = ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Proveedor Actualizado");
            }
            ps.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "ERROR al actualizar el Proveedor");
        }
    }
 public Proveedor buscarProveedor(int id){
     String sql="SELECT razonSocial, domicilio, telefono, idProducto FROM proveedor WHERE idProveedor = ? ";
     Proveedor proveedor=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next()){
                proveedor= new Proveedor(); 
                proveedor.setIdProveedor(id);
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getInt("telefono"));
                
                Producto prod= new Producto();
                prod.setIdProducto(rs.getInt("idProducto"));
                proveedor.setProducto(prod);
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe el proveedor");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al buscar el proveedor");
        }
        return proveedor;
}
    
public List<Proveedor> listarProveedores(){
     String sql="SELECT * FROM proveedor";
     ArrayList<Proveedor> proveedores=new ArrayList<>();
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Proveedor proveedor=new Proveedor();
               proveedor.setIdProveedor(rs.getInt("idProveedor"));
               proveedor.setRazonSocial(rs.getString("razonSocial"));
               proveedor.setDomicilio(rs.getString("domicilio"));
               proveedor.setTelefono(rs.getInt("telefono"));
              
               Producto prod= new Producto();
               prod.setIdProducto(rs.getInt("idProducto"));
               proveedor.setProducto(prod);
                        
               proveedores.add(proveedor);
            
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al listar Proveedores");
        }
        return proveedores;
 }   
}