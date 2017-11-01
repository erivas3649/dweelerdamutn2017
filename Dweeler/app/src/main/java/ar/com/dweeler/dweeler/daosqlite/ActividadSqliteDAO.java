package ar.com.dweeler.dweeler.daosqlite;

import android.content.Context;

import java.util.List;

import ar.com.dweeler.dweeler.dao.ActividadDAO;
import ar.com.dweeler.dweeler.modelos.Actividad;

/**
 * Created by nemesys on 27/10/17.
 */

public class ActividadSqliteDAO implements ActividadDAO {

    private SqliteHelper dbHelper;

    public ActividadSqliteDAO (Context context) {
        dbHelper = SqliteHelper.getInstance(context);
    }

    @Override
    public List<Actividad> findAll() {
        return null;
    }

    @Override
    public Actividad findOne(Integer id) {
        return null;
    }

    @Override
    public boolean insert(Actividad instance) {
        return false;
    }

    @Override
    public boolean update(Actividad instance) {
        return false;
    }

    @Override
    public boolean remove(Actividad instance) {
        return false;
    }
}
