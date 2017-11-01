package ar.com.dweeler.dweeler.daosqlite;

import android.content.Context;

import java.util.List;

import ar.com.dweeler.dweeler.dao.IntegranteDAO;
import ar.com.dweeler.dweeler.modelos.Integrante;

/**
 * Created by nemesys on 27/10/17.
 */

public class IntegranteSqliteDAO implements IntegranteDAO {

    private SqliteHelper dbHelper;

    public IntegranteSqliteDAO (Context context) {
        dbHelper = SqliteHelper.getInstance(context);
    }

    @Override
    public List<Integrante> findAll() {
        return null;
    }

    @Override
    public Integrante findOne(Integer id) {
        return null;
    }

    @Override
    public boolean insert(Integrante instance) {
        return false;
    }

    @Override
    public boolean update(Integrante instance) {
        return false;
    }

    @Override
    public boolean remove(Integrante instance) {
        return false;
    }
}
