package com.example.matias.dweeler;

/**
 * Created by Matias on 30/09/2017.
 */

public class Hogar {
    public static final int TYPE_HOGAR = 1;

    private int type;
    private String hogar;
    private String direccion;
    private String btMenuVertical;

    public static int getTypeHogar() {
        return TYPE_HOGAR;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHogar() {
        return hogar;
    }

    public void setHogar(String hogar) {
        this.hogar = hogar;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBtMenuVertical() {
        return btMenuVertical;
    }

    public void setBtMenuVertical(String btMenuVertical) {
        this.btMenuVertical = btMenuVertical;
    }
}
