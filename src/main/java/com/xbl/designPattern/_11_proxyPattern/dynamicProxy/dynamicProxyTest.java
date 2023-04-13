package com.xbl.designPattern._11_proxyPattern.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class dynamicProxyTest {
    public static void main(String[] args) {

        final ComputerProductor computerProductor = new ComputerProductor();

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("saleComputer".equals(method.getName())){
                    System.out.print("戴尔杭州总代（优惠5%）在此，下单由：");
                    //
                    method.invoke(computerProductor, args);
                } else if ("repairComputer".equals(method.getName())) {
                    System.out.print("售后质保有保证：");
                    method.invoke(computerProductor, args);
                }
                return null;
            }
        };

        ComputerSale computerSale = (ComputerSale)Proxy.newProxyInstance(computerProductor.getClass().getClassLoader(),
                computerProductor.getClass().getInterfaces(),
                handler
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        if ("saleComputer".equals(method.getName())){
//                            System.out.print("戴尔杭州总代（优惠5%）在此，下单由：");
//                            method.invoke(computerProductor, args);
//                        } else if ("repairComputer".equals(method.getName())) {
//                            System.out.print("售后质保有保证：");
//                            method.invoke(computerProductor, args);
//                        }
//                        return null;
//                    }
//                }
        );
        //jdk动态代理
        computerSale.saleComputer();
        computerSale.repairComputer();
        //自定义实现代理类，模拟动态代理
        ProxyDemo proxyDemo = new ProxyDemo(handler);
        proxyDemo.saleComputer();
        proxyDemo.repairComputer();

    }
}
