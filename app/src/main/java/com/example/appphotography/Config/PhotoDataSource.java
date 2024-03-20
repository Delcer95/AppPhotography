package com.example.appphotography.Config;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class PhotoDataSource {
    private SQLiteDatabase database;
    private PhotoDatabaseHelper dbHelper;

    public PhotoDataSource(Context context) {
        dbHelper = new PhotoDatabaseHelper(context);
    }

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void addPhoto(Photograph photo) {
        ContentValues values = new ContentValues();
        values.put("image", photo.getImage());
        values.put("description", photo.getDescription());
        database.insert("photos", null, values);
    }

    // Implementa métodos para modificar y eliminar fotos si es necesario
}

