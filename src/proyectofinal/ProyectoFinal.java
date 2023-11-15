
package proyectofinal;

import AccesoDatos.ProductoData;
import AccesoDatos.ProveedorData;
import AccesoDatos.DetalleCompraData;
import AccesoDatos.ComprasData;
import Entidades.Compras;
import Entidades.Producto;
import Entidades.Proveedor;
import Entidades.DetalleCompra;
import java.sql.*;
import java.time.LocalDate;
import java.util.Date;


public class ProyectoFinal {

   
    public static void main(String[] args) {
        
        
        
        //-----PRUEBAS DEL MAIN------
        //*AGREGAR PRODUCTO*
//        Producto tv = new Producto(10,"Televisor", "Samsung 55 pulgadas FHD", 250000,5,true);
//        ProductoData prod = new ProductoData();
//        prod.resgistrarProducto(tv);
        //*MODIFICAR PRODUCTO*
        //*ELIMINAR PRODUCTO*
        //*AGREGAR PROVEEDOR*
//        Proveedor prov=new Proveedor(10,"Losada","Pringles 88",265679797);
//        ProveedorData prove=new ProveedorData();
//        prove.agregarProveedor(prov);
        //*COMPRAS¨POR CODIGO*
        ComprasData insc = new ComprasData();
        LocalDate fechaPrueba = LocalDate.of(2023, 11, 2);
        
          for(Compras detallecompra: insc.obtenerProductosPorProeveedor(fechaPrueba)){
            System.out.println(detallecompra.getIdCompra());
    }
    
}}
