package com.qinglan.designPattern._11_proxyPattern.staticProxy;

public class ComputerSaleProxy implements ComputerSale{

    private ComputerProductor computerProductor;

    public ComputerSaleProxy(ComputerProductor computerProductor) {
        this.computerProductor = computerProductor;
    }

    public void saleComputer() {
        System.out.print("戴尔杭州总代（优惠5%）在此，下单由：");
        computerProductor.saleComputer();
    }

    public void repairComputer() {
        System.out.print("售后质保有保证：");
        computerProductor.repairComputer();
    }
}
