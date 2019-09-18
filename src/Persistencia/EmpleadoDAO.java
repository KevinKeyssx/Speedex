package Persistencia;

import Clases.Empleado;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class EmpleadoDAO {
    private Conexion con = null;
    
    public EmpleadoDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public Empleado buscarEmpleadoDAO(String codigo, String contraseña){
        Empleado emp = null;
        String query="SELECT * FROM Empleado WHERE Id_Empleado = '"+codigo+"' and Contraseña_Empleado = '"+contraseña+"'";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            if (rs.next()) {
                emp = new Empleado();
                emp.setIdEmpleado(rs.getString("Id_Empleado"));
                emp.setNombre(rs.getString("Nombre_Empleado"));
                emp.setApellidoP(rs.getString("ApellidoP_Empleado"));
                emp.setApellidoM(rs.getString("ApellidoM_Empleado"));
                emp.setRut(rs.getString("Rut_Empleado"));
                emp.setContraseña(rs.getString("Contraseña_Empleado"));
                emp.setTipo(rs.getString("Tipo_Empleado"));
                return emp;
            }else
                return null;            
        } 
        catch (SQLException ex) {
            return null;
        }finally{
            con.closeConnection();//cierra la conexion  
        }  
    }
    
    public boolean InsertarEmpleadoDAO(Empleado empleado){
        try{
            String query = "INSERT INTO Empleado VALUES ('"+empleado.getNombre()+"','"+empleado.getApellidoP()+"','"+
            empleado.getApellidoM()+"','"+empleado.getRut()+"','"+empleado.getContraseña()+"','"+empleado.getTipo()+"')";
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
    
    public boolean actualizarEmpleadoDAO(Empleado empleado){
        try{
            String query = "UPDATE Empleado SET  Nombre_Empleado='"+empleado.getNombre()+"',ApellidoP_Empleado='"+empleado.getApellidoP()
                    +"',ApellidoM_Empleado='"+empleado.getApellidoM()+"',Contraseña_Empleado='"+empleado.getContraseña()
                    +"',Tipo_Empleado='"+empleado.getTipo()+"' WHERE Id_Empleado = "+empleado.getIdEmpleado()+";";
            boolean flag = con.ejecutaSQLinstruccion(query);
            con.closeConnection();//cierra la conexion
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection();//cierra la conexion  
        }   
    }
    
    public Empleado obtenerCodigoDAO (){
        Empleado emp = null;
        String query="SELECT MAX(Id_Empleado) as Id FROM Empleado";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            if (rs.next()) {
                emp = new Empleado();
                emp.setIdEmpleado(rs.getString(1));

                return emp;
            }else
                return null;            
        } 
        catch (SQLException ex) {
            return null;
        }finally{
            con.closeConnection();//cierra la conexion  
        }  
    }
    
    public boolean eliminarEmpleadoDao(String id){
        try{
            String query ="DELETE FROM Empleado WHERE Id_Empleado = "+id+";"; 
             boolean flag = con.ejecutaSQLinstruccion(query);
            con.closeConnection();//cierra la conexion
            return flag;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        finally{
            con.closeConnection(); //cierra la conexion 
        } 
    }
    
    public ArrayList<Empleado> buscarDatosEmpleadoDAO(boolean busqueda, String tabla, String dato){
        String query;
        
        if (busqueda) 
            query = "Select * from Empleado where "+tabla+" like '"+dato+"%'";
        else
            query = "select * from Empleado";
        
        ArrayList<Empleado> listaConsultaEmpleado = new ArrayList<Empleado>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            while(rs.next()) {
                Empleado emp = new Empleado();//instancia clase cliente
                emp.setIdEmpleado(rs.getString("Id_Empleado"));
                emp.setNombre(rs.getString("Nombre_Empleado"));
                emp.setApellidoP(rs.getString("ApellidoP_Empleado"));
                emp.setApellidoM(rs.getString("ApellidoM_Empleado"));
                emp.setRut(rs.getString("Rut_Empleado"));
                emp.setContraseña(rs.getString("Contraseña_Empleado"));
                emp.setTipo(rs.getString("Tipo_Empleado"));
                
                listaConsultaEmpleado.add(emp);
            }
            con.closeConnection();//cierra la conexion
            return listaConsultaEmpleado;  
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