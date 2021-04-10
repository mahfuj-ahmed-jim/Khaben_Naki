package com.example.khabennaki.Design.ImageFromGallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.khabennaki.R;

import java.util.ArrayList;
import java.util.List;

public class ImageRecyclerViewAdapter extends RecyclerView.Adapter<ImageRecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List <ImageFolders> imageFolders = new ArrayList<>();
    private String selectedFolder;

    public ImageRecyclerViewAdapter(Context context, List<ImageFolders> imageFolders, String selectedFolder) {
        this.context = context;
        this.imageFolders = imageFolders;
        this.selectedFolder = selectedFolder;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageRecyclerViewAdapter.MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_folder_recyclerview_sample,null,false));
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context)
                .load(imageFolders.get(position).getLastImageUrl())
                .into(holder.folderImageView);

        //Picasso.get().load(imageFolders.get(position).getLastImageUrl()).into(holder.folderImageView);

        holder.folderNameTextView.setText(getFolderName(imageFolders.get(position).getFolderName()));
        holder.totalImageTextView.setText(""+imageFolders.get(position).getTotalImages());

        // sent selected folder to the activity
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("custom-message"); // set intent type
                intent.putExtra("FolderName", getFolderName(imageFolders.get(position).getFolderName())); // set data
                intent.putExtra("FolderPath", imageFolders.get(position).getFolderName()); // set data
                LocalBroadcastManager.getInstance(context).sendBroadcast(intent); // send data
            }
        });

    }

    @Override
    public int getItemViewType(int position)
    {
        return position;
    }

    @Override
    public int getItemCount() {
        return imageFolders.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView folderImageView, checkImageView;
        private TextView folderNameTextView, totalImageTextView;
        private LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            folderImageView = itemView.findViewById(R.id.folderImage_imageView_id);
            folderNameTextView = itemView.findViewById(R.id.folderName_textView_id);
            totalImageTextView = itemView.findViewById(R.id.totalImage_textView_id);

            linearLayout = itemView.findViewById(R.id.sample_layout_id);

        }
    }

    // get folder name
    public String getFolderName(String imageUrl){
        String reverseName = "";
        String folderName = "";

        // get the path in a reverse order
        for(int i=imageUrl.length()-1; i>=0; i--){
            reverseName = reverseName + imageUrl.charAt(i);
            if(imageUrl.charAt(i-1)=='/'){
                break;
            }
        }

        // get the actual pathh
        for(int i=reverseName.length()-1; i>=0; i--){
            folderName = folderName + reverseName.charAt(i);
        }

        return folderName;
    }


}
