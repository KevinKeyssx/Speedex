package Clases;

import Persistencia.DetallePedidoDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class DetallePedido {
    private int id;
    private int id_Pedido;
    private String codigo;
    private int cantidad;
    private int subTotal;

    public DetallePedido() {
    }

    public DetallePedido(int id, int id_Pedido, String codigo, int cantidad, int subTotal) {
        this.id = id;
        this.id_Pedido = id_Pedido;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_Pedido() {
        return id_Pedido;
    }

    public void setId_Pedido(int id_Pedido) {
        this.id_Pedido = id_Pedido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
    
    public ArrayList<DetallePedido> buscarDatosPedido(){
        DetallePedidoDAO sql = new DetallePedidoDAO();//instancia ClienteDao
        return sql.buscarDatosPedidoDAO(this);
    }
}