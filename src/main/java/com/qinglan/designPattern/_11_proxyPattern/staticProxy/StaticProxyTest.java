package com.qinglan.designPattern._11_proxyPattern.staticProxy;

public class StaticProxyTest {
    public static void main(String[] args) {
        //代理商
        System.out.println("============================代理商============================");
        ComputerSaleProxy computerSaleProxy = new ComputerSaleProxy(new ComputerProductor());
        computerSaleProxy.saleComputer();
        computerSaleProxy.repairComputer();

        //厂商
        System.out.println("============================厂商============================");
        ComputerProductor computerProductor = new ComputerProductor();
        computerProductor.saleComputer();
        computerProductor.repairComputer();
    }
}
