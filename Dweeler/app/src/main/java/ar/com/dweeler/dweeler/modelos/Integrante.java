package ar.com.dweeler.dweeler.modelos;

import org.json.JSONException;
import org.json.JSONObject;

import ar.com.dweeler.dweeler.R;

/**
 * Created by nemesys on 17/10/17.
 */

public class Integrante {

    private String nombre, email;
    private int id;

    public Integrante(){ }

    public Integrante (String nombre){
        this.nombre = nombre;
    }

    public Integrante (String nombre, String email) {
        this(nombre);
        this.email = email;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Integrante parse (JSONObject json) throws JSONException {
        Integrante i = new Integrante();
        i.setId(json.getInt("id"));
        i.setNombre(json.getString("nombre"));
        i.setEmail(json.getString("email"));
        return i;
    }
}
