package Clases;

import Persistencia.ConductorDAO;

/**
 * @author keiss
 */
public class Conductor {
    private int id;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    private int idMovil;

    public Conductor(int id, String nombre, String apellidoP, String apellidoM, int idMovil) {
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.idMovil = idMovil;
    }

    public Conductor() {
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

    public int getIdMovil() {
        return idMovil;
    }

    public void setIdMovil(int idMovil) {
        this.idMovil = idMovil;
    }
    
    public Conductor calculoConductor(String calculo, String columna){
        ConductorDAO sql = new ConductorDAO();
        return sql.calculoConductorDAO(calculo, columna);
    }
}
