package com.xbl.designPattern._04_builderPattern;

public class test {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal veg = mealBuilder.prepareVeg();

        veg.showItems();
        System.out.println(veg.getPrice());

        Meal meat = mealBuilder.prepareMeat();

        meat.showItems();
        System.out.println(meat.getPrice());


    }
}
