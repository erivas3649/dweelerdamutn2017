package com.example.matias.dweeler;

/**
 * Created by Matias on 01/10/2017.
 */

public class Accion {
    public static final int TYPE_MENU = 1;
    public static final int TYPE_PLAY = 2;

    private int type;
    private String accion;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
