package ar.com.dweeler.dweeler.modelos;

import org.json.JSONException;
import org.json.JSONObject;

import ar.com.dweeler.dweeler.R;

/**
 * Created by nemesys on 17/10/17.
 */

public class Dispositivo {

    public enum TIPO {

        SOCKET_TRIPLE(1, R.drawable.socket),
        SOCKET_SIMPLE(2, R.drawable.enchufe),
        BOTON(3, R.drawable.boboton),
        LAMPARA(4, R.drawable.lampara),
        LLAVERO(5, R.drawable.llavero),
        GENERICO(6, R.drawable.dispositivo_generico);

        private final int icono;
        private final int valor;

        TIPO(int valor, int icono) {
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
    }

    private int id;
    private String nombre, estado;
    private TIPO tipo;

    public Dispositivo() {
    }

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

    public static Dispositivo parse (JSONObject json) throws JSONException {
        Dispositivo di = new Dispositivo();
        di.setId(json.getInt("id"));
        di.setNombre(json.getString("nombre"));
        di.setEstado(json.getString("estado"));
        di.setTipo(TIPO.valueOf(json.getInt("tipo")));
        return di;
    }

}
