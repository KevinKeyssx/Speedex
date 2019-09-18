package Clases;

import Persistencia.PedidoDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class Pedido {
    private int id;
    private String rut;
    private int cantidad;
    private int total;
    private String ob_Cliente;
    private String Ob_Despacho;
    private String tarjeta;
    private String estado;
    private String fecha_Entrega;
    private String fecha_Pedido;
    private String destino;

    public Pedido() {
    }

    public Pedido(int id, String rut, int cantidad, int total, String ob_Cliente, String Ob_Despacho, String tarjeta, String estado, String fecha_Entrega, String fecha_Pedido, String destino) {
        this.id = id;
        this.rut = rut;
        this.cantidad = cantidad;
        this.total = total;
        this.ob_Cliente = ob_Cliente;
        this.Ob_Despacho = Ob_Despacho;
        this.tarjeta = tarjeta;
        this.estado = estado;
        this.fecha_Entrega = fecha_Entrega;
        this.fecha_Pedido = fecha_Pedido;
        this.destino = destino;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOb_Cliente() {
        return ob_Cliente;
    }

    public void setOb_Cliente(String ob_Cliente) {
        this.ob_Cliente = ob_Cliente;
    }

    public String getOb_Despacho() {
        return Ob_Despacho;
    }

    public void setOb_Despacho(String Ob_Despacho) {
        this.Ob_Despacho = Ob_Despacho;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_Entrega() {
        return fecha_Entrega;
    }

    public void setFecha_Entrega(String fecha_Entrega) {
        this.fecha_Entrega = fecha_Entrega;
    }

    public String getFecha_Pedido() {
        return fecha_Pedido;
    }

    public void setFecha_Pedido(String fecha_Pedido) {
        this.fecha_Pedido = fecha_Pedido;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public boolean cambiarEstado(){
        PedidoDAO ped = new PedidoDAO();
        return ped.cambiarEstadoDAO(this);
    }
    
    public Pedido buscarPedido (int id){
        PedidoDAO pd = new PedidoDAO();
        return pd.buscarPedidoDAO(id);
    }
    
    public ArrayList<Pedido> buscarDatosPedido(boolean busqueda, String texto, String tabla){
        PedidoDAO sql = new PedidoDAO();//instancia ClienteDao
        return sql.buscarDatosPedidoDAO(busqueda, texto, tabla);
    }
}