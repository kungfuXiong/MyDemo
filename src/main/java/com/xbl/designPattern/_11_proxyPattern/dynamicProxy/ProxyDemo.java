package com.xbl.designPattern._11_proxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyDemo implements ComputerSale{

    private InvocationHandler handler;

    public ProxyDemo(InvocationHandler handler) {
        this.handler = handler;
    }

    @Override
    public void saleComputer() {
        try {
            Method saleComputer = ComputerSale.class.getMethod("saleComputer");
            handler.invoke(this,saleComputer,new Object[]{});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void repairComputer() {
        try {
            //此处应为接口，兄弟类之间无法互相转型（即兄弟类之间的方法不能执行）
//            Method saleComputer = this.getClass().getMethod("repairComputer");
            Method saleComputer = ComputerSale.class.getMethod("repairComputer");
            handler.invoke(this,saleComputer,new Object[]{});
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
