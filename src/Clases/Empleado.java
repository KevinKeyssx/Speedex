package Clases;

import Persistencia.EmpleadoDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class Empleado {
    
    private String idEmpleado;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private String rut;
    private String contraseña;
    private String tipo;

    public Empleado(String idEmpleado, String nombre, String apellidoP, String apellidoM, String rut, String contraseña, String tipo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.rut = rut;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }
    
    public Empleado(){}

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public boolean insertarEmpleado(){
        EmpleadoDAO sql = new EmpleadoDAO();//instancia ClienteDao
        
        if(sql.InsertarEmpleadoDAO(this))
            return true;
        else
            return false;
    }

    // llama al metodo Actualizar Cliente   
    public boolean actualizarEmpleado(){
        EmpleadoDAO empdao = new EmpleadoDAO();//instancia ClienteDao
        return empdao.actualizarEmpleadoDAO(this); 
    }
    
    //   llama al metodo Buscar Empleado por codigo y contraseña
    public Empleado buscarEmpleado(String codigo, String contraseña){
        EmpleadoDAO sqldao = new EmpleadoDAO();//instancia ClienteDao
        Empleado empl = sqldao.buscarEmpleadoDAO(codigo, contraseña);
        
        if(empl != null)
            return empl;
        else
            return null;
    }
    
    public Empleado obtenerCodigo(){
        EmpleadoDAO sqldao = new EmpleadoDAO();//instancia ClienteDao
        Empleado empl = sqldao.obtenerCodigoDAO();
        
        if(empl != null){
            this.setRut(empl.getRut());
            return empl;
        }else
            return null;
        
    }
    
    public boolean eliminarEmpleado(String id){
        EmpleadoDAO empdao = new EmpleadoDAO();//instancia ClienteDao
        return empdao.eliminarEmpleadoDao(id);
    }
     
    public ArrayList<Empleado> buscarDatosEmpleado(boolean busqueda, String tabla, String dato){
        EmpleadoDAO empdao = new EmpleadoDAO();//instancia ClienteDao
        return empdao.buscarDatosEmpleadoDAO(busqueda, tabla, dato);
    }
}