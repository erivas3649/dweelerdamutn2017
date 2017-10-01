package com.example.matias.dweeler;

/**
 * Created by Matias on 01/10/2017.
 */

public class Habitacion {
    public static final int TYPE_COMEDOR = 1;
    public static final int TYPE_LIVING = 2;
    public static final int TYPE_COCINA = 3;
    public static final int TYPE_DORMITORIO = 4;

    private int type;
    private String habitacion;
    private String quien;
    private String btMenuVertical;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(String habitacion) {
        this.habitacion = habitacion;
    }

    public String getQuien() {
        return quien;
    }

    public void setQuien(String quien) {
        this.quien = quien;
    }

    public String getBtMenuVertical() {
        return btMenuVertical;
    }

    public void setBtMenuVertical(String btMenuVertical) {
        this.btMenuVertical = btMenuVertical;
    }
}
