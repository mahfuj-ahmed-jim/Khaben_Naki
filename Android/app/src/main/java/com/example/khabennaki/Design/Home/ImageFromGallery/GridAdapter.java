package com.example.khabennaki.Design.Home.ImageFromGallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.khabennaki.R;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private List <String> imageList = new ArrayList<>();

    public GridAdapter(Context context, List<String> imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @Override
    public int getCount() {
        return imageList.size();
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

        Glide.with(context)
                .load(imageList.get(position))
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, imageList.get(position).toString(), Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
