package Clases;

import Persistencia.SQLDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class Cliente {
    
    private String rut;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String direccion;
    private String correo;
    private int fono;

    public Cliente(String rut, String nombre, String apellidoP, String apellidoM, String direccion, String correo, int fono) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.direccion = direccion;
        this.correo = correo;
        this.fono = fono;
    }
    
    public Cliente(){
    }
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getFono() {
        return fono;
    }

    public void setFono(int fono) {
        this.fono = fono;
    }
    
    public boolean insertarCliente(){
        SQLDAO sql = new SQLDAO();//instancia ClienteDao
        
        if(sql.InsertarClienteDAO(this))
            return true;
        else
            return false;
    }
     
    //   llama al metodo Buscar Cliente por Rut
    public Cliente buscarCliente(String rut){
        SQLDAO sql = new SQLDAO();//instancia ClienteDao
        Cliente clie2 = sql.buscarClienteDAO(rut);
        
        if(clie2 != null){
            this.setRut(clie2.getRut());
            return clie2;
        }else
            return null;
    }
    
    // llama al metodo Actualizar Cliente   
    public boolean actualizarCliente(){
        SQLDAO sql = new SQLDAO();//instancia ClienteDao
        return sql.actualizarClienteDAO(this);
    }
    
    //llama al metodo Eliminar Cliente   
    public boolean eliminarCliente(String rut){
        SQLDAO sql = new SQLDAO();//instancia ClienteDao
        return sql.eliminarClienteDao(rut);
    }
    
    public ArrayList<Cliente> buscarDatosCliente(boolean busqueda, String tabla, String dato, String seleccion){
        SQLDAO cliente = new SQLDAO();//instancia ClienteDao
        return cliente.buscarDatosClienteDAO(busqueda, tabla, dato, seleccion);
    }
}