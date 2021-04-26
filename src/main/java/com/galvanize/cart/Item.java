package com.galvanize.cart;

public class Item {

    private String name;
    private double price;
    private boolean isOnSale;
    private double salePrice;

    public Item(String name, double price){
         this(name, price, false, -1);
    }

    public Item(String name, double price, boolean isOnSale, double salePrice) {
        this.name = name;
        this.price = price;
        this.isOnSale = isOnSale;
        this.salePrice = salePrice;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsOnSale() {
        return isOnSale;
    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
