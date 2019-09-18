package Persistencia;

import Clases.Despacho;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class DespachoDAO {
    private Conexion con = null;
    
    public DespachoDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public boolean InsertarDespachoDAO(Despacho despacho){
        try{
            String query = "INSERT INTO Despacho VALUES ("+despacho.getPedido()+", "+despacho.getConductor()+")";
            
            boolean flag = con.ejecutaSQLinstruccion(query);//variable igualada a conexion consulta
            con.closeConnection();//cierra la conexion
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection(); //cierra la conexion 
        } 
    }
//    
//    public boolean actualizarConductorDAO(Despacho despacho){
//        try{
//            String query = "UPDATE Despacho SET  Id_Pedido = "+despacho.getPedido().get(0)+", Id_Conductor = "+despacho.getConductor().get(0)
//                    +" WHERE Id_Despacho = '"+despacho.getId()+"';";
//            boolean flag = con.ejecutaSQLinstruccion(query);
//            return flag;
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
//            return false;
//        }finally{
//            con.closeConnection();//cierra la conexion  
//        }   
//    }
    
    public ArrayList<Despacho> buscarDatosDespachoDAO(boolean busqueda, String tabla, String dato){
        String query;
        
        if (busqueda) 
            query = "select * from Despacho where "+tabla+" like '"+dato+"%'";
        else
            query = "select * from Despacho";
        
        ArrayList<Despacho> listaConsultaProveedor = new ArrayList<Despacho>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try { 
            while(rs.next()) {
                Despacho des = new Despacho();//instancia clase cliente
                des.setId(rs.getInt("Id_Despacho"));
                des.setPedido(rs.getInt("Id_Pedido"));
                des.setConductor(rs.getInt("Id_Conductor"));
                listaConsultaProveedor.add(des);
            }
            return listaConsultaProveedor;  
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