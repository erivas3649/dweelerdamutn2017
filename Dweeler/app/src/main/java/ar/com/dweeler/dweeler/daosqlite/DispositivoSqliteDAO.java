package ar.com.dweeler.dweeler.daosqlite;

import android.content.Context;

import java.util.List;

import ar.com.dweeler.dweeler.dao.DispositivoDAO;
import ar.com.dweeler.dweeler.modelos.Dispositivo;

/**
 * Created by nemesys on 27/10/17.
 */

public class DispositivoSqliteDAO implements DispositivoDAO {

    private SqliteHelper dbHelper;

    public DispositivoSqliteDAO (Context context) {
        dbHelper = SqliteHelper.getInstance(context);
    }

    @Override
    public List<Dispositivo> findAll() {
        return null;
    }

    @Override
    public Dispositivo findOne(Integer id) {
        return null;
    }

    @Override
    public boolean insert(Dispositivo instance) {
        return false;
    }

    @Override
    public boolean update(Dispositivo instance) {
        return false;
    }

    @Override
    public boolean remove(Dispositivo instance) {
        return false;
    }
}
