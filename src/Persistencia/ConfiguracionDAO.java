package Persistencia;

import Conexión.Conexion;
import Clases.Configurar;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class ConfiguracionDAO {
        private Conexion con = null;
    
    public ConfiguracionDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public Configurar buscarConfiguracionDAO(){
        Configurar conf = null;
        String query="SELECT * FROM Configuracion";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            if (rs.next()) {
                conf = new Configurar();
                conf.setPermisoEmpleado(rs.getInt("PEmpleado"));
                conf.setStockMinimo(rs.getInt("Stock_Minimo"));
                conf.setStockMaximo(rs.getInt("Stock_Maximo"));
                conf.setIniciarSesion(rs.getInt("Sesion_Iniciada"));
                conf.setIdEmpleado(rs.getString("Id_Empleado"));
                conf.setContraseña(rs.getString("Contraseña_Empleado"));
                conf.setVentana(rs.getInt("Ventana"));
                return conf;
            }else
                return null;            
        } 
        catch (SQLException ex) {
            return null;
        }finally{
            con.closeConnection();//cierra la conexion  
        }  
    }
    
    public boolean actualizarConfiguracionDAO(Configurar config){
        try{
            String query = "UPDATE Configuracion SET  PEmpleado="+config.getPermisoEmpleado()+",Stock_Minimo="+config.getStockMinimo()
                    +",Stock_Maximo="+config.getStockMaximo()+",Sesion_Iniciada="+config.getIniciarSesion()
                    +",Id_Empleado='"+config.getIdEmpleado()+"',Contraseña_Empleado='"+config.getContraseña()
                    +"',Ventana="+config.getVentana()+" WHERE ID = "+config.getId()+";";
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
}