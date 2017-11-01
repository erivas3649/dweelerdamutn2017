package ar.com.dweeler.dweeler.modelos;

import ar.com.dweeler.dweeler.R;

/**
 * Created by nemesys on 17/10/17.
 */

public class Dispositivo {

    public enum TIPO {

        SOCKET_TRIPLE(R.drawable.socket),
        SOCKET_SIMPLE(R.drawable.enchufe),
        BOTON(R.drawable.boboton),
        LAMPARA(R.drawable.lampara),
        LLAVERO(R.drawable.llavero),
        GENERICO(R.drawable.dispositivo_generico);

        private final int icono;

        TIPO(int icono) {
            this.icono = icono;
        }

        public int getIcono() {
            return this.icono;
        }
    }

    private String nombre, estado;
    private TIPO tipo;

    public Dispositivo(String nombre) {
        this.nombre = nombre;
    }

    public Dispositivo(String nombre, String estado) {
        this(nombre);
        this.estado = estado;
    }

    public Dispositivo(String nombre, String estado, TIPO tipo) {
        this(nombre, estado);
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TIPO getTipo() {
        return tipo;
    }

    public void setTipo(TIPO tipo) {
        this.tipo = tipo;
    }
}
