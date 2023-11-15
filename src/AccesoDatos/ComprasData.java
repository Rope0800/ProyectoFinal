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
    public Compras buscarCompras(int id){
     String sql="SELECT * FROM compras WHERE idCompra = ?";
     Compras compras=null;
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            if(rs.next()){
                compras = new Compras();
                compras.setIdCompra(id);
                int idProveedor = rs.getInt("idProveedor");
                Proveedor proveedor = pd.buscarProveedor(idProveedor);
                compras.setProveedor(proveedor);                      
                compras.setFecha_compra(rs.getDate("fecha_compra").toLocalDate());
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe la compra");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al buscar la compra");
        }
        return compras;
 }
 
  
    
    public List<Compras> obtenerComprasPorProveedor(int idProveedor){
        
        ArrayList<Compras> comprasprov=new ArrayList<>();
        
        String sql="SELECT * FROM `compras` WHERE idProveedor = ?";
        
        try{
        PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1, idProveedor);
        ResultSet rs=ps.executeQuery();
        
        while(rs.next()){
            
            Compras comp=new Compras();
            comp.setIdCompra(rs.getInt("idCompra"));
//            comp.setFecha_compra(rs.getDate("fecha_compra").toLocalDate());
            
            Proveedor prov= new Proveedor();
            prov.setIdProveedor(rs.getInt("idProveedor"));
            comp.setProveedor(prov);
           
            comprasprov.add(comp);
            
        }
        ps.close();
        
        
        }catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A COMPRAS");
                }
        return comprasprov;
        
        
    }
    public List<Compras> obtenerProductosPorProeveedor(LocalDate fecha_compra){
        
        ArrayList<Compras> compras=new ArrayList<>();
        
        String sql ="SELECT compras.idCompra, producto.nombreProducto, producto.descripcion FROM compras INNER JOIN detallecompra ON compras.idCompra= detallecompra.idCompra INNER JOIN producto ON detallecompra.idProducto WHERE compras.fecha_compra = ?";
            try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha_compra));
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                
                Compras compra = new Compras();
                compra.setIdCompra(rs.getInt("idCompra"));
                
                Producto prod = new Producto();
                
                prod.setNombreProducto(rs.getString("nombreProducto"));
                prod.setDescripcion(rs.getString("descripcion"));
                
                DetalleCompra dcompra= new DetalleCompra();
                  dcompra.setCompras(compra);
                  dcompra.setProducto(prod);
                
                
                  compras.add(compra);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL ACCEDER A LA TABLA COMPRAS");
        }
        return compras;
    }
}
   
   