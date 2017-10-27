package ar.com.dweeler.dweeler.modelos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nemesys on 17/10/17.
 */

public class Notificacion {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
    private String mensaje;
    private Date fecha;

    public Notificacion (String mensaje, Date fecha) {
        this.mensaje = mensaje;
        this.fecha =fecha;
    }

    public static SimpleDateFormat getDateFormat() {
        return dateFormat;
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
}
