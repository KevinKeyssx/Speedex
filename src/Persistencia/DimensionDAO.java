package Persistencia;

import Conexión.Conexion;
import Clases.Dimension;
import Clases.Validar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class DimensionDAO {
    private Conexion con = null;
    
    public DimensionDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public boolean InsertarDimensionDAO(Dimension dim, String tabla){
        try{
            String query = "INSERT INTO "+tabla+" VALUES ("+dim.getAlto()+","+dim.getAncho()+","+dim.getLargo()+","+dim.getPeso()+")";
            
            boolean flag = con.ejecutaSQLinstruccion(query);//variable igualada a conexion consulta
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection(); //cierra la conexion 
        } 
    }
    
    public boolean modificarDimensionDAO(Dimension dim, String tabla){
        try{
            String query = "UPDATE "+tabla+" SET  Alto = "+dim.getAlto()+" , Ancho = "+dim.getAncho()+" , Largo = "
                    +dim.getLargo()+" , Peso = "+dim.getPeso()+" where Id_Dimension = "+dim.getNumero()+";";
            boolean flag = con.ejecutaSQLinstruccion(query);
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection();//cierra la conexion  
        }   
    }
  
    public Dimension buscarDimensionDAO(String codigo, boolean inner, int idDimension){
        Dimension dim;
        String query;
        
        if (inner) {
            query = "select * from Dimension_Prod"
                +" inner join Producto on Dimension_Prod.Id_Dimension = Producto.Id_Dimension"
                + " where Id_Producto = '"+codigo+"'";
        }
        else
            query = "select * from Dimension_Movil where Id_Dimension = "+idDimension;
        
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            if (rs.next()) {
                dim = new Dimension();
                dim.setAlto(rs.getInt("Alto"));
                dim.setAncho(rs.getInt("Ancho"));
                dim.setLargo(rs.getInt("Largo"));
                dim.setPeso(rs.getInt("Peso"));
                return dim;
            }else
                return null;
        } 
        catch (SQLException ex) {
            return null;
        }
    }
     
    public ArrayList<Dimension> buscarDatosDimensionDAO(boolean busqueda, String dato, String columa, String tabla){
        String query;
        
        if (busqueda)
            query = "select * from "+tabla+" where "+columa+" like '"+dato+"%'";
        else
            query = "select * from "+tabla;       
        
        ArrayList<Dimension> listaConsultaDim = new ArrayList<>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            while(rs.next()) {
                Dimension dim = new Dimension();//instancia clase cliente
                dim.setNumero(rs.getInt("Id_Dimension"));
                dim.setAlto(rs.getInt("Alto"));
                dim.setAncho(rs.getInt("Ancho"));
                dim.setLargo(rs.getInt("Largo"));
                dim.setPeso(rs.getInt("Peso"));
                listaConsultaDim.add(dim);
            }
            return listaConsultaDim;  
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+ex.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return null;
        } 
        finally {
            con.closeConnection();  //cierra la conexion
        }
    }    
    
    public Dimension calculoVentaDAO (String calculo, String columna, int id){
        Dimension dim;
        String query = "select Total = ("+calculo+"("+columna+") * Cantidad_DetalleVenta) from Dimension_Prod\n" +
                        "inner join Producto\n" +
                        "on Producto.Id_Dimension = Dimension_Prod.Id_Dimension\n" +
                        "Inner join DetallePedido\n" +
                        "on DetallePedido.Id_Producto = Producto.Id_Producto\n" +
                        "where id_DetallePedido = "+id+
                        "group by Cantidad_DetalleVenta";
        
        if (columna.equals("Id_Dimension")) 
            query = "select MAX(Id_Dimension) from Dimension_Prod";
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            if (rs.next()) {
                dim = new Dimension();
                dim.setNumero(rs.getInt(1));

                return dim;
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