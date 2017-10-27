package ar.com.dweeler.dweeler.modelos;

import ar.com.dweeler.dweeler.R;

/**
 * Created by nemesys on 17/10/17.
 */

public class Integrante {

    private String nombre, email;
    private int icono;

    public Integrante (String nombre){
        this.nombre = nombre;
    }

    public Integrante (String nombre, String email) {
        this(nombre);
        this.email = email;
    }

    public Integrante (String nombre, String email, int icono) {
        this(nombre, email);
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIcono() {
        return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
