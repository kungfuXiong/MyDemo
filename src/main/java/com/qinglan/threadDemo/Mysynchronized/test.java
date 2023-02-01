package com.qinglan.threadDemo.Mysynchronized;

public class test {
    public static void main(String[] args) {
        //2147483647
        System.out.println(Integer.MAX_VALUE);
        //10000000000
        //以下算数实际结果超过了2147483647，2147483647为java整数的最大可表示范围，即2的31次方-1
        //至于为什么是2的31次方-1，而不是2的32次方-1（毕竟都是32位或者64位的计算机，怎么就丢了一位），
        // 因为计算机表示数字的方式是补码，补码的最高位是符号位，即表示正负
        int muu= 10000*1000000;
        System.out.println(muu);
        System.out.println(muu%500);
        long asd= 10000*1000000l;
        System.out.println(Integer.toBinaryString(10000*1000000));
        System.out.println(Long.toBinaryString(asd));
        System.out.println(Long.toBinaryString(asd).length());
//           1010100000010111110010000000000
//        1001010100000010111110010000000000
//        34
    }
}
