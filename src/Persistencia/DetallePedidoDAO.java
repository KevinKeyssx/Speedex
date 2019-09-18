package Persistencia;

import Clases.DetallePedido;
import Clases.Pedido;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class DetallePedidoDAO {
    private Conexion con = null;
    
    public DetallePedidoDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public ArrayList<DetallePedido> buscarDatosPedidoDAO(DetallePedido dpedido){
        String query = "select * from DetallePedido where Id_Pedido = "+dpedido.getId_Pedido();       
        
        ArrayList<DetallePedido> listaConsultaPedido = new ArrayList<DetallePedido>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            while(rs.next()) {
                DetallePedido d = new DetallePedido();//instancia clase cliente
                d.setId(rs.getInt("Id_DetallePedido"));
                d.setId_Pedido(rs.getInt("Id_Pedido"));
                d.setCodigo(rs.getString("Id_Producto"));
                d.setCantidad(rs.getInt("Cantidad_DetalleVenta"));
                d.setSubTotal(rs.getInt("SubTotal_Detalle"));
                listaConsultaPedido.add(d);
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