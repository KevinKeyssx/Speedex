package Clases;

import Persistencia.ProveedorDAO;
import java.util.ArrayList;

/**
 *
 * @author keiss
 */
public class Proveedor {
    
    private int id;
    private String nombre;
    private String rut;
    private String telefono;
    private String direccion;
    private int activo;
    
    public Proveedor buscarID(){
        ProveedorDAO prodao = new ProveedorDAO();
        return prodao.buscarId();
    }

    public Proveedor(int id, String nombre, String rut, String telefono, String direccion, int activo) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.telefono = telefono;
        this.direccion = direccion;
        this.activo = activo;
    }
    
    public Proveedor(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    public boolean insertarProveedor(){
        ProveedorDAO sql = new ProveedorDAO();//
        
        if(sql.InsertarProveedorDAO(this))
            return true;
        else
            return false;
    }
    
    public Proveedor buscarProveedor(int rut){
        ProveedorDAO provDao = new ProveedorDAO();//instancia ClienteDao
        Proveedor prov = provDao.buscarProveedorDAO(rut);
        
        if(prov != null)
            return prov;
        else
            return null;
    } 
    
    public boolean actualizarProveedor(){
        ProveedorDAO provdao = new ProveedorDAO();//instancia ClienteDao
        return provdao.actualizarProveedorDAO(this);
    }
    
       public boolean eliminarProveedor(int id){
        ProveedorDAO provDao = new ProveedorDAO();//instancia ClienteDao
        return provDao.eliminarProveedorDao(id);
    }
       
    public ArrayList<Proveedor> buscarDatosProveedor(boolean busqueda, String tabla, String dato){
        ProveedorDAO empdao = new ProveedorDAO();//instancia ClienteDao
        return empdao.buscarDatosProveedorDAO(busqueda, tabla, dato);
    }
     
}
