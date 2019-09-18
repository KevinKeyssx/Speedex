package Clases;

import Persistencia.ConfiguracionDAO;

/**
 * @author keiss
 */
public class Configurar {
    
    private int id;
    private int permisoEmpleado;
    private int stockMinimo;
    private int stockMaximo;
    private int iniciarSesion;
    private String idEmpleado;
    private String contraseña;
    private int ventana;

    public Configurar() {
    }

    public Configurar(int id, int permisoEmpleado, int stockMinimo, int stockMaximo, int iniciarSesion, String idEmpleado, String contraseña, int ventana) {
        this.id = id;
        this.permisoEmpleado = permisoEmpleado;
        this.stockMinimo = stockMinimo;
        this.stockMaximo = stockMaximo;
        this.iniciarSesion = iniciarSesion;
        this.idEmpleado = idEmpleado;
        this.contraseña = contraseña;
        this.ventana = ventana;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPermisoEmpleado() {
        return permisoEmpleado;
    }

    public void setPermisoEmpleado(int permisoEmpleado) {
        this.permisoEmpleado = permisoEmpleado;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public int getStockMaximo() {
        return stockMaximo;
    }

    public void setStockMaximo(int stockMaximo) {
        this.stockMaximo = stockMaximo;
    }

    public int getIniciarSesion() {
        return iniciarSesion;
    }

    public void setIniciarSesion(int iniciarSesion) {
        this.iniciarSesion = iniciarSesion;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getVentana() {
        return ventana;
    }

    public void setVentana(int ventana) {
        this.ventana = ventana;
    }
    
    public Configurar buscarConfiguracion(){
        ConfiguracionDAO sqldao = new ConfiguracionDAO();//instancia ClienteDao
        Configurar conf = sqldao.buscarConfiguracionDAO();
        
        if(conf != null)
            return conf;
        else
            return null;
    }
    
    public boolean actualizarConfiguracion(){
        ConfiguracionDAO conf = new ConfiguracionDAO();//instancia ClienteDao
        return conf.actualizarConfiguracionDAO(this); 
    }
}