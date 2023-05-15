package com.xbl.io.nio;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws Exception{
        //创建serversocketchannle
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //得到一个selector
        Selector selector = Selector.open();
        //绑定指定的端口（监听）
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        //设置为非阻塞
        serverSocketChannel.configureBlocking(false);
        //serverSocketChannel注册到selector上，关注事件为OP_ACCEPT
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            //等待1秒，无事件，直接返回
            if (selector.select(1000) == 0){
                System.out.println("服务器等待1秒，无连接");
                continue;
            }
            //如果返回的的不是0，则获取对应的selectionKey集合
            //selector.selectedKeys()返回关注事件的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                //获取事件的类型
                SelectionKey key = iterator.next();
                //如果是新的连接，就创建新的socketChannel
                if (key.isAcceptable()){
                    //给该客户端生成对应的socketChannel
                    //事件驱动，此时已知有客户端来连接，所以accept直接创建，不会阻塞
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    socketChannel.configureBlocking(false);
                    System.out.println(socketChannel.hashCode());
                    //将socketChannel注册到selector上,关注事件为OP_READ，并且绑定一个buffer
                    socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (key.isReadable()){
                    //获取对应的channel
                    SocketChannel socketChannel = (SocketChannel)key.channel();
                    //获取注册时绑定的buffer
                    ByteBuffer buffer = (ByteBuffer)key.attachment();
                    //读取数据
                    socketChannel.read(buffer);
                    System.out.println(new String(buffer.array()));
                }
                //从集合中移除当前的selectionKey，避免重复消费
                iterator.remove();
            }
        }
    }
}
