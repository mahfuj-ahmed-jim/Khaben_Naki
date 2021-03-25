package com.example.khabennaki.Design.Home;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.khabennaki.R;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class GridAdapter extends BaseAdapter {

    private Context context;
    private List <String> images = new ArrayList<>();

    public GridAdapter(Context context, List<String> images) {
        this.context = context;
        this.images = images;
        Log.d("Pic", images.toString());
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

        // get imageView id
        ImageView imageView = (ImageView) convertView.findViewById(R.id.gridView_image_id);

        // resize image
        Bitmap fullSizedImae = BitmapFactory.decodeFile(images.get(position));
        Bitmap reduceSizedImage = ImageResizer.reduceBitmapSize(fullSizedImae, 50000);
        File file = getBitMapFile(reduceSizedImage);

        // get image of resized image
        Bitmap myBitmap = BitmapFactory.decodeFile(file.getAbsolutePath());

        // set image
        imageView.setImageBitmap(myBitmap);
        //Picasso.get().load(Uri.parse(images.get(position))).into(imageView); // set pic into the imageview

        //Log.d("Pic", images.get(position));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }

    private File getBitMapFile (Bitmap bitmap){
        File file = new File(Environment.getExternalStorageDirectory()+File.separator+"reduced_file");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        byte [] bitMapData = byteArrayOutputStream.toByteArray();
        try{
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bitMapData);
            fileOutputStream.flush();
            fileOutputStream.close();
            return file;
        }catch (Exception e){

        }
        return file;
    }

}