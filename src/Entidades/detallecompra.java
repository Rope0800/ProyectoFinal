
package Entidades;


public class detallecompra {
    private int idDetalle;
    private int cantidad;
    private double precioCostos;
    private compras compras;
    private Producto producto;

    public detallecompra() {
    }

    public detallecompra(int cantidad, double precioCostos, compras compras, Producto producto) {
        this.cantidad = cantidad;
        this.precioCostos = precioCostos;
        this.compras = compras;
        this.producto = producto;
    }

    public detallecompra(int idDetalle, int cantidad, double precioCostos, compras compras, Producto producto) {
        this.idDetalle = idDetalle;
        this.cantidad = cantidad;
        this.precioCostos = precioCostos;
        this.compras = compras;
        this.producto = producto;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCostos() {
        return precioCostos;
    }

    public void setPrecioCostos(double precioCostos) {
        this.precioCostos = precioCostos;
    }

    public compras getCompras() {
        return compras;
    }

    public void setCompras(compras compras) {
        this.compras = compras;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "detallecompra{" + "idDetalle=" + idDetalle + ", cantidad=" + cantidad + ", precioCostos=" + precioCostos + ", compras=" + compras + ", producto=" + producto + '}';
    }
    
    
    
    
    
}
