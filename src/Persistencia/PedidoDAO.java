package Persistencia;

import Clases.Pedido;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class PedidoDAO {
    private Conexion con = null;
    
    public PedidoDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public boolean cambiarEstadoDAO(Pedido pedido){
        try{
            String query = "UPDATE Pedido SET  Estado = '"+pedido.getEstado()+"' where Id_Pedido = "+pedido.getId()+";";
            boolean flag = con.ejecutaSQLinstruccion(query);
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection();//cierra la conexion  
        }   
    }
    
    public Pedido buscarPedidoDAO(int id){

        String query="select * from Pedido where Id_Pedido = '"+id+"'";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            if (rs.next()) {
                Pedido pedido = new Pedido();//instancia clase cliente
                pedido.setId(rs.getInt("Id_Pedido"));
                pedido.setRut(rs.getString("Rut_Cliente"));
                pedido.setCantidad(rs.getInt("Cantidad_Total"));
                pedido.setTotal(rs.getInt("Total"));
                pedido.setOb_Cliente(rs.getString("Ob_Cliente"));
                pedido.setOb_Despacho(rs.getString("Ob_Despacho"));
                pedido.setTarjeta(rs.getString("Tipo_tarjeta"));
                pedido.setEstado(rs.getString("Estado"));
                pedido.setFecha_Entrega(rs.getString("Fecha_Entrega"));
                pedido.setFecha_Pedido(rs.getString("Fecha_Pedido"));
                pedido.setDestino(rs.getString("Destino_Despacho"));
                return pedido;
            }else
                return null;
        } 
        catch (SQLException ex) {
            return null;
        }
    
    }
    
    public ArrayList<Pedido> buscarDatosPedidoDAO(boolean busqueda, String texto, String tabla){
        String query;
        if (busqueda) 
            query = "select * from Pedido where "+tabla+" like '"+texto+"%' ";
        else
            query = "select * from Pedido order by Fecha_Entrega desc";       
        
        ArrayList<Pedido> listaConsultaPedido = new ArrayList<Pedido>();

        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            while(rs.next()) {
                Pedido pedido = new Pedido();//instancia clase cliente
                pedido.setId(rs.getInt("Id_Pedido"));
                pedido.setRut(rs.getString("Rut_Cliente"));
                pedido.setCantidad(rs.getInt("Cantidad_Total"));
                pedido.setTotal(rs.getInt("Total"));
                pedido.setOb_Cliente(rs.getString("Ob_Cliente"));
                pedido.setOb_Despacho(rs.getString("Ob_Despacho"));
                pedido.setTarjeta(rs.getString("Tipo_tarjeta"));
                pedido.setEstado(rs.getString("Estado"));
                pedido.setFecha_Entrega(rs.getString("Fecha_Entrega"));
                pedido.setFecha_Pedido(rs.getString("Fecha_Pedido"));
                pedido.setDestino(rs.getString("Destino_Despacho"));
                listaConsultaPedido.add(pedido);
            }
            return listaConsultaPedido;  
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+ex.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return null;
        } 
        finally {
            con.closeConnection();  //cierra la conexion
        }
    }   
}