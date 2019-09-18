package Clases;

import Persistencia.DespachoDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class Despacho {
    private int id;
    private int pedido;
    private int conductor;
//    private ArrayList<Pedido> pedido;
//    private ArrayList<Conductor> conductor;

//    public Despacho(int id, ArrayList<Pedido> pedido, ArrayList<Conductor> conductor) {
//        this.id = id;
//        this.pedido = pedido;
//        this.conductor = conductor;
//    }

    public Despacho(int id, int pedido, int conductor) {
        this.id = id;
        this.pedido = pedido;
        this.conductor = conductor;
    }
    
    

    public Despacho() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public ArrayList<Pedido> getPedido() {
//        return pedido;
//    }
//
//    public void setPedido(ArrayList<Pedido> pedido) {
//        this.pedido = pedido;
//    }
//
//    public ArrayList<Conductor> getConductor() {
//        return conductor;
//    }
//
//    public void setConductor(ArrayList<Conductor> conductor) {
//        this.conductor = conductor;
//    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public int getConductor() {
        return conductor;
    }

    public void setConductor(int conductor) {
        this.conductor = conductor;
    }
    
    
    
    public boolean insertarDespacho(){
        DespachoDAO sql = new DespachoDAO();//instancia ventadao
        return sql.InsertarDespachoDAO(this);
    }
//    
//     public boolean modificarDimension(String tabla){
//        DimensionDAO sql = new DimensionDAO();//instancia ventadao
//        return sql.modificarDimensionDAO(this, tabla);
//    }
    
    public ArrayList<Despacho> buscarDatosDespacho(boolean busqueda, String tabla, String dato){
        DespachoDAO empdao = new DespachoDAO();//instancia ClienteDao
        return empdao.buscarDatosDespachoDAO(busqueda, tabla, dato);
    }
}