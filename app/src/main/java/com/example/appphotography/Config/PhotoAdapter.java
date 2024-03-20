package com.example.appphotography.Config;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PhotoAdapter extends ArrayAdapter<Photograph> {
    private Context context;
    private List<Photograph> photosList;

    public PhotoAdapter(Context context, List<Photograph> photosList) {
        super(context, R.layout.photo_item, photosList);
        this.context = context;
        this.photosList = photosList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.photo_item, null);
        }

        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textViewDescription = view.findViewById(R.id.textViewDescription);

        Photograph photo = photosList.get(position);

        if (photo != null) {
            imageView.setImageBitmap(BitmapFactory.decodeByteArray(photo.getImage(), 0, photo.getImage().length));
            textViewDescription.setText(photo.getDescription());
        }

        return view;
    }
}

