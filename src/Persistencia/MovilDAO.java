package Persistencia;

import Clases.Movil;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class MovilDAO {
    private Conexion con = null;
    
    public MovilDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public boolean InsertarMovilDAO(Movil movil){
        try{
            String query = "INSERT INTO Movil VALUES ('"+movil.getMarca()+"','"+movil.getModelo()+"','"
                            +movil.getPatente()+"','"+movil.getTipo()+"',"+movil.getIdDimension()+")";
            
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
    
    public boolean actualizarMovilDAO(Movil movil){
        try{
            String query = "UPDATE Movil SET  Marca_Movil = '"+movil.getMarca()+"',Modelo_Movil = '"+movil.getModelo()
                    +"', Patente_Movil = '"+movil.getPatente()+"', Tipo_Movil = '"+movil.getTipo()+"', Id_Dimension = "+movil.getIdDimension()
                    +" WHERE Id_Movil = '"+movil.getId()+"';";
            boolean flag = con.ejecutaSQLinstruccion(query);
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection();//cierra la conexion  
        }   
    }
    
    public ArrayList<Movil> buscarDatosMovilDAO(boolean busqueda, String texto, String tabla){
        String query;
        
        if (busqueda) 
            query = "select * from Movil where "+tabla+" like '"+texto+"%'";
        else
            query = "select * from Movil";       
        
        ArrayList<Movil> listaMovil = new ArrayList<>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            while(rs.next()) {
                Movil movil = new Movil();//instancia clase cliente
                movil.setId(rs.getInt("Id_Movil"));
                movil.setMarca(rs.getString("Marca_Movil"));
                movil.setModelo(rs.getString("Modelo_Movil"));
                movil.setPatente(rs.getString("Patente_Movil"));
                movil.setTipo(rs.getString("Tipo_Movil"));
                movil.setIdDimension(rs.getInt("Id_Dimension"));
                listaMovil.add(movil);
            }
            return listaMovil;  
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