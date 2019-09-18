package Persistencia;

import Clases.Proveedor;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class ProveedorDAO {
    private Conexion con = null;
    
    public ProveedorDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public Proveedor buscarId (){
        Proveedor prov = null;
        String query="SELECT MAX(Id_Proveedor) as Id FROM Proveedor";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            if (rs.next()) {
                prov = new Proveedor();
                prov.setId(rs.getInt(1));

                return prov;
            }else
                return null;            
        } 
        catch (SQLException ex) {
            return null;
        }finally{
            con.closeConnection();//cierra la conexion  
        }  
    }
    
    public boolean InsertarProveedorDAO(Proveedor prov){
        try{
            String query = "INSERT INTO Proveedor VALUES ('"+prov.getNombre()+"','"+prov.getRut()+"','"+prov.getTelefono()+"','"
            +prov.getDireccion()+"',"+prov.getActivo()+");";
            boolean flag = con.ejecutaSQLinstruccion(query);//flag guarda la ejecucion si se pudo hacer o no
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection(); //cierra la conexion 
        } 
    }
    
    /******Buscar cliente por rut en la  BBDD*****/  
    public Proveedor buscarProveedorDAO(int id){
        Proveedor prov = null;
        String query="SELECT * FROM Proveedor WHERE Id_Proveedor ="+id+"";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            if (rs.next()) {
                prov = new Proveedor();
                prov.setId(rs.getInt("Id_Proveedor"));
                prov.setNombre(rs.getString("Nombre_Preveedor"));
                prov.setRut(rs.getString("Rut_Proveedor"));
                prov.setTelefono(rs.getString("Teléfono_Prov"));
                prov.setDireccion(rs.getString("Direccion_Prov"));
                prov.setActivo(rs.getInt("Activo_Proveedor"));
                return prov;
            }else{
                return null;
            }
        } 
        catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean actualizarProveedorDAO(Proveedor prov){
        try{
            String query = "UPDATE Proveedor SET  Nombre_Preveedor='"+prov.getNombre()+"', Teléfono_Prov='"+prov.getTelefono()
                    +"', Direccion_Prov='"+prov.getDireccion()+"', Activo_Proveedor="+prov.getActivo()+" WHERE Id_Proveedor = "+prov.getId()+";";
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
    
        public boolean eliminarProveedorDao(int rut){
        try{
            String query ="DELETE FROM Proveedor WHERE Id_Proveedor = "+rut+";"; 
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
        
    public ArrayList<Proveedor> buscarDatosProveedorDAO(boolean busqueda, String tabla, String dato){
        String query;
        
        if (busqueda) 
            query = "select * from Proveedor where "+tabla+" like '"+dato+"%'";
        else
            query = "select * from Proveedor";
        
        ArrayList<Proveedor> listaConsultaProveedor = new ArrayList<Proveedor>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try { 
            while(rs.next()) {
                Proveedor prov = new Proveedor();//instancia clase cliente
                prov.setId(rs.getInt("Id_Proveedor"));
                prov.setNombre(rs.getString("Nombre_Preveedor"));
                prov.setRut(rs.getString("Rut_Proveedor"));
                prov.setTelefono(rs.getString("Teléfono_Prov"));
                prov.setDireccion(rs.getString("Direccion_Prov"));
                prov.setActivo(rs.getInt("Activo_Proveedor"));
                listaConsultaProveedor.add(prov);
            }
            con.closeConnection();//cierra la conexion
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
