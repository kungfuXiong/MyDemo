package com.xbl.io.nio.chatdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class ChatServer {
    private static final int PORT = 6666;
    private Selector selector;
    private ServerSocketChannel listener;

    //构造器
    //初始化
    public ChatServer() {
        try {
            //得到选择器
            selector = Selector.open();
            //ServerSocketChannel
            listener = ServerSocketChannel.open();
            //绑定端口
            listener.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            listener.configureBlocking(false);
            //注册
            listener.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //监听方法
    private void listen() {
        try {
            //循环监听
            while (true) {
                int count = selector.select();
                if (count > 0) {
                    //有事件需要处理
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        //移除当前已处理的key
                        iterator.remove();
                        //判断是都是连接事件
                        if (key.isAcceptable()) {
                            SocketChannel accept = listener.accept();
                            accept.configureBlocking(false);
                            accept.register(selector, SelectionKey.OP_READ);
                            System.out.println(accept.getRemoteAddress() + "上线");
                        }
                        //判断是可读事件
                        if (key.isReadable()) {
                            //转发消息
                            forwarding(key);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void forwarding(SelectionKey key) {
        SocketChannel source = null;
        try {
            source = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = source.read(buffer);
            if (read > 0){
                buffer.flip();
                Iterator<SelectionKey> iterator= selector.keys().iterator();
                while(iterator.hasNext()){
                    Channel target = iterator.next().channel();
                    if (target instanceof SocketChannel && target != source){
                        ((SocketChannel) target).configureBlocking(false);
                        ((SocketChannel) target).write(buffer);
                        buffer.flip();
                    }
                }
            }
            buffer.clear();
        }catch (Exception e){
            try {
                System.out.println(source.getRemoteAddress() + "离线");
                key.cancel();
                source.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.listen();
    }
}
