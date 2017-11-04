package ar.com.dweeler.dweeler.daosqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by nemesys on 27/10/17.
 */

public class SqliteHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "dweelerdb";
    private static final int VERSION = 1;
    private static SqliteHelper instance;

    private SqliteHelper(Context context) {
        super(context, DBNAME, null, VERSION);
    }

    public static SqliteHelper getInstance (Context c) {
        if(instance == null) {
            instance = new SqliteHelper(c);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE `hogares` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`nombre`\tTEXT NOT NULL,\n" +
                "\t`direccion`\tTEXT NULL,\n" +
                "\t`tipo`\tINTEGER DEFAULT ''1''\n" +
                ");");
        database.execSQL("CREATE TABLE `habitaciones` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`hogar_id`\tINTEGER NOT NULL,\n" +
                "\t`nombre`\tTEXT NOT NULL,\n" +
                "\t`descripcion`\tTEXT,\n" +
                "\t`tipo`\tINTEGER DEFAULT ''1''\n" +
                ");");
        database.execSQL("CREATE TABLE `dispositivos` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`nombre`\tTEXT NOT NULL,\n" +
                "\t`estado`\tTEXT,\n" +
                "\t`tipo`\tINTEGER DEFAULT ''1'',\n" +
                "\t`habitacion_id`\tINTEGER NOT NULL\n" +
                ");");
        database.execSQL("CREATE TABLE `actividades` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`nombre`\tINTEGER NOT NULL,\n" +
                "\t`habitacion_id`\tINTEGER NOT NULL\n" +
                ");");
        database.execSQL("CREATE TABLE `integrantes` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`nombre`\tTEXT NOT NULL,\n" +
                "\t`email`\tTEXT NOT NULL,\n" +
                "\t`foto`\tTEXT\n" +
                ");");
        database.execSQL("CREATE TABLE `integrantes_hogares` (\n" +
                "\t`hogar_id`\tINTEGER,\n" +
                "\t`integrante_id`\tINTEGER,\n" +
                "\t`PRIMARY KEY (hogar_id, integrante_id)`" +
                ");");
        database.execSQL("CREATE TABLE `notificaciones` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`mensaje`\tTEXT NOT NULL,\n" +
                "\t`fecha`\tTEXT\n" +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {

    }
}
