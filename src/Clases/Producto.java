package Clases;

import Persistencia.ProductoDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class Producto {
    
    private String id;
    private String nombre;
    private int stock;
    private int precio;
    private int id_categoria;
    private int id_proveedor;
    private int activo;
    private int id_dimension;

    public Producto(String id, String nombre, int stock, int precio, int id_categoria, int id_proveedor, int activo, int id_dimension) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.id_categoria = id_categoria;
        this.id_proveedor = id_proveedor;
        this.activo = activo;
        this.id_dimension = id_dimension;
    }   

    public Producto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    public int getId_dimension() {
        return id_dimension;
    }

    public void setId_dimension(int id_dimension) {
        this.id_dimension = id_dimension;
    }
    
    public boolean insertarProducto(){
        ProductoDAO sql = new ProductoDAO();//
        return sql.InsertarProductoDAO(this);
    }
    
    public Producto buscarProducto(String id){
        ProductoDAO prodao = new ProductoDAO();//instancia 
        Producto prod = prodao.buscarProductoDAO(id);
        
        if(prod != null)
            return prod; 
        else
            return null;
    }
    
    public boolean actualizarProducto(){
        ProductoDAO prdao = new ProductoDAO();//instancia ClienteDao
        return prdao.actualizarProductoDAO(this);
    }
     
    //llama al metodo Eliminar producto
    public boolean eliminarProducto(int id){
        ProductoDAO prdao = new ProductoDAO();//instancia ClienteDao
        return prdao.eliminarProductoDao(id);
    }
    
    public ArrayList<Producto> buscarDatosProducto(boolean busqueda, String texto, String tabla, boolean producto){
        ProductoDAO empdao = new ProductoDAO();//instancia ClienteDao
        return empdao.buscarDatosProductoDAO(busqueda, texto, tabla, producto);
    }
}