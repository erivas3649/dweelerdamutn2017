package ar.com.dweeler.dweeler.daosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
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
    public List<Actividad> findAll(){
        return null;
    }

    public List<Actividad> findAllByHabitacion(Integer idHabitacion) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("actividades",null,"habitacion_id=?",new String[]{"" + idHabitacion},null,null,null);
        List<Actividad> actividades = new ArrayList<>();
        if (cursor.isBeforeFirst()) {
            Actividad actividad = null;
            int idxId = -1;
            int idxNombre = -1;
            idxId = cursor.getColumnIndex("id");
            idxNombre = cursor.getColumnIndex("nombre");
            while (cursor.moveToNext()) {
                actividad = new Actividad();
                actividad.setIdActividad(cursor.getInt(idxId));
                actividad.setNombre(cursor.getString(idxNombre));
                actividades.add(actividad);
            }
        }
        cursor.close();
        db.close();
        return actividades;
    }

    @Override
    public Actividad findOne(Integer id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("habitaciones",null, "id=?", new String[]{"" + id},null,null,null);
        Actividad actividad = null;
        if (cursor.isBeforeFirst()) {
            int idxId = -1;
            int idxNombre = -1;
            idxId = cursor.getColumnIndex("id");
            idxNombre = cursor.getColumnIndex("nombre");
            if (cursor.moveToNext()) {
                actividad = new Actividad();
                actividad.setIdActividad(cursor.getInt(idxId));
                actividad.setNombre(cursor.getString(idxNombre));
            }
        }
        cursor.close();
        db.close();
        return actividad;
    }

    @Override
    public boolean insert(Actividad instance) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", instance.getIdActividad());
        values.put("nombre", instance.getNombre());
        int id = (int) db.insert("actividades", null, values);
        db.close();
        return id != -1;
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
