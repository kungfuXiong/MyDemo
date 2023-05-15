package com.xbl.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用同一个buffer实现文件的拷贝
 */
public class NIOFileChannel01 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("1.txt");
        FileChannel inputStreamChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        while (true) {
            //注意点一：需要充值buffer的标志位，否则在第二次读取数据的时候就读不到数据（position=limit）
            //第一次读完数据后 position位于8，则现在写数据从8开始，只能存放0个数据
            byteBuffer.clear();
            int read = inputStreamChannel.read(byteBuffer);
            System.out.println(read);
            if (read == -1) {
                break;
            }
            //注意点二:此处转换读写方向
            byteBuffer.flip();

            outputStreamChannel.write(byteBuffer);
        }
        //注意点三：关闭流
        fileOutputStream.close();
        fileInputStream.close();

    }
}
