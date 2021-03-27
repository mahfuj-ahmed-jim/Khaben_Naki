package com.example.khabennaki.Design.Home;

import android.graphics.Bitmap;

public class ImageDetails {
    String imageUrl;
    Bitmap imageBitmap;

    public ImageDetails(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ImageDetails(String imageUrl, Bitmap imageBitmap) {
        this.imageUrl = imageUrl;
        this.imageBitmap = imageBitmap;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Bitmap getImageBitmap() {
        return imageBitmap;
    }

    public void setImageBitmap(Bitmap imageBitmap) {
        this.imageBitmap = imageBitmap;
    }

}
