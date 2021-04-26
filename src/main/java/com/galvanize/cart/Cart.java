package com.galvanize.cart;

import java.util.ArrayList;

public class Cart {

    ArrayList<Item> cartItems = new ArrayList<Item>();

    public ArrayList<Item> itemizedList() {
        return cartItems;
    }
    public void addItem(Item curItem) {
        cartItems.add(curItem);
    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item item: cartItems) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
