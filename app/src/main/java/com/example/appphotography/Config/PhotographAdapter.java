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

import com.example.appphotography.R;

import java.util.ArrayList;
import java.util.List;

public class PhotographAdapter extends ArrayAdapter<Photograph> {
    ArrayList<Photograph> ActivityList = new ArrayList<>();

    public PhotographAdapter(Context context, int textViewResourceId, ArrayList<Photograph> objects) {
        super(context, textViewResourceId, objects);
        ActivityList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.view_item, null);
        ImageView imageView = (ImageView) v.findViewById(R.id.img);
        imageView.setImageBitmap(ActivityList.get(position).getImagen());
        TextView textView = (TextView) v.findViewById(R.id.txt);
        textView.setText(ActivityList.get(position).getDescripcion());
        return v;
    }

}

