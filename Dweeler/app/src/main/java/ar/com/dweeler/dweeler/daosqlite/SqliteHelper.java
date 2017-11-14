package ar.com.dweeler.dweeler.daosqlite;

import android.content.ContentValues;
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
                "\t`tipo`\tINTEGER DEFAULT '1'\n" +
                ");");
        database.execSQL("CREATE TABLE `habitaciones` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`hogar_id`\tINTEGER NOT NULL,\n" +
                "\t`nombre`\tTEXT NOT NULL,\n" +
                "\t`descripcion`\tTEXT,\n" +
                "\t`tipo`\tINTEGER DEFAULT '1'\n" +
                ");");
        database.execSQL("CREATE TABLE `dispositivos` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`nombre`\tTEXT NOT NULL,\n" +
                "\t`estado`\tTEXT,\n" +
                "\t`tipo`\tINTEGER DEFAULT '1',\n" +
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
                "\t`email`\tTEXT NOT NULL\n" +
                ");");
        database.execSQL("CREATE TABLE `integrantes_hogares` (\n" +
                "\t`hogar_id`\tINTEGER NOT NULL,\n" +
                "\t`integrante_id`\tINTEGER NOT NULL,\n" +
                "\tPRIMARY KEY (hogar_id, integrante_id)" +
                ");");
        database.execSQL("CREATE TABLE `notificaciones` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`mensaje`\tTEXT NOT NULL,\n" +
                "\t`fecha`\tTEXT\n" +
                ");");
        //mockData(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {

    }

    protected void mockData (SQLiteDatabase database) {
        database.execSQL("INSERT INTO hogares VALUES (1, 'Departamento Cordoba', 'Av. Poeta Lugones 338', 1)");
        database.execSQL("INSERT INTO habitaciones VALUES (1, 1, 'Cocina', '', 1)");
        database.execSQL("INSERT INTO habitaciones VALUES (2, 1, 'Comedor', '', 2)");
        database.execSQL("INSERT INTO habitaciones VALUES (3, 1, 'Dormitorio', '', 4)");
        database.execSQL("INSERT INTO habitaciones VALUES (4, 1, 'Oficina', '', 5)");
        database.execSQL("INSERT INTO actividades VALUES (1, 'Encender Luces', 2)");
        database.execSQL("INSERT INTO actividades VALUES (2, 'Apagar Luces', 2)");
        database.execSQL("INSERT INTO dispositivos VALUES (1, 'Lampara Principal', 'En Linea', 4, 2)");
        database.execSQL("INSERT INTO dispositivos VALUES (2, 'Cafetera', 'En Linea', 2, 1)");
        database.execSQL("INSERT INTO dispositivos VALUES (3, 'Lampara Mesa Noche', 'En Linea', 2, 3)");
        database.execSQL("INSERT INTO integrantes VALUES (1, 'Eric Rivas', 'erivas3649@gmail.com')");
        database.execSQL("INSERT INTO integrantes VALUES (2, 'Matias Pavan', 'matipavan@gmail.com')");
        database.execSQL("INSERT INTO integrantes_hogares VALUES (1, 1)");
        database.execSQL("INSERT INTO integrantes_hogares VALUES (1, 2)");
        database.execSQL("INSERT INTO notificaciones VALUES (1, 'Dweeler ha iniciado el modo de ahorro de energia', '2017-11-04 21:09:00')");
        database.execSQL("INSERT INTO notificaciones VALUES (2, 'Eric ha agregado a Matias a Departamento Cordoba', '2017-11-06 14:03:00')");
    }
}
