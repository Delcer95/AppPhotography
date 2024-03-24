package com.example.appphotography.Config;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteConexion extends SQLiteOpenHelper {

    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Transacciones.CreateTablePhotos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Transacciones.DropeTablePhotos);
        onCreate(db);
    }

    public Cursor getAll() {
        return(getReadableDatabase().rawQuery("SELECT * FROM Photo",null));
    }
    public void insert(byte[] bytes, String descripcion)
    {
        ContentValues cv = new ContentValues();

        cv.put(Transacciones.blobPhoto,bytes);
        cv.put(Transacciones.descripcion,descripcion);
        Log.e("inserted", "inserted");
        getWritableDatabase().insert(Transacciones.tablaPhoto,Transacciones.idPhoto,cv);

    }
    public byte[] getImage(Cursor c)
    {
        return(c.getBlob(1));
    }

}
