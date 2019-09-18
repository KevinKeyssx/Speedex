package Clases;

import Persistencia.DetalleVentaDAO;

/**
 * @author keiss
 */
public class DetalleVenta {
    private int id;
    private int idVenta;
    private String idProducto;
    private int cantidad;
    private float subTotal;

    public DetalleVenta() {
    }

    public DetalleVenta(int id, int idVenta, String idProducto, int cantidad, float subTotal) {
        this.id = id;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }
    
    public boolean insertarDetalle(){
        DetalleVentaDAO sql = new DetalleVentaDAO();//
        
        if(sql.InsertarDetalleDAO(this))
            return true;
        else
            return false;
    }   
}