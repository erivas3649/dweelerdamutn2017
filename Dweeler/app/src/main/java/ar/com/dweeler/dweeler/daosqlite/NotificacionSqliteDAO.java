package ar.com.dweeler.dweeler.daosqlite;

import android.content.Context;

import java.util.List;

import ar.com.dweeler.dweeler.dao.NotificacionDAO;
import ar.com.dweeler.dweeler.modelos.Notificacion;

/**
 * Created by nemesys on 27/10/17.
 */

public class NotificacionSqliteDAO implements NotificacionDAO {

    private SqliteHelper dbHelper;

    public NotificacionSqliteDAO(Context context) {
        dbHelper = SqliteHelper.getInstance(context);
    }

    @Override
    public List<Notificacion> findAll() {
        return null;
    }

    @Override
    public Notificacion findOne(Integer id) {
        return null;
    }

    @Override
    public boolean insert(Notificacion instance) {
        return false;
    }

    @Override
    public boolean update(Notificacion instance) {
        return false;
    }

    @Override
    public boolean remove(Notificacion instance) {
        return false;
    }
}
