package ar.com.dweeler.dweeler.daosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
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
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("hogares",null,null,null,null,null,null);
        List<Hogar> hogares = new ArrayList<>();
        if (cursor.isBeforeFirst()) {
            Hogar hogar = null;
            int idxId = -1;
            int idxNombre = -1;
            int idxTipo = -1;
            int idxDireccion = -1;
            idxId = cursor.getColumnIndex("id");
            idxNombre = cursor.getColumnIndex("nombre");
            idxDireccion = cursor.getColumnIndex("direccion");
            idxTipo = cursor.getColumnIndex("tipo");
            while (cursor.moveToNext()) {
                hogar = new Hogar();
                hogar.setId(cursor.getInt(idxId));
                hogar.setNombre(cursor.getString(idxNombre));
                hogar.setDireccion(cursor.getString(idxDireccion));
                hogar.setTipo(Hogar.convertirTipo(cursor.getInt(idxTipo)));
                hogares.add(hogar);
            }
        }
        cursor.close();
        db.close();
        return hogares;
    }

    @Override
    public Hogar findOne(Integer id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("hogares",null, "id=?", new String[]{"" + id},null,null,null);
        Hogar hogar = null;
        if (cursor.isBeforeFirst()) {
            int idxId = -1;
            int idxNombre = -1;
            int idxTipo = -1;
            int idxDireccion = -1;
            idxId = cursor.getColumnIndex("id");
            idxNombre = cursor.getColumnIndex("nombre");
            idxDireccion = cursor.getColumnIndex("direccion");
            idxTipo = cursor.getColumnIndex("tipo");
            if (cursor.moveToNext()) {
                hogar = new Hogar();
                hogar.setId(cursor.getInt(idxId));
                hogar.setNombre(cursor.getString(idxNombre));
                hogar.setDireccion(cursor.getString(idxDireccion));
                hogar.setTipo(Hogar.convertirTipo(cursor.getInt(idxTipo)));
            }
        }
        cursor.close();
        db.close();
        return hogar;
    }

    @Override
    public boolean insert(Hogar instance) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", instance.getId());
        values.put("nombre", instance.getNombre());
        values.put("direccion", instance.getDireccion());
        values.put("tipo", instance.getTipo().getValor());
        int id = (int) db.insert("hogares", null, values);
        db.close();
        return id != -1;
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
