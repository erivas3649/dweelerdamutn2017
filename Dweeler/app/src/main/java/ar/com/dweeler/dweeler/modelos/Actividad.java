package ar.com.dweeler.dweeler.modelos;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by nemesys on 24/10/17.
 */

public class Actividad {

    private String nombre;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Actividad parse (JSONObject json) throws JSONException {
        Actividad a = new Actividad();
        a.setId(json.getInt("id"));
        a.setNombre(json.getString("nombre"));
        return a;
    }
}
