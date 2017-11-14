package ar.com.dweeler.dweeler.daosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import ar.com.dweeler.dweeler.dao.IntegranteDAO;
import ar.com.dweeler.dweeler.modelos.Hogar;
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
    public List<Integrante> findAllByHogar(Integer hogarId){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT I.id, I.nombre, I.email FROM integrantes I JOIN integrantes_hogares IH ON I.id = IH.integrante_id WHERE IH.hogar_id = ?", new String[]{"" + hogarId});
        List<Integrante> integrantes = traverseCursor(cursor);
        db.close();
        return integrantes;
    }

    @Override
    public Integrante findOne(Integer id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("integrantes",null, "id=?", new String[]{"" + id},null,null,null);
        List<Integrante> integrantes = traverseCursor(cursor);
        db.close();
        return integrantes.size() > 0 ? integrantes.get(0) : null;
    }

    public Integrante findOneByHogar(Integer id, Integer hogarId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT I.id, I.nombre, I.email FROM integrantes I JOIN integrantes_hogares IH ON I.id = IH.integrante_id WHERE IH.hogar_id = ? AND I.id = ?", new String[]{"" + hogarId, "" + id});
        List<Integrante> integrantes = traverseCursor(cursor);
        return integrantes.size() > 0 ? integrantes.get(0) : null;
    }

    @Override
    public boolean insert(Integrante instance, Hogar hogarInstance) {
        int id = -1, inid = -1;
        ContentValues values = new ContentValues();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(findOne(instance.getId()) == null) {
            values.put("id", instance.getId());
            values.put("nombre", instance.getNombre());
            values.put("email", instance.getEmail());
            inid = (int) db.insert("integrantes", null, values);
            instance.setId(inid);
        }
        if(inid != -1 || findOneByHogar(instance.getId(), hogarInstance.getId()) == null) {
            values = new ContentValues();
            values.put("hogar_id", hogarInstance.getId());
            values.put("integrante_id", instance.getId());
            id = (int) db.insert("integrantes_hogares", null, values);
        }
        db.close();
        return id != -1;
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

    private List<Integrante> traverseCursor (Cursor cursor) {
        List<Integrante> integrantes = new ArrayList<>();
        if (cursor.isBeforeFirst()) {
            Integrante integrante = null;
            int idxId = -1;
            int idxNombre = -1;
            int idxEmail = -1;
            idxId = cursor.getColumnIndex("id");
            idxNombre = cursor.getColumnIndex("nombre");
            idxEmail = cursor.getColumnIndex("email");
            while (cursor.moveToNext()) {
                integrante = new Integrante();
                integrante.setId(cursor.getInt(idxId));
                integrante.setNombre(cursor.getString(idxNombre));
                integrante.setEmail(cursor.getString(idxEmail));
                integrantes.add(integrante);
            }
        }
        cursor.close();
        return integrantes;
    }
}
