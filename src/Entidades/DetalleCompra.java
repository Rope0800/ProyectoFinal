
package Entidades;


public class DetalleCompra {
    private int idDetalle;
    private int cantidad;
    private double precioCostos;
    private Compras compras;
    private Producto producto;

    public DetalleCompra() {
    }

    public DetalleCompra(int cantidad, double precioCostos, Compras compras, Producto producto) {
        this.cantidad = cantidad;
        this.precioCostos = precioCostos;
        this.compras = compras;
        this.producto = producto;
    }

    public DetalleCompra(int idDetalle, int cantidad, double precioCostos, Compras compras, Producto producto) {
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

    public Compras getCompras() {
        return compras;
    }

    public void setCompras(Compras compras) {
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
