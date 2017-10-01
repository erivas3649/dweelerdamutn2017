package com.example.matias.dweeler;

/**
 * Created by Matias on 01/10/2017.
 */

public class Dispositivo {
    public static final int TYPE_IMG = 1;

    private int type;
    private String dispositivo;
    private String conexion;
    private String accion;
    private String btMenuVertical;
    private String btMenuPlay;

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getBtMenuPlay() {
        return btMenuPlay;
    }

    public void setBtMenuPlay(String btMenuPlay) {
        this.btMenuPlay = btMenuPlay;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getConexion() {
        return conexion;
    }

    public void setConexion(String conexion) {
        this.conexion = conexion;
    }

    public String getBtMenuVertical() {
        return btMenuVertical;
    }

    public void setBtMenuVertical(String btMenuVertical) {
        this.btMenuVertical = btMenuVertical;
    }
}
