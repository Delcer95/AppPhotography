package com.example.appphotography;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.appphotography.Config.PhotoDataSource;
import com.example.appphotography.Config.Photograph;

import java.util.List;

public class ActivityList extends AppCompatActivity {
    private ListView listView;
    private List<Photograph> photoList;
    private PhotoDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = findViewById(R.id.listView);

        // Inicializa la fuente de datos de las fotos
        dataSource = new PhotoDataSource(this);
        dataSource.open();

        // Cargar las fotos de la base de datos o de donde las estés obteniendo
        photoList = dataSource.getAllPhotos(); // Suponiendo que tienes un método para obtener todas las fotos de la base de datos

        // Configurar el adaptador para la ListView
        PhotoCardAdapter adapter = new PhotoCardAdapter(this, photoList);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cerrar la fuente de datos cuando la actividad se destruya
        dataSource.close();
    }
}
