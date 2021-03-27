package com.example.khabennaki.Design.Home;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.khabennaki.R;

import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private List<ImageDetails> images = new ArrayList<>();
    private int size;

    public GridAdapter(Context context, List<ImageDetails> images, int size) {
        this.context = context;
        this.images = images;
        this.size = size;
    }

    public void addImage(ImageDetails image, int position){
        images.set(position, image);
    }

    @Override
    public int getCount() {
        return size;
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

            // set views
            ImageView imageView = (ImageView) convertView.findViewById(R.id.gridView_image_id);

            if(!(position>images.size())){
                try{
                    imageView.setImageBitmap(images.get(position).getImageBitmap());
                }catch (Exception e){
                }
            }

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, images.get(position).toString(), Toast.LENGTH_LONG).show();
                }
            });

        }

        return convertView;
    }
}
