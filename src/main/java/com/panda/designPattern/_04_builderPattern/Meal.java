package com.panda.designPattern._04_builderPattern;

import com.panda.designPattern._04_builderPattern.item.Item;

import java.util.ArrayList;

public class Meal {
    private  ArrayList<Item> items= new ArrayList<Item>();

    public void  addItem(Item item){
        items.add(item);
    }

    public float getPrice(){
        float price = 0.0f;
        for (Item item : items) {
            price += item.price();
        }
        return price;
    }

    public void showItems(){
        System.out.println("套餐详情：");
        for (Item item : items) {
            System.out.println("item "+item.name()+" "+"packing "+item.packing().packing()+" "+"price "+item.price());
        }

    }

}
