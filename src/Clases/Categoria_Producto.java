package Clases;

import Persistencia.Categoria_ProductoDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class Categoria_Producto {
    private int id;
    private String nombre;
    private String descripcion;

    public Categoria_Producto(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Categoria_Producto() {
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public boolean insertarCat_Producto(){
        Categoria_ProductoDAO sql = new Categoria_ProductoDAO();//
        
        if(sql.InsertarCat_ProductoDAO(this))
            return true;
        else
            return false;
    }
    
    public boolean actualizarProveedor(){
        Categoria_ProductoDAO sql = new Categoria_ProductoDAO();//instancia ClienteDao
        return sql.actualizarCatDAO(this);
    }
    
    public Categoria_Producto ObtenerCatId(){
        Categoria_ProductoDAO sqldao = new Categoria_ProductoDAO();//instancia ClienteDao
        Categoria_Producto cat = sqldao.obtenerIdCat(this);
        
        if(cat != null){
            this.setId(cat.getId());
            return cat;
        }else
            return null;
    }
    
    public ArrayList<Categoria_Producto> buscarDatosCategoria(boolean busqueda, String tabla, String dato){
        Categoria_ProductoDAO catdao = new Categoria_ProductoDAO();//instancia ClienteDao
        return catdao.buscarDatosCategoriaDAO(busqueda, tabla, dato);
    }
}