package com.xbl.designPattern._07_bridgepattern;

import com.xbl.designPattern._07_bridgepattern.bags.Bag;
import com.xbl.designPattern._07_bridgepattern.bags.HandBag;
import com.xbl.designPattern._07_bridgepattern.bags.Wallet;
import com.xbl.designPattern._07_bridgepattern.color.Red;
import com.xbl.designPattern._07_bridgepattern.color.Yellow;

public class test {
    public static void main(String[] args) {
        Bag wallet = new Wallet();
        wallet.setColor(new Yellow());
        wallet.show();


        Bag handBag = new HandBag();
        handBag.setColor(new Red());
        handBag.show();
    }
}
