package ar.com.dweeler.dweeler.modelos;

import ar.com.dweeler.dweeler.R;

/**
 * Created by nemesys on 17/10/17.
 */

public class Habitacion {

    public enum TIPO {

        COCINA(R.drawable.cocina),
        COMEDOR(R.drawable.comedor),
        LIVING(R.drawable.living),
        DORMITORIO(R.drawable.dormitorio),
        OFICINA(R.drawable.habitacion_oficina),
        GENERICA(R.drawable.habitacion_generica);

        private final int icono;

        TIPO(int icono) {
            this.icono = icono;
        }

        public int getIcono() {
            return this.icono;
        }
    }

    private String nombre, descripcion;
    private TIPO tipo;

    public Habitacion(String nombre) {
        this.nombre = nombre;
    }

    public Habitacion(String nombre, String descripcion) {
        this(nombre);
        this.descripcion = descripcion;
    }

    public Habitacion(String nombre, String descripcion, TIPO tipo) {
        this(nombre, descripcion);
        this.tipo = tipo;
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

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }
}
