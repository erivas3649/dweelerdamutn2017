package ar.com.dweeler.dweeler.modelos;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nemesys on 17/10/17.
 */

public class Notificacion {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
    private int id;
    private String mensaje;
    private Date fecha;

    public Notificacion() {

    }

    public Notificacion (String mensaje, Date fecha) {
        this.mensaje = mensaje;
        this.fecha =fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getFechaFormateada() {
        return dateFormat.format(this.fecha);
    }

    public static Notificacion parse(JSONObject json) throws JSONException {
        Notificacion n = new Notificacion();
        n.setId(json.getInt("id"));
        n.setMensaje(json.getString("mensaje"));
        //n.setFecha(json.getString("fecha"));
        return n;
    }
}
