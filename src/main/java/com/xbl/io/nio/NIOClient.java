package com.xbl.io.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NIOClient {
    public static void main(String[] args) throws Exception {
        //得到一个通道
        SocketChannel socketChannel = SocketChannel.open();
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //设置服务器端的ip, port
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        //连接服务器
        //如果连接失败
        if (!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("正在连接中，我可以做点别的事");
            }
        }
        //如果连接成功
        ByteBuffer buffer = ByteBuffer.wrap("你好呀".getBytes());
        socketChannel.write(buffer);
//        System.in.read();

    }
}
