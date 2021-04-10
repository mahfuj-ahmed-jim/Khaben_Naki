package com.example.khabennaki.Design.ImageFromGallery;

public class ImageFolders {
    String folderName;
    int totalImages;
    String lastImageUrl;

    public ImageFolders(String folderName, int totalImages, String lastImageUrl) {
        this.folderName = folderName;
        this.totalImages = totalImages;
        this.lastImageUrl = lastImageUrl;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public int getTotalImages() {
        return totalImages;
    }

    public void setTotalImages(int totalImages) {
        this.totalImages = totalImages;
    }

    public String getLastImageUrl() {
        return lastImageUrl;
    }

    public void setLastImageUrl(String lastImageUrl) {
        this.lastImageUrl = lastImageUrl;
    }

}
