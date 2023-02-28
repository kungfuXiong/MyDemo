package com.qinglan.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) {
        try {
            System.out.println("服务器启动成功，开始监听：");

            ServerSocket serverSocket = new ServerSocket(8989);

            while (true) {
                Socket accept = serverSocket.accept();

                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {

                            InputStream inputStream = accept.getInputStream();

                            byte[] bytes = new byte[1024];

                            int length = inputStream.read(bytes);

                            System.out.println(Thread.currentThread().getName()+" 服务端监听到数据："+accept.getInetAddress());
                            System.out.println(new String(bytes,0,length));

                            OutputStream outputStream = accept.getOutputStream();

                            outputStream.write("ok".getBytes());

                            accept.close();
                        } catch (IOException e) {
                            System.out.println(e);
                        }

                    }
                }).start();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
