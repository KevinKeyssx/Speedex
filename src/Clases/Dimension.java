package Clases;

import Persistencia.DimensionDAO;
import java.util.ArrayList;

/**
 * @author keiss
 */
public class Dimension {
    private int numero;
    private double alto;
    private double ancho;
    private double largo;
    private double peso;

    public Dimension() {
    }

    public Dimension(int numero, int alto, int ancho, int largo, int peso) {
        this.numero = numero;
        this.alto = alto;
        this.ancho = ancho;
        this.largo = largo;
        this.peso = peso;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public boolean insertarDimension(String tabla){
        DimensionDAO sql = new DimensionDAO();//instancia ventadao
        return sql.InsertarDimensionDAO(this, tabla);
    }
    
     public boolean modificarDimension(String tabla){
        DimensionDAO sql = new DimensionDAO();//instancia ventadao
        return sql.modificarDimensionDAO(this, tabla);
    }
    
    public Dimension buscarDimension(String codigo, boolean inner, int idDimension){
        DimensionDAO dimdao = new DimensionDAO();//instancia 
        return dimdao.buscarDimensionDAO(codigo, inner, idDimension); 
    }
    
    public ArrayList<Dimension> buscarDatosDimension(boolean busqueda, String dato, String columna, String tabla){
        DimensionDAO sql = new DimensionDAO();//instancia ClienteDao
        return sql.buscarDatosDimensionDAO(busqueda, dato, columna, tabla);
    }
    
    public Dimension calculaDimension(String calculo, String columna, int id){
        DimensionDAO dao = new DimensionDAO();
        return dao.calculoVentaDAO(calculo, columna, id);  
    }
}