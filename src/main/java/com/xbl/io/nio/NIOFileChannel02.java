package com.xbl.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用transferFrom实现文件的拷贝
 */
public class NIOFileChannel02 {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("spring-day01教案.docx");
        FileChannel source = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("spring-day01教案2.docx");
        FileChannel dist = fileOutputStream.getChannel();

        dist.transferFrom(source,0,source.size());

        //注意点三：关闭流
        fileOutputStream.close();
        fileInputStream.close();

    }
}
