package com.example.khabennaki.Design.Home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.khabennaki.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter {

    private Context context;
    public static List <Bitmap> images = new ArrayList<>();

    public GridAdapter(Context context, List<Bitmap> images) {
        this.context = context;
        this.images = images;
    }

    public void addImage(Bitmap bitmap){
        images.add(bitmap);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.grib_view_sample,parent,false);

        }

        // set views
        ImageView imageView = (ImageView) convertView.findViewById(R.id.gridView_image_id);

        imageView.setImageBitmap(images.get(position));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, images.get(position).toString(), Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }

}