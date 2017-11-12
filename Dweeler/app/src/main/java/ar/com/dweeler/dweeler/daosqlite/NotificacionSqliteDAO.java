package ar.com.dweeler.dweeler.daosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import ar.com.dweeler.dweeler.dao.NotificacionDAO;
import ar.com.dweeler.dweeler.modelos.Dispositivo;
import ar.com.dweeler.dweeler.modelos.Notificacion;

/**
 * Created by nemesys on 27/10/17.
 */

public class NotificacionSqliteDAO implements NotificacionDAO {

    private SqliteHelper dbHelper;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public NotificacionSqliteDAO(Context context) {
        dbHelper = SqliteHelper.getInstance(context);
    }

    @Override
    public List<Notificacion> findAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("notificaciones",null,null,null,null,null,null);
        List<Notificacion> notificaciones = traverseCursor(cursor);
        db.close();
        return notificaciones;
    }

    @Override
    public Notificacion findOne(Integer id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("notificaciones",null, "id=?", new String[] {"" + id},null,null,null);
        List<Notificacion> notificaciones = traverseCursor(cursor);
        db.close();
        return notificaciones.size() > 0 ? notificaciones.get(0) : null;
    }

    @Override
    public boolean insert(Notificacion instance) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", instance.getId());
        values.put("mensaje", instance.getMensaje());
        values.put("fecha", dateFormat.format(instance.getFecha()));
        int id = (int) db.insert("notificaciones", null, values);
        db.close();
        return id != -1;
    }

    @Override
    public boolean update(Notificacion instance) {
        return false;
    }

    @Override
    public boolean remove(Notificacion instance) {
        return false;
    }

    private List<Notificacion> traverseCursor (Cursor cursor) {
        List<Notificacion> notificaciones = new ArrayList<>();
        if (cursor.isBeforeFirst()) {
            Notificacion notificacion = null;
            int idxId = -1;
            int idxMensaje = -1;
            int idxFecha = -1;
            idxId = cursor.getColumnIndex("id");
            idxMensaje = cursor.getColumnIndex("mensaje");
            idxFecha = cursor.getColumnIndex("fecha");
            while (cursor.moveToNext()) {
                notificacion = new Notificacion();
                notificacion.setId(cursor.getInt(idxId));
                notificacion.setMensaje(cursor.getString(idxMensaje));
                try {
                    notificacion.setFecha(dateFormat.parse(cursor.getString(idxFecha)));
                } catch (ParseException e) {}
                notificaciones.add(notificacion);
            }
        }
        cursor.close();
        return notificaciones;
    }
}
