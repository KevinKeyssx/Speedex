package Clases;

import Persistencia.MovilDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class Movil {
    private int id;
    private String marca;
    private String modelo;
    private String patente;
    private String tipo;
    private int idDimension;

    public Movil(int id, String marca, String modelo, String patente, String tipo, int idDimension) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.tipo = tipo;
        this.idDimension = idDimension;
    }

    public Movil() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdDimension() {
        return idDimension;
    }

    public void setIdDimension(int idDimension) {
        this.idDimension = idDimension;
    }
    
    public boolean insertarMovil(){
        MovilDAO sql = new MovilDAO();//
        return sql.InsertarMovilDAO(this);
    }
    
    public boolean actualizarMovil(){
        MovilDAO prdao = new MovilDAO();//instancia ClienteDao
        return prdao.actualizarMovilDAO(this);
    }
    
    public ArrayList<Movil> buscarDatosMovil(boolean busqueda, String texto, String tabla){
        MovilDAO empdao = new MovilDAO();//instancia ClienteDao
        return empdao.buscarDatosMovilDAO(busqueda, texto, tabla);
    } 
}