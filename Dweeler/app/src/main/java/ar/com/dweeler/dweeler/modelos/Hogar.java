package ar.com.dweeler.dweeler.modelos;

import ar.com.dweeler.dweeler.R;

/**
 * Created by nemesys on 17/10/17.
 */

public class Hogar {

    public enum TIPO {
        HOGAR (1, R.drawable.hogar),
        OFICINA (2, R.drawable.oficina),
        ESPACIO (3, R.drawable.espacios);

        private final int icono;
        private final int valor;

        TIPO (int valor, int icono) {
            this.valor = valor;
            this.icono = icono;
        }

        public int getIcono() {
            return this.icono;
        }

        public int getValor() {
            return valor;
        }

        public static TIPO valueOf(int idx) {
            TIPO retorno = null;
            for (TIPO tipo : values()){
                if (tipo.getValor() == idx) {
                    retorno = tipo;
                    break;
                }
            }
            return retorno;
        }
    };

    private int id;
    private String nombre, direccion;
    private TIPO tipo;

    public Hogar() {
    }

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
