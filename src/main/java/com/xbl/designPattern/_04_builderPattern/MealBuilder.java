package com.xbl.designPattern._04_builderPattern;

import com.xbl.designPattern._04_builderPattern.item.drink.Coke;
import com.xbl.designPattern._04_builderPattern.item.drink.Pepsi;
import com.xbl.designPattern._04_builderPattern.item.food.ChiekenBurger;
import com.xbl.designPattern._04_builderPattern.item.food.VegBurger;

public class MealBuilder {
    public Meal prepareVeg() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareMeat() {
        Meal meal = new Meal();
        meal.addItem(new ChiekenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }


}
