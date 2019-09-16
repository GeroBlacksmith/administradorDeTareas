package com.studio.blacksmith.administradordetareas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbAdapter{

    public static final String KEY_TITLE="titulo";
    public static final String KEY_BODY = "body";
    public static final String KEY_ROWID="_id";

    private static final String TAG="DbAdapter";
    private DataBaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    /**
     *
     * Creacion de la base de datos
     *
     */
    private static final String DATABASE_CREATE =
            "Create table tareas (_id integer primary key autoincrement, " +
                    "title text not null, body text not null," +
                    "star text not null, end text not null" +
                    ",state text not null, priority integer);";

    private static final String DATABASE_TABLE = "tareas";


    private static final int DATABASE_VERSION = 1;

    //Nombre de la base de datos.
    private static final String DATABASE_NAME = "adminDeTareas";

    //Nombre de la tabla
    private static final String TABLE_TASKS = "tareas";

    //Nombre de las columnas
    private static final String KEY_ID = "id";
    private static final String KEY_TASKNAME = "tarea";
    private static final String KEY_STATUS = "estado";

    private final Context mCtx;

    public DbAdapter(Context context){
        this.mCtx=context;

    }
    private static class DataBaseHelper extends SQLiteOpenHelper{
        DataBaseHelper(Context context){
            super(context,DATABASE_NAME, null,DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DATABASE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(TAG,"Upgrading database from version"+oldVersion+ " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS notes");
            onCreate(db);
        }
    }
    public DbAdapter open() throws SQLException{
        mDbHelper = new DataBaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        mDbHelper.close();
    }
    public long createNote(String title, String body){
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TITLE, title);
        initialValues.put(KEY_BODY, body);

        return mDb.insert(DATABASE_TABLE,null,initialValues);
    }

    public boolean deleteNote(long rowId){
        return mDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }
    public Cursor fetchAllNotes() {

        return mDb.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_TITLE,
                KEY_BODY}, null, null, null, null, null);
    }
    public Cursor fetchNote(long rowId) throws SQLException {

        Cursor mCursor =

                mDb.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                                KEY_TITLE, KEY_BODY}, KEY_ROWID + "=" + rowId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

}
