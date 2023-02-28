package com.qinglan.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) {
        try {
            while (true) {
                Socket socket = new Socket("localhost",8989);

                OutputStream outputStream = socket.getOutputStream();

//                System.out.println("客户端发送消息："+User.xiongbl);
                outputStream.write(User.xiongbl.toString().getBytes());

                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int read = inputStream.read(bytes);

                System.out.println("客户端收到消息："+socket.getPort());
                System.out.println(new String(bytes,0,read));

                socket.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
