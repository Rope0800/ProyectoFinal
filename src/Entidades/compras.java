
package Entidades;

import java.time.LocalDate;


public class compras {
    
    private int idCompra;
    private proveedor proveedor;
    private LocalDate fecha_compra;

    public compras() {
    }

    public compras(proveedor proveedor, LocalDate fecha_compra) {
        this.proveedor = proveedor;
        this.fecha_compra = fecha_compra;
    }

    public compras(int idCompra, proveedor proveedor, LocalDate fecha_compra) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.fecha_compra = fecha_compra;
    }

    @Override
    public String toString() {
        return "compras{" + "idCompra=" + idCompra + ", proveedor=" + proveedor + ", fecha_compra=" + fecha_compra + '}';
    }
    
    
   
}
