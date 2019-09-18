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
public class DetalleVentaDAO {
    private Conexion con = null;
    
    public DetalleVentaDAO(){
        con = new Conexion();//instancia la conexion
    }
    
    public boolean InsertarDetalleDAO(DetalleVenta dventa){
        try{
            String query = "INSERT INTO DetalleVenta VALUES ("+dventa.getIdVenta()+",'"+dventa.getIdProducto()+"',"
                            +dventa.getCantidad()+","+dventa.getSubTotal()+")";
            
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
    
//    public ArrayList<DetalleVenta> buscarDatosEmpleadoDAO(boolean busqueda, String tabla, String dato){
//        String query;
//        
////        if (busqueda) 
//        query = "select DetalleVenta.Id_Venta, DetalleVenta.Id_Producto, Total_Venta , Cantidad_DetalleVenta," +
//                "Venta.Fecha_Venta, Venta.TipoPago_Venta, Venta.Estado_Venta, " +
//                "DetalleVenta.SubTotal_Detalle, Venta.Id_Empleado, Venta.Recibo, Venta.Vuelto_Venta, Venta.Descuento" +
//                "from DetalleVenta" +
//                "inner join Venta on DetalleVenta.Id_Venta = Venta.Id_Venta" +
//                "inner join Empleado on Empleado.Id_Empleado = Venta.Id_Empleado";
////        else
////            query = "select * from Empleado";
//        
//        ArrayList<DetalleVenta> listaConsultaEmpleado = new ArrayList<DetalleVenta>();
//        
//        ResultSet rs = con.ejecutaConsultaQuery(query);
//        try {
//            while(rs.next()) {
//                DetalleVenta dventa = new DetalleVenta();//instancia clase cliente
//                Venta venta = new Venta();
//                dventa.setIdVenta(rs.getInt("DetalleVenta.Id_Venta"));
//                venta.set(rs.getString("Nombre_Empleado"));
//                dventa.setApellidoP(rs.getString("ApellidoP_Empleado"));
//                dventa.setApellidoM(rs.getString("ApellidoM_Empleado"));
//                dventa.setRut(rs.getString("Rut_Empleado"));
//                dventa.setContraseña(rs.getString("Contraseña_Empleado"));
//                dventa.setTipo(rs.getString("Tipo_Empleado"));
//                listaConsultaEmpleado.add(dventa);
//            }
//            con.closeConnection();//cierra la conexion
//            return listaConsultaEmpleado;
//        } 
//        catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Ocurrió un error! "+ex.getMessage(),"Error de conexión",JOptionPane.ERROR_MESSAGE);
//            return null;
//        } 
//        finally {
//            con.closeConnection();  //cierra la conexion
//        }
//    }  
    
    public Venta prodMasVendidoDAO (String fecha, String tabla, String dato){
        Validar v = new Validar();
        Venta venta = null;
        
        String query =  "select count(Id_Producto) as [Producto Mas Vendido]\n" +
                        "from DetalleVenta \n" +
                        "where Id_Producto = (select MAX(Id_Producto) from DetalleVenta) and "+fecha+" "+tabla+" like '"+dato+"%' ";

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
