package com.tridaya.tridayago;

/**
 * Created by Suhafer on 02/12/2015.
 */
public class Drawer_Item {
    private String itemName;
    private int itemImage1,itemImage2;
    public Drawer_Item (String name, int image1, int image2) {
        // TODO Auto-generated constructor stub
        this.itemName=name;
        this.itemImage1 =image1;
        this.itemImage2 =image2;

    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public int getItemImage1() {
        return itemImage1;
    }
    public void setItemImage1(int itemImage1) {
        this.itemImage1 = itemImage1;
    }

    public int getItemImage2() {
        return itemImage2;
    }
    public void setItemImage2(int itemImage2) {
        this.itemImage2 = itemImage2;
    }
}
