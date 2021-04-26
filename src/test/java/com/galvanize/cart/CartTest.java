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
        //
        //Setup
        double expectedTotalPrice = 19.99;

        //execute
        Cart actualCart = new Cart();
        // Cart is initialized empty
        Assertions.assertEquals(0, actualCart.getTotalPrice());

        Item firstItem = new Item("Bag", 19.99);
        actualCart.addItem(firstItem);
        Assertions.assertEquals(expectedTotalPrice, actualCart.getTotalPrice());
    }

    @Test
    public void testItemizedList(){
        //Setup
        ArrayList<Item> expectedItems = new ArrayList<>();

        // Execute
        Cart actualCart = new Cart();

        // Assert
        Assertions.assertEquals(expectedItems, actualCart.itemizedList(), "Empty cart is initialized");

        expectedItems.add(new Item("Bag", 19.99));

        actualCart.addItem(new Item("Bag", 19.99));

//        Assertions.assertArrayEquals(expectedItems.toArray(), actualCart.itemizedList().toArray());

        for(int i = 0 ; i < actualCart.itemizedList().size(); i++){

            Assertions.assertEquals( expectedItems.get(i).getName(), actualCart.itemizedList().get(i).getName());
            Assertions.assertEquals( expectedItems.get(i).getPrice(), actualCart.itemizedList().get(i).getPrice());

        }
    }

    @Test
    public void addMultDuplicateItemsToCartCheckPriceAndQunatity() {
        //setup
        ArrayList<Item> expectedItems = new ArrayList<Item>();

        //execute
        Cart multItemCart = new Cart();

        //Test for empty cart first
        Assertions.assertEquals(expectedItems, multItemCart.itemizedList());

        expectedItems.add(new Item("bag", 19.99));
        expectedItems.add(new Item("bag", 19.99));

        multItemCart.addItem(new Item("bag", 19.99));
        multItemCart.addItem(new Item("bag", 19.99));

        Assertions.assertEquals(39.98, multItemCart.getTotalPrice());
        Assertions.assertEquals(2, multItemCart.itemQuantities.get("bag"));

    }

    @Test
    public void addMultVariousItemsToCartCheckPriceAndQunatity() {
        //setup
        ArrayList<Item> expectedItems = new ArrayList<Item>();

        //execute
        Cart multItemCart = new Cart();

        //Test for empty cart first
        Assertions.assertEquals(expectedItems, multItemCart.itemizedList());

        expectedItems.add(new Item("bag", 19.99));
        expectedItems.add(new Item("bag", 19.99));
        expectedItems.add(new Item("watch", 50.00));

        multItemCart.addItem(new Item("bag", 19.99));
        multItemCart.addItem(new Item("bag", 19.99));
        multItemCart.addItem(new Item("watch", 50.00));

        Assertions.assertEquals(39.98, multItemCart.getTotalPrice(new Item("bag", 19.99)));// price for the bags only
        Assertions.assertEquals(2, multItemCart.itemQuantities.get("bag"));

    }

    @Test
    public void quantityOfTotalItems(){
        // setup


        //execute
        Cart multItemCart = new Cart();
        multItemCart.addItem(new Item("bag", 19.99));
        multItemCart.addItem(new Item("bag", 19.99));
        multItemCart.addItem(new Item("watch", 50.00));

        // assert
        Assertions.assertEquals(3, multItemCart.itemQuantities());

    }

    @Test
    public void forItemsOnSale() {
        //setup

        //execute
        Cart withSaleItems = new Cart();
        withSaleItems.addItem(new Item("bag", 19.99, true, 15));
        withSaleItems.addItem(new Item("expensive bag", 199.99));

        //assert
        Assertions.assertEquals(1, withSaleItems.onSaleItems().size());
//        Assertions.assertTrue(withSaleItems.onSaleItems().contains(new Item("bag", 19.99, true, 15)));
//        Assertions.assertFalse(withSaleItems.onSaleItems().contains(new Item("expensive bag", 199.99)));
    }

}
