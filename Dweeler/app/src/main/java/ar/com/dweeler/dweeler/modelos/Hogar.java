package ar.com.dweeler.dweeler.modelos;

import ar.com.dweeler.dweeler.R;

/**
 * Created by nemesys on 17/10/17.
 */

public class Hogar {

    public enum TIPO {
        HOGAR (R.drawable.hogar),
        OFICINA (R.drawable.oficina),
        ESPACIO (R.drawable.espacios);

        private final int icono;

        TIPO (int icono) {
            this.icono = icono;
        }

        public int getIcono() {
            return this.icono;
        }
    };

    private String nombre, direccion;
    private TIPO tipo;

    public Hogar(String nombre) {
        this.nombre = nombre;
    }

    public Hogar(String nombre, String direccion) {
        this(nombre);
        this.direccion = direccion;
    }

    public Hogar(String nombre, String direccion, TIPO tipo) {
        this(nombre, direccion);
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }
}
