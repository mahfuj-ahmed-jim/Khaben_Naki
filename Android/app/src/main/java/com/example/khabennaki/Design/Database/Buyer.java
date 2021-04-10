package com.example.khabennaki.Design.Database;

import java.util.ArrayList;
import java.util.List;

public class Buyer {

    private String name;
    private String email;
    private String location;
    private String favouriteItem;
    private String picture;
    private int point;
    private List <String> searchList = new ArrayList<>();
    private List <String> orderList = new ArrayList<>();

    public Buyer() {
    }

    public Buyer(String name, String email, String location, String favouriteItem,
                 String picture, int point, List<String> searchList, List<String> orderList) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.favouriteItem = favouriteItem;
        this.picture = picture;
        this.point = point;
        this.searchList = searchList;
        this.orderList = orderList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFavouriteItem() {
        return favouriteItem;
    }

    public void setFavouriteItem(String favouriteItem) {
        this.favouriteItem = favouriteItem;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public List<String> getSearchList() {
        return searchList;
    }

    public void setSearchList(List<String> searchList) {
        this.searchList = searchList;
    }

    private void addSearch(String search){
        this.searchList.add(search);
    }

    private void addOrder(String order){
        this.orderList.add(order);
    }

    public List<String> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<String> orderList) {
        this.orderList = orderList;
    }

}
