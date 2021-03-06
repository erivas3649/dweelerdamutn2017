package ar.com.dweeler.dweeler.daosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ar.com.dweeler.dweeler.dao.ActividadDAO;
import ar.com.dweeler.dweeler.modelos.Actividad;
import ar.com.dweeler.dweeler.modelos.Habitacion;

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

    @Override
    public List<Actividad> findAllByHabitacion(Integer idHabitacion) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("actividades",null,"habitacion_id=?",new String[]{"" + idHabitacion},null,null,null);
        List<Actividad> actividades = traverseCursor(cursor);
        db.close();
        return actividades;
    }

    @Override
    public Actividad findOne(Integer id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("actividades",null, "id=?", new String[]{"" + id},null,null,null);
        List<Actividad> actividades = traverseCursor(cursor);
        db.close();
        return actividades.size() > 0 ? actividades.get(0) : null;
    }

    @Override
    public boolean insert(Actividad instance, Habitacion habitacionInstance) {
        int id = -1;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT id FROM actividades WHERE id=?", new String[] {"" + instance.getId()});
        if(c.getCount() == 0) {
            ContentValues values = new ContentValues();
            values.put("id", instance.getId());
            values.put("nombre", instance.getNombre());
            values.put("habitacion_id", habitacionInstance.getId());
            id = (int) db.insert("actividades", null, values);
        }
        c.close();
        db.close();
        return id != -1;
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

    private List<Actividad> traverseCursor (Cursor cursor) {
        List<Actividad> actividades = new ArrayList<>();
        if (cursor.isBeforeFirst()) {
            Actividad actividad = null;
            int idxId = -1;
            int idxNombre = -1;
            idxId = cursor.getColumnIndex("id");
            idxNombre = cursor.getColumnIndex("nombre");
            while (cursor.moveToNext()) {
                actividad = new Actividad();
                actividad.setId(cursor.getInt(idxId));
                actividad.setNombre(cursor.getString(idxNombre));
                actividades.add(actividad);
            }
        }
        cursor.close();
        return actividades;
    }
}
