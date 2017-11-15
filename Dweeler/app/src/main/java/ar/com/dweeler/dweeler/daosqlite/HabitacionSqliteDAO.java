package ar.com.dweeler.dweeler.daosqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ar.com.dweeler.dweeler.dao.HabitacionDAO;
import ar.com.dweeler.dweeler.modelos.Habitacion;
import ar.com.dweeler.dweeler.modelos.Hogar;

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
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("habitaciones",null,null,null,null,null,null);
        List<Habitacion> habitaciones = traverseCursor(cursor);
        db.close();
        return habitaciones;
    }

    @Override
    public List<Habitacion> findAllByHogar(int hogarId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("habitaciones",null,"hogar_id=?", new String[] {"" + hogarId},null,null,null);
        List<Habitacion> habitaciones = traverseCursor(cursor);
        cursor.close();
        db.close();
        return habitaciones;
    }

    @Override
    public Habitacion findOne(Integer id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("habitaciones",null, "id=?", new String[]{"" + id},null,null,null);
        List<Habitacion> habitaciones = traverseCursor(cursor);
        db.close();
        return habitaciones.size() > 0 ? habitaciones.get(0) : null;
    }

    @Override
    public boolean insert(Habitacion instance, Hogar hogarInstance) {
        int id = -1;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT id FROM habitaciones WHERE id=?", new String[] {"" + instance.getId()});
        if(c.getCount() == 0) {
            ContentValues values = new ContentValues();
            values.put("id", instance.getId());
            values.put("nombre", instance.getNombre());
            values.put("descripcion", instance.getDescripcion());
            values.put("tipo", instance.getTipo().getValor());
            values.put("hogar_id", hogarInstance.getId());
            id = (int) db.insert("habitaciones", null, values);
        }
        c.close();
        db.close();
        return id != -1;
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

    private List<Habitacion> traverseCursor (Cursor cursor) {
        List<Habitacion> habitaciones = new ArrayList<>();
        if (cursor.isBeforeFirst()) {
            Habitacion habitacion = null;
            int idxId = -1;
            int idxNombre = -1;
            int idxDescripcion = -1;
            int idxTipo = -1;
            idxId = cursor.getColumnIndex("id");
            idxNombre = cursor.getColumnIndex("nombre");
            idxDescripcion = cursor.getColumnIndex("descripcion");
            idxTipo = cursor.getColumnIndex("tipo");
            while (cursor.moveToNext()) {
                habitacion = new Habitacion();
                habitacion.setId(cursor.getInt(idxId));
                habitacion.setNombre(cursor.getString(idxNombre));
                habitacion.setDescripcion(cursor.getString(idxDescripcion));
                habitacion.setTipo(Habitacion.TIPO.valueOf(cursor.getInt(idxTipo)));
                habitaciones.add(habitacion);
            }
        }
        cursor.close();
        return habitaciones;
    }
}
