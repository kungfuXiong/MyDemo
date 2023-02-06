package com.qinglan.designPattern._11_proxyPattern.cglibProxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDemo {
    public static void main(String[] args) {
        final ComputerProductor computerProductor = new ComputerProductor();

        //使用cglib代理增强,方法拦截器
        ComputerProductor o = (ComputerProductor) Enhancer.create(computerProductor.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                if (method.getName().equalsIgnoreCase("saleComputer")) {
                    System.out.println("南京总代，5%优惠");
                    Object invoke = method.invoke(computerProductor, objects);
                    return null;
                } else if (method.getName().equalsIgnoreCase("repairComputer")) {
                    System.out.println("戴尔官方售后");
                    Object invoke = method.invoke(computerProductor, objects);
                    return null;
                }
                return null;
            }
        });

        o.saleComputer();
        o.repairComputer();

    }
}
