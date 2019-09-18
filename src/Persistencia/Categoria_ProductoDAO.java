package Persistencia;

import Clases.Categoria_Producto;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author keiss
 */
public class Categoria_ProductoDAO {
    private Conexion con = null;
    
    public Categoria_ProductoDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public boolean InsertarCat_ProductoDAO(Categoria_Producto catp){
        try{
            String query = "INSERT INTO Categoria_Prod VALUES ('"+catp.getNombre()+"','"+catp.getDescripcion()+"');";
            boolean flag = con.ejecutaSQLinstruccion(query);//flag guarda la ejecucion si se pudo hacer o no
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection(); //cierra la conexion 
        } 
    }
    
     public boolean actualizarCatDAO(Categoria_Producto catp){
        try{
            String query = "UPDATE Categoria_Prod SET  Nom_Cat_Prod='"+catp.getNombre()+"',Descri_Cat_Prod='"+catp.getDescripcion()
                    +"' WHERE Id_Cat_Prod = "+catp.getId()+";";
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
    
    public Categoria_Producto obtenerIdCat(Categoria_Producto catp){
        Categoria_Producto cat = null;
        String query="SELECT MAX(Id_Cat_Prod) as Id FROM Categoria_Prod";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            if (rs.next()) {
                cat = new Categoria_Producto();
                cat.setId(rs.getInt(1));

                return cat;
            }else
                return null;            
        } 
        catch (SQLException ex) {
            return null;
        }finally{
            con.closeConnection();//cierra la conexion  
        }  
    }
    
    
    public ArrayList<Categoria_Producto> buscarDatosCategoriaDAO(boolean busqueda, String tabla, String dato){
        String query;
        
        if (busqueda)
            query = "select * from Categoria_Prod where "+tabla+ " like  '"+dato+"%'";
        else
            query = "select * from Categoria_Prod";
        
        ArrayList<Categoria_Producto> listaConsultaCategoria = new ArrayList<Categoria_Producto>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            while(rs.next()) {
                Categoria_Producto cat = new Categoria_Producto();//instancia clase cliente
                cat.setId(rs.getInt("Id_Cat_Prod"));
                cat.setNombre(rs.getString("Nom_Cat_Prod"));
                cat.setDescripcion(rs.getString("Descri_Cat_Prod"));
                listaConsultaCategoria.add(cat);
            }
            con.closeConnection();//cierra la conexion
            return listaConsultaCategoria;  
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
