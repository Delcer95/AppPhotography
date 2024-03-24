package com.example.appphotography;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appphotography.Config.Photograph;
import com.example.appphotography.Config.PhotographAdapter;
import com.example.appphotography.Config.SQLiteConexion;
import com.example.appphotography.Config.Transacciones;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView simpleGridView = (ListView) findViewById(R.id.listView);

        SQLiteConexion help = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        ArrayList<Photograph> listaImagenes = new ArrayList<>();
        Cursor c= help.getAll();
        int i=0;
        if(c.getCount()>0)
        {
            c.moveToFirst();
            while(c.isAfterLast()==false)
            {

                byte[] bytes=c.getBlob(c.getColumnIndexOrThrow(Transacciones.blobPhoto));
                String descripcion = c.getString(c.getColumnIndexOrThrow(Transacciones.descripcion));

                Photograph photograph = new Photograph(BitmapFactory.decodeByteArray(bytes, 0, bytes.length), descripcion);
                listaImagenes.add(photograph);
                c.moveToNext();
                i++;
            }

            PhotographAdapter myAdapter=new PhotographAdapter(this,R.layout.view_item,listaImagenes);
            simpleGridView.setAdapter(myAdapter);
        }
    }
}