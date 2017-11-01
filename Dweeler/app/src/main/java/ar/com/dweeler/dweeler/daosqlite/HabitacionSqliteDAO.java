package ar.com.dweeler.dweeler.daosqlite;


import android.content.Context;

import java.util.List;

import ar.com.dweeler.dweeler.dao.HabitacionDAO;
import ar.com.dweeler.dweeler.modelos.Habitacion;

/**
 * Created by nemesys on 27/10/17.
 */

public class HabitacionSqliteDAO implements HabitacionDAO {

    private SqliteHelper dbHelper;

    public HabitacionSqliteDAO (Context context) {
        dbHelper = SqliteHelper.getInstance(context);
    }

    @Override
    public List<Habitacion> findAll() {
        return null;
    }

    @Override
    public Habitacion findOne(Integer id) {
        return null;
    }

    @Override
    public boolean insert(Habitacion instance) {
        return false;
    }

    @Override
    public boolean update(Habitacion instance) {
        return false;
    }

    @Override
    public boolean remove(Habitacion instance) {
        return false;
    }
}
