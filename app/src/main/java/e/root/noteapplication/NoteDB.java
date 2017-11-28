package e.root.noteapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by root on 27/11/17.
 */

public class NoteDB extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="note.db";
    public  static final String TABLE_NAME="note";
    public static final String TABLE_CREATE_QUERY = "create table note(title text ,description text)";



    public NoteDB(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(TABLE_CREATE_QUERY);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
