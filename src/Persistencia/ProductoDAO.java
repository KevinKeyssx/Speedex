package Persistencia;

import Clases.Producto;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class ProductoDAO {
    
      private Conexion con = null;
    
    public ProductoDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public boolean InsertarProductoDAO(Producto prod){
        try{
            String query = "INSERT INTO Producto VALUES ('"+prod.getId()+"','"+prod.getNombre()+"',"+prod.getStock()+","+prod.getPrecio()+","+
                    prod.getId_categoria()+","+prod.getId_proveedor()+","+prod.getActivo()+","+prod.getId_dimension()+");";
            boolean flag = con.ejecutaSQLinstruccion(query);//flag guarda la ejecucion si se pudo hacer o no
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection(); //cierra la conexion 
        } 
    }
    
    public Producto buscarProductoDAO(String id){
        Producto prod;
        String query="select * from Producto where Id_Producto = '"+id+"'";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            if (rs.next()) {
                prod = new Producto();
                prod.setId(rs.getString("Id_Producto"));
                prod.setNombre(rs.getString("Nombre_Producto"));
                prod.setStock(rs.getInt("Stock_Producto"));
                prod.setPrecio(rs.getInt("Precio_Prod"));
                prod.setId_categoria(rs.getInt("Id_Cat_Prod"));
                prod.setId_proveedor(rs.getInt("Id_Proveedor"));
                prod.setActivo(rs.getInt("Activo_Producto"));
                prod.setId_dimension(rs.getInt("Id_Dimension"));
                return prod;
            }else
                return null;
        } 
        catch (SQLException ex) {
            return null;
        }
    }
    
    public boolean actualizarProductoDAO(Producto prod){
        try{
            String query = "UPDATE Producto SET  Nombre_Producto='"+prod.getNombre()+"',Stock_Producto="+prod.getStock()
                    +",Precio_Prod="+prod.getPrecio()+",Id_Cat_Prod="+prod.getId_categoria()+",Id_Proveedor="+prod.getId_proveedor()
                    +",Activo_Producto="+prod.getActivo()+",Id_Dimension="+prod.getId_dimension()+" WHERE Id_Producto = '"+prod.getId()+"';";
            boolean flag = con.ejecutaSQLinstruccion(query);
            return flag;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+e.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return false;
        }finally{
            con.closeConnection();//cierra la conexion  
        }   
    }
  /********* Metodo Eliminar cliente de la  BBDD
     * @param id  
     * @return  ***************/  
    public boolean eliminarProductoDao(int id){
        try{
            String query ="DELETE FROM Producto WHERE Id_Producto = "+id+";"; 
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
    
    public ArrayList<Producto> buscarDatosProductoDAO(boolean busqueda, String texto, String tabla, boolean producto){
        String query;
        if (busqueda) {
            if (producto)
                query = "select * from Producto where "+tabla+" like '"+texto+"%'";
            else
                query = "select * from Producto where "+tabla+" = '"+texto+"'";
        }
        else
            query = "select * from Producto";       
        
        ArrayList<Producto> listaConsultaProducto = new ArrayList<Producto>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        try {
            while(rs.next()) {
                Producto prod = new Producto();//instancia clase cliente
                prod.setId(rs.getString("Id_Producto"));
                prod.setNombre(rs.getString("Nombre_Producto"));
                prod.setStock(rs.getInt("Stock_Producto"));
                prod.setPrecio(rs.getInt("Precio_Prod"));
                prod.setId_categoria(rs.getInt("Id_Cat_Prod"));
                prod.setId_proveedor(rs.getInt("Id_Proveedor"));
                prod.setActivo(rs.getInt("Activo_Producto"));
                prod.setId_dimension(rs.getInt("Id_Dimension"));
                listaConsultaProducto.add(prod);
            }
            return listaConsultaProducto;  
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