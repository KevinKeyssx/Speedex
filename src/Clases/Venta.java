package Clases;

import Persistencia.VentaDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class Venta {
    private int id;
    private int idEmpleado;
    private String fecha;
    private int cantidadTotal;
    private float ventaTotal;
    private String tipoPago;
    private float vuelto;
    private float recibo;
    private float descuento;
    private String estado;
    private ArrayList<DetalleVenta> detalleVenta;
    

    public Venta() {
    }

    public Venta(int id, int idEmpleado, String fecha, int cantidadTotal, float ventaTotal, String tipoPago, float vuelto, float recibo, float descuento, String estado, ArrayList<DetalleVenta> detalleVenta) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.cantidadTotal = cantidadTotal;
        this.ventaTotal = ventaTotal;
        this.tipoPago = tipoPago;
        this.vuelto = vuelto;
        this.recibo = recibo;
        this.descuento = descuento;
        this.estado = estado;
        this.detalleVenta = detalleVenta;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCantidadTotal() {
        return cantidadTotal;
    }

    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
    }

    public float getVentaTotal() {
        return ventaTotal;
    }

    public void setVentaTotal(float ventaTotal) {
        this.ventaTotal = ventaTotal;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public float getVuelto() {
        return vuelto;
    }

    public void setVuelto(float vuelto) {
        this.vuelto = vuelto;
    }

    public float getRecibo() {
        return recibo;
    }

    public void setRecibo(float recibo) {
        this.recibo = recibo;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(ArrayList<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public boolean insertarVenta(){
        VentaDAO sql = new VentaDAO();//instancia ventadao
        return sql.InsertarVentaDAO(this);
    }
    
    public boolean anularVenta(){
        VentaDAO sql = new VentaDAO();//instancia ventadao
        return sql.anularVentaDAO(this);
    }
    
    public Venta buscarID(){
        VentaDAO sql = new VentaDAO();
        return sql.buscarId();
    }
    
    public ArrayList<Venta> buscarDatosVenta(boolean busqueda,String fecha, String tabla, String dato, String orden){
        VentaDAO sql = new VentaDAO();//instancia ClienteDao
        return sql.buscarDatosVentaDAO(busqueda, fecha, tabla, dato, orden);
    }
    
    public Venta calculoVenta(boolean busqueda ,String calculo, String columna, String fecha, String dato, String col){
        VentaDAO sql = new VentaDAO();
        return sql.calculoVentaDAO(busqueda, calculo, columna, fecha, dato, col);
    }
    
    public Venta prodNulo(String fecha, String tabla, String dato){
        VentaDAO sql = new VentaDAO();
        return sql.prodNuloDAO(fecha, tabla, dato);
    }
}