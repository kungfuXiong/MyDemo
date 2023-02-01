package com.qinglan.designPattern._07_bridgepattern.bags;

import com.qinglan.designPattern._07_bridgepattern.color.Color;

public abstract class Bag {
    public Color color;

    public String type;

    public void setColor(Color color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void show(){
        System.out.println(type+":"+color.getColor());
    }
}
