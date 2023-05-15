package com.xbl.io.nio.chatdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class ChatClient {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6666;
    private Selector selector;
    private SocketChannel socketChannel;
    private String userName;


    public ChatClient() throws Exception {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(userName + "上线");
    }

    private void sendMsg(String msg) {
        msg = userName + ": " + msg;
        try{
            socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void readMSg() throws IOException {
        SelectionKey key = null;
        SocketChannel sc = null;
        try{
            //阻塞方法
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                key = iterator.next();
                if (key.isReadable()){
                    sc = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    sc.read(buffer);
                    String msg = new String(buffer.array());
                    System.out.println(msg.trim());
                    buffer.clear();
                }

            }
        }catch (Exception e){
            System.out.println("服务器拒绝连接");
            key.cancel();
            sc.close();
        }
    }

    public static void main(String[] args) throws Exception {
        ChatClient chatClient = new ChatClient();
        new Thread(()-> {
            while(true){
                try {
                    chatClient.readMSg();
                    Thread.currentThread().sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String msg = scanner.nextLine();
            chatClient.sendMsg(msg);
        }
    }
}
