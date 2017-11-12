package ar.com.dweeler.dweeler.daosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ar.com.dweeler.dweeler.dao.DispositivoDAO;
import ar.com.dweeler.dweeler.modelos.Dispositivo;
import ar.com.dweeler.dweeler.modelos.Hogar;

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

    public List<Dispositivo> findAllByHogar(Integer hogarId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT d.id, d.nombre, d.estado, d.tipo FROM dispositivos d JOIN habitaciones h ON d.habitacion_id=h.id WHERE h.hogar_id = ?", new String[]{"" + hogarId});
        List<Dispositivo> dispositivos = traverseCursor(cursor);
        db.close();
        return dispositivos;
    }

    public List<Dispositivo> findAllByHabitacion(Integer habitacionId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("dispositivos",null, "habitacion_id=?", new String[]{"" + habitacionId},null,null,null);
        List<Dispositivo> dispositivos = traverseCursor(cursor);
        db.close();
        return dispositivos;
    }

    @Override
    public Dispositivo findOne(Integer id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("dispositivos",null, "id=?", new String[]{"" + id},null,null,null);
        List<Dispositivo> dispositivos = traverseCursor(cursor);
        db.close();
        return dispositivos.size() > 0 ? dispositivos.get(0) : null;
    }

    @Override
    public boolean insert(Dispositivo instance) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("id", instance.getId());
        values.put("nombre", instance.getNombre());
        values.put("estado", instance.getEstado());
        values.put("tipo", instance.getTipo().getValor());
        int id = (int) db.insert("dispositivos", null, values);
        db.close();
        return id != -1;
    }

    @Override
    public boolean update(Dispositivo instance) {
        return false;
    }

    @Override
    public boolean remove(Dispositivo instance) {
        return false;
    }

    private List<Dispositivo> traverseCursor (Cursor cursor) {
        List<Dispositivo> dispositivos = new ArrayList<>();
        if (cursor.isBeforeFirst()) {
            Dispositivo dispositivo = null;
            int idxId = -1;
            int idxNombre = -1;
            int idxTipo = -1;
            int idxEstado = -1;
            idxId = cursor.getColumnIndex("id");
            idxNombre = cursor.getColumnIndex("nombre");
            idxEstado = cursor.getColumnIndex("estado");
            idxTipo = cursor.getColumnIndex("tipo");
            while (cursor.moveToNext()) {
                dispositivo = new Dispositivo();
                dispositivo.setId(cursor.getInt(idxId));
                dispositivo.setNombre(cursor.getString(idxNombre));
                dispositivo.setEstado(cursor.getString(idxEstado));
                dispositivo.setTipo(Dispositivo.TIPO.valueOf(cursor.getInt(idxTipo)));
                dispositivos.add(dispositivo);
            }
        }
        cursor.close();
        return dispositivos;
    }
}
