package com.qinglan.designPattern._11_proxyPattern.dynamicProxy;

public class ComputerProductor implements ComputerSale {


    public void saleComputer() {
        System.out.println("戴尔直发");
    }

    public void repairComputer() {
        System.out.println("戴尔厂商官方质保");
    }
}
