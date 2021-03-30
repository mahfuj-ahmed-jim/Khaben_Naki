package com.example.khabennaki.Design.Home.ImageFromGallery;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
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
    private List<String> selectedImageList = new ArrayList<>();

    public GridAdapter(Context context, List<String> imageList) {
        this.context = context;
        this.imageList = imageList;
        this.selectedImageList = imageList;
    }

    @Override
    public int getCount() {
        return selectedImageList.size();
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
                .load(selectedImageList.get(position))
                .into(imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Toast.makeText(context, selectedImageList.get(position).toString(), Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });

        return convertView;
    }

    public void setImageList(List <String> list, String selectedFolderPath){
        selectedImageList.clear();
        if(selectedFolderPath.equals("/All Photos")){
            selectedImageList.addAll(list);
        }else{
            for(String temp : list){
                if(getFolderPath(temp).equals(selectedFolderPath)){
                    selectedImageList.add(temp);
                }
            }
        }
        notifyDataSetChanged();
    }

    public String getFolderPath(String imageUrl){
        String reversePath = "";
        String folderPath = "";

        // get the path in a reverse order
        for(int i=imageUrl.length()-1; i>=0; i--){
            if(imageUrl.charAt(i)=='/'){
                i--;
                while(i>=0){
                    reversePath = reversePath + imageUrl.charAt(i);
                    i--;
                }
                break;
            }
        }

        // get the actual pathh
        for(int i=reversePath.length()-1; i>=0; i--){
            folderPath = folderPath + reversePath.charAt(i);
        }

        return folderPath;
    }

}
