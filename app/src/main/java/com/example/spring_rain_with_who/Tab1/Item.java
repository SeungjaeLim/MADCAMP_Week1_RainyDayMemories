package com.example.spring_rain_with_who.Tab1;

public class Item {
    String name;
    String phone;
    int image;

    public Item(String name, String phone, int image){
        this.name=name;
        this.phone=phone;
        this.image=image;
    }
    public String getName(){
        return name;
    }
    public String getPhone(){
        return phone;
    }
    public int getImage(){
        return image;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public void setImage(int image){
        this.image=image;
    }
}
