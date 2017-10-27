package ar.com.dweeler.dweeler.daosqlite;

import android.content.Context;

import java.util.List;

import ar.com.dweeler.dweeler.dao.HogarDAO;
import ar.com.dweeler.dweeler.modelos.Hogar;

/**
 * Created by nemesys on 27/10/17.
 */

public class HogarSqliteDAO implements HogarDAO {

    private SqliteHelper dbHelper;

    public HogarSqliteDAO (Context context) {
        dbHelper = SqliteHelper.getInstance(context);
    }

    @Override
    public List<Hogar> findAll() {
        return null;
    }

    @Override
    public Hogar findOne(Integer id) {
        return null;
    }

    @Override
    public boolean insert(Hogar instance) {
        return false;
    }

    @Override
    public boolean update(Hogar instance) {
        return false;
    }

    @Override
    public boolean remove(Hogar instance) {
        return false;
    }
}
