package com.galvanize.cart;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {

    ArrayList<Item> cartItems = new ArrayList<Item>();
    public HashMap<String, Integer> itemQuantities = new HashMap<String, Integer>();

    public ArrayList<Item> itemizedList() {
        return cartItems;
    }
    public void addItem(Item curItem) {
        cartItems.add(curItem);
        if (itemQuantities.containsKey(curItem.getName()) ) {
            int curQuantity = itemQuantities.get(curItem.getName());
            itemQuantities.put(curItem.getName(), curQuantity + 1);
        } else {
            itemQuantities.put(curItem.getName(), 1);
        }

    }
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item item: cartItems) {
            totalPrice += item.getPrice();
        }

        return totalPrice;
    }


}
