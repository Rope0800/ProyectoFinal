
package Entidades;

import java.time.LocalDate;


public class Compras {
    
    private int idCompra;
    private Proveedor proveedor;
    private LocalDate fecha_compra;

    public Compras() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public LocalDate getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(LocalDate fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public Compras(Proveedor proveedor, LocalDate fecha_compra) {
        this.proveedor = proveedor;
        this.fecha_compra = fecha_compra;
    }

    public Compras(int idCompra, Proveedor proveedor, LocalDate fecha_compra) {
        this.idCompra = idCompra;
        this.proveedor = proveedor;
        this.fecha_compra = fecha_compra;
    }

    @Override
    public String toString() {
        return "compras{" + "idCompra=" + idCompra + ", proveedor=" + proveedor + ", fecha_compra=" + fecha_compra + '}';
    }
    
    
   
}
