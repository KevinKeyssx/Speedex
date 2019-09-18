package Persistencia;

import Clases.Cliente;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class SQLDAO {
    private Conexion con = null;
    
    public SQLDAO(){
        con = new Conexion();//instancia la conexion
    }
  /*******************************************************Metodo Insertar Cliente************************************************/  
    public boolean InsertarClienteDAO(Cliente cliente){
        try{
            String query = "INSERT INTO Cliente VALUES ('"+cliente.getRut()+"','"+cliente.getNombre()+"','"+cliente.getApellidoP()+"','"
            +cliente.getApellidoM()+"','"+cliente.getDireccion()+"','"+cliente.getCorreo()+"','"+cliente.getFono()+"')";
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
    /***************************************************Buscar cliente por rut en la  BBDD**********************************************/  
    public Cliente buscarClienteDAO(String rut){
        Cliente clie = null;
        String query="SELECT * FROM Cliente WHERE Rut_Cliente="+rut+"";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            if (rs.next()) {
                clie = new Cliente();
                clie.setRut(rs.getString("Rut_Cliente"));
                clie.setNombre(rs.getString("Nombre_Cliente"));
                clie.setApellidoP(rs.getString("ApellidoP_Cliente"));
                clie.setApellidoM(rs.getString("apellidoM_Cliente"));
                clie.setDireccion(rs.getString("Direccion_Cliente"));
                clie.setCorreo(rs.getString("Correo_Cliente"));
                clie.setFono(rs.getInt("Teléfono_Cliente"));
                return clie;
            }else
                return null;            
        } 
        catch (SQLException ex) {
            return null;
        }finally{
            con.closeConnection();//cierra la conexion  
        }  
    }
    /******************************************************Modificar datos de un Cliente***********************************************/
    public boolean actualizarClienteDAO(Cliente cliente){
        try{
            String query = "UPDATE Cliente SET  Nombre_Cliente='"+cliente.getNombre()+"',ApellidoP_Cliente='"+cliente.getApellidoP()
                    +"',ApellidoM_Cliente="+cliente.getApellidoM()+",Teléfono_Cliente='"+cliente.getFono()+"',Direccion_Cliente='"+cliente.getDireccion()
                    +"',Correo_Cliente='"+cliente.getCorreo()+"' WHERE Rut_Cliente = '"+cliente.getRut()+"';";
            boolean flag = con.ejecutaSQLinstruccion(query);
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection();//cierra la conexion  
        }   
    }
    /*************************************************** Metodo Eliminar cliente de la  BBDD ***********************************************/  
    public boolean eliminarClienteDao(String rut){
        try{
            String query ="DELETE FROM Cliente WHERE Rut_Cliente = '"+rut+"';"; 
             boolean flag = con.ejecutaSQLinstruccion(query);
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
    
    public ArrayList<Cliente> buscarDatosClienteDAO(boolean busqueda, String tabla, String dato, String seleccion){
        String query = "";
        
        if (busqueda) {
            if (seleccion.equals("like")) 
                query = "select * from Cliente where "+tabla+" like '"+dato+"%'";
            else
                query = "select * from Cliente where "+tabla+" = '"+dato+"'";
            
        }else
            query = "select * from Cliente";
        
        ArrayList<Cliente> listaConsultaCliente = new ArrayList<Cliente>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try { 
            while(rs.next()) {
                Cliente clie = new Cliente();//instancia clase cliente
                clie.setRut(rs.getString("Rut_Cliente"));
                clie.setNombre(rs.getString("Nombre_Cliente"));
                clie.setApellidoP(rs.getString("ApeP_Cliente"));
                clie.setApellidoM(rs.getString("ApeM_Cliente"));
                clie.setDireccion(rs.getString("Direccion_Cliente"));
                clie.setCorreo(rs.getString("Correo_Cliente"));
                clie.setFono(rs.getInt("Teléfono_Cliente"));
                listaConsultaCliente.add(clie);
            }
            con.closeConnection();//cierra la conexion
            return listaConsultaCliente;  
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