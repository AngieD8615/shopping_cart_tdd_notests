package com.galvanize.cart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CartTest {
    @Test
    public void cartStartsEmpty(){
        //Setup
        Cart cart = new Cart();
        ArrayList<Item> expected = new ArrayList<Item>();
        int expectedSize = expected.size();

        //Execute
        ArrayList<Item> actual = cart.itemizedList();
        int actualSize = actual.size();

        //Assert
        Assertions.assertEquals( expectedSize, actualSize);
    }

    // setup item
    // adding price
    @Test
    public void initItemWithNameAndPrice() {
        //Setup
        String expectedName = "Bag";
        double expectedPrice = 19.99;

        //Execute
        Item actualItem = new Item("Bag", 19.99);

        //Assert
        Assertions.assertEquals(expectedName, actualItem.getName());
        Assertions.assertEquals(expectedPrice, actualItem.getPrice());
    }


    // modifying cart
    @Test
    public void addItemMethod() {
        //Setup
        ArrayList<Item> expectedItemList= new ArrayList<Item>();
        expectedItemList.add(new Item("Bag", 19.99));
        //execute
        Cart actualCart = new Cart();
        Item firstItem = new Item("Bag", 19.99);
        actualCart.addItem(firstItem);

        //assert
        Assertions.assertEquals(expectedItemList.size(), actualCart.itemizedList().size());

    }
    
    @Test
    public void getTotalPriceOfCart() {
        //Setup
        double expectedTotalPrice = 19.99;

        //execute
        Cart actualCart = new Cart();
        Item firstItem = new Item("Bag", 19.99);
        actualCart.addItem(firstItem);
        Assertions.assertEquals(expectedTotalPrice, actualCart.getTotalPrice());
    }
}
