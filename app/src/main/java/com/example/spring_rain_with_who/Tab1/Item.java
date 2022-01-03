package com.example.spring_rain_with_who.Tab1;

public class Item {
    String name;
    String phone;
    int resourceId;

    public Item(){}

    public Item(int resourceId, String name, String phone) {
        this.name = name;
        this.phone= phone;
        this.resourceId = resourceId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }
}
