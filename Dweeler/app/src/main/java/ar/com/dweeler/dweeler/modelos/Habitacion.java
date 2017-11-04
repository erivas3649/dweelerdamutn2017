package ar.com.dweeler.dweeler.modelos;

import ar.com.dweeler.dweeler.R;

/**
 * Created by nemesys on 17/10/17.
 */

public class Habitacion {

    public enum TIPO {

        COCINA(1, R.drawable.cocina),
        COMEDOR(2, R.drawable.comedor),
        LIVING(3, R.drawable.living),
        DORMITORIO(4, R.drawable.dormitorio),
        OFICINA(5, R.drawable.habitacion_oficina),
        GENERICA(6, R.drawable.habitacion_generica);

        private final int icono;
        private final int valor;

        TIPO(int valor, int icono) {
            this.valor = valor;
            this.icono = icono;
        }

        public int getValor() {
            return valor;
        }

        public static TIPO valueOf(int idx){
            TIPO retorno = null;
            for (TIPO tipo : values()){
                if(tipo.getValor() == idx){
                    retorno = tipo;
                    break;
                }
            }
            return retorno;
        }

        public int getIcono() {
            return this.icono;
        }
    }

    private String nombre, descripcion;
    private TIPO tipo;
    private int idHabitacion;

    public Habitacion(){ }

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

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
}
