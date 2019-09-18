package Persistencia;

import Clases.DetalleVenta;
import Clases.Validar;
import Clases.Venta;
import Conexión.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author keiss
 */
public class VentaDAO {
    
    private Conexion con = null;
    
    public VentaDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public boolean InsertarVentaDAO(Venta venta){
        try{
            String query = "INSERT INTO Venta VALUES ("+venta.getIdEmpleado()+",'"+venta.getFecha()+"',"+
            venta.getCantidadTotal()+","+venta.getVentaTotal()+","+venta.getRecibo()+",'"+venta.getTipoPago()+"',"+venta.getVuelto()
            +","+venta.getDescuento()+",'"+venta.getEstado()+"')";
            
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
    
    public boolean anularVentaDAO(Venta venta){
        try{
            String query = "UPDATE Venta set Estado_Venta = 'NULA' WHERE Id_Venta = "+venta.getId();
            
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
     
    public Venta buscarId (){
        Venta venta;
        String query="SELECT MAX(Id_Venta) as Id FROM Venta";
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            if (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt(1));

                return venta;
            }else
                return null;            
        } 
        catch (SQLException ex) {
            return null;
        }finally{
            con.closeConnection();//cierra la conexion  
        }  
    }
    
     public ArrayList<Venta> buscarDatosVentaDAO(boolean busqueda,String fecha, String tabla, String dato, String orden){
         Venta venta = null;
         Validar v = new Validar();
         String query = "select DetalleVenta.Id_Venta, DetalleVenta.Id_Producto, Total_Venta , Cantidad_DetalleVenta,\n" +
                    "Venta.Fecha_Venta, Venta.TipoPago_Venta, Venta.Estado_Venta, \n" +
                    "DetalleVenta.SubTotal_Detalle, Empleado.Id_Empleado, Venta.Recibo, Venta.Vuelto_Venta, Venta.Descuento\n" +
                    "from DetalleVenta\n" +
                    "inner join Venta on DetalleVenta.Id_Venta = Venta.Id_Venta\n" +
                    "inner join Empleado on Empleado.Id_Empleado = Venta.Id_Empleado Where "+fecha+" "+tabla+" like '"+dato+"%' " + orden;
        
        ArrayList<Venta> listaConsultaVenta = new ArrayList <Venta>();
        ArrayList <DetalleVenta> listaConsultaDetalleVenta = new ArrayList <DetalleVenta>();
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            while(rs.next()) {
                venta = new Venta();//instancia clase cliente
                DetalleVenta dv = new DetalleVenta();
                
                venta.setId(rs.getInt("Id_Venta"));
                dv.setIdProducto(rs.getString("Id_Producto"));
                venta.setVentaTotal(rs.getInt("Total_Venta"));
                dv.setCantidad(rs.getInt("Cantidad_DetalleVenta"));
                venta.setFecha(rs.getString("Fecha_Venta"));
                venta.setTipoPago(rs.getString("TipoPago_Venta"));
                venta.setEstado(rs.getString("Estado_Venta"));
                dv.setSubTotal(rs.getFloat("SubTotal_Detalle"));
                venta.setIdEmpleado(rs.getInt("Id_Empleado"));
                venta.setRecibo(rs.getFloat("Recibo"));
                venta.setVuelto(rs.getFloat("Vuelto_Venta"));
                venta.setDescuento(rs.getFloat("Descuento"));
                
                dv.setId(dv.getId());
                dv.setIdVenta(dv.getIdVenta());
                
                listaConsultaDetalleVenta.add(dv);
                venta.setDetalleVenta(listaConsultaDetalleVenta);
                //venta.getDetalleVenta().add(dv);
                listaConsultaVenta.add(venta);
            }
            
            return listaConsultaVenta;
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+ex.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
            return null;
        } 
        finally {
            con.closeConnection();  //cierra la conexion
        }
    }
     
    public Venta calculoVentaDAO (boolean busqueda ,String calculo, String columna, String fecha, String dato, String col){
        Validar v = new Validar();
        Venta venta;
        
        String query;
        
        if (!busqueda)
            query="SELECT "+calculo+" ("+columna+") as calculo FROM Venta Where MONTH(Fecha_Venta) = "+v.mesActual();
        else
            query="SELECT "+calculo+" ("+columna+") as calculo FROM Venta Where "+fecha+" "+col+" like '"+dato+"%'";
        
        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            if (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt(1));

                return venta;
            }else
                return null;            
        } 
        catch (SQLException ex) {
            return null;
        }finally{
            con.closeConnection();//cierra la conexion  
        }  
    }
    
    public Venta prodNuloDAO (String fecha, String tabla, String dato){
        Validar v = new Validar();
        Venta venta;
        
        String query =  "select COUNT(Estado_Venta) as [Total Nulos]\n" +
                        "from Venta \n" +
                        "where Estado_Venta in (select Estado_Venta from Venta where Estado_Venta = 'NULA') and "
                        +fecha+" "+tabla+" like '"+dato+"%' ";

        ResultSet rs = con.ejecutaConsultaQuery(query);
        
        try {
            if (rs.next()) {
                venta = new Venta();
                venta.setId(rs.getInt(1));

                return venta;
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