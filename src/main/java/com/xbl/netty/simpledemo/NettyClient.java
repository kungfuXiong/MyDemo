package com.xbl.netty.simpledemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {

        //客户端只需要一个事件循环组
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            //创建一个启动配置
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new NettyClientHandler());
                        }
                    });
            System.out.println("客户端 is ok");

            //后续分析异步模型
            ChannelFuture channelFuture = bootstrap.connect("localhost", 6669).sync();

            //关闭通道监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }


    }
}
