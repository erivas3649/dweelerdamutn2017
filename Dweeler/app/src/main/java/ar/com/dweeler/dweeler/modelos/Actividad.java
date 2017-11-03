package ar.com.dweeler.dweeler.modelos;

/**
 * Created by nemesys on 24/10/17.
 */

public class Actividad {

    private String nombre;
    private int idActividad;

    public Actividad(){ }

    public Actividad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }
}
