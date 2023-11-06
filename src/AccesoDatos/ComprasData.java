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

public class ComprasData {
    private Connection con = null;
    
 public ComprasData(){   
  con=Conexion.getConexion();
 }
 

    public void registrarComprasProveedores(Compras compras){  
     String sql = "INSERT INTO compras(idCompra, fecha_compra )"
             + "VALUE(?,?)";
     
     try { 
        PreparedStatement ps  = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        
        ps.setInt(1, compras.getIdCompra());
        ps.setDate(2, Date.valueOf(compras.getFecha_compra()));
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
    
    
public List<Compras> obtenerComprasPorProveedor(int idProveedor){
        
        ArrayList<Compras> compras=new ArrayList<>();
        
        String sql="SELECT idCompra, idProveedor FROM compras JOIN ... WHERE idProveedor = ?";
        
        try{
        PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1, idProveedor);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            
            Compras compra=new Compras();
            compra.setIdCompra(rs.getInt("idCompra"));
            compra.setFecha_compra(rs.getDate("fecha_compra").toLocalDate());
            
            Proveedor prov= new Proveedor();
            prov.setIdProveedor(rs.getInt("idProveedor"));
            compra.setProveedor(prov);
            
            compras.add(compra);
            
                       
        }
        ps.close();
        
        
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR al acceder a Compras");
                }
        return compras;
        
    }
    
}