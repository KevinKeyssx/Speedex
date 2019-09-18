package Persistencia;

import Clases.Conductor;
import Clases.Validar;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class ConductorDAO {
    private Conexion con = null;
    
    public ConductorDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public boolean InsertarConductorDAO(Conductor conductor){
        try{
            String query = "INSERT INTO Conductor VALUES ('"+conductor.getNombre()+"','"+conductor.getApellidoP()+"','"
                            +conductor.getApellidoM()+"','"+conductor.getIdMovil()+")";
            
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
    
    public boolean actualizarConductorDAO(Conductor conductor){
        try{
            String query = "UPDATE Conductor SET  Nombre_Conductor = '"+conductor.getNombre()+"', ApellidoP_Conductor = '"+conductor.getApellidoP()
                    +"', ApellidoM_Conductor = '"+conductor.getApellidoM()+"', Id_Movil = "+conductor.getIdMovil()
                    +" WHERE Id_Conductor = '"+conductor.getId()+"';";
            boolean flag = con.ejecutaSQLinstruccion(query);
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection();//cierra la conexion  
        }   
    }
    
    public ArrayList<Conductor> buscarDatosConductorDAO(boolean busqueda, String texto, String tabla){
        String query;
        
        if (busqueda) 
            query = "select * from Conductor where "+tabla+" like '"+texto+"%'";
        else
            query = "select * from Conductor";       
        
        ArrayList<Conductor> listaConductor = new ArrayList<>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            while(rs.next()) {
                Conductor conductor = new Conductor();//instancia clase cliente
                conductor.setId(rs.getInt("Id_Conductor"));
                conductor.setNombre(rs.getString("Nombre_Conductor"));
                conductor.setApellidoP(rs.getString("ApellidoP_Conductor"));
                conductor.setApellidoM(rs.getString("ApellidoM_Conductor"));
                conductor.setIdMovil(rs.getInt("Id_Movil"));
                listaConductor.add(conductor);
            }
            return listaConductor;  
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+ex.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return null;
        } 
        finally {
            con.closeConnection();  //cierra la conexion
        }
    }  
    
    public Conductor calculoConductorDAO (String calculo, String columna){
        Validar v = new Validar();
        Conductor cond;
        
        String query;
        
        query="SELECT "+calculo+"("+columna+") as calculo FROM Conductor";
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            if (rs.next()) {
                cond = new Conductor();
                cond.setId(rs.getInt(1));

                return cond;
            }else
                return null;            
        } 
        catch (SQLException ex) {
            return null;
        }finally{
            con.closeConnection();//cierra la conexion  
        }  
    }
}