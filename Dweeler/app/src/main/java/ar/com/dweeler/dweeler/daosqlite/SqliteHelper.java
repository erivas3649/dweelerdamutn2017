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

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int i, int i1) {

    }
}
