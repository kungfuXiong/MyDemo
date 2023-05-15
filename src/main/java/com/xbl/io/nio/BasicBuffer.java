package com.xbl.io.nio;

import java.nio.IntBuffer;

public class BasicBuffer {
    public static void main(String[] args) {
        //创建一个可以存放5个int的buffer
        IntBuffer allocate = IntBuffer.allocate(10);

        //向buffer存数据
        for (int i = 0; i < 5; i++) {
            allocate.put(i * i);
        }
        //从buffer读取数据
        //将buffer进行读写切换
        allocate.flip();
        while (allocate.hasRemaining()) {
            System.out.println(allocate.get());
        }
        //将buffer进行读写切换
        allocate.flip();
        int limit = allocate.limit();
        allocate.limit(limit+1);
        allocate.position(limit);
        allocate.put(10*10);

        //将buffer进行读写切换
        allocate.flip();
        while (allocate.hasRemaining()) {
            System.out.println(allocate.get());
        }
    }
}
