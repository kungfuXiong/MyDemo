package com.xbl.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamTest {
    public static void main(String[] args) {
        int[][] data = {{1, 2}, {3, 4}, {5, 6}};
        IntStream intStream = Arrays.stream(data).flatMapToInt(row -> Arrays.stream(row));
        System.out.println("案例5：对给定的二维整数数组求和：" + intStream.sum());
        System.out.println("-----------------------");

    }
}
