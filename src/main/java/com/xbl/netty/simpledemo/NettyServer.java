package com.xbl.netty.simpledemo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        //创建BossGroup WorkerGroup
        //说明
        //1.bossGroup仅处理连接请求，workerGroup真正完成客户端的业务处理
        //2.两个group都是无限循环
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);
        try {

            //创建服务器端启动的配置对象，并配置启动参数
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            //链式编程进行配置
            serverBootstrap.group(bossGroup, workerGroup)//设置两个线程组
                    .channel(NioServerSocketChannel.class)//设置NioServerSocketChannel作为处服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG, 128)//设置线程队列的得到的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true)//设置保持线程活动状态
                    .childHandler(
                            new ChannelInitializer<SocketChannel>() {
                                //向pipeline 设置处理器
                                @Override
                                protected void initChannel(SocketChannel ch) throws Exception {
                                    //尾部追加一个处理器
                                    ch.pipeline().addLast(new NettyServerHandler());
                                }
                            }
                    );//给workerGroup的enventloop对象的管道设置处理器
            System.out.println("......服务器 is ready ......");

            //绑定一个端口并且同步，生成一个ChannelFuture对象
            //同时启动服务器
            ChannelFuture channelFuture = serverBootstrap.bind(6669).sync();

            //对关闭通道进行监听
            channelFuture.channel().closeFuture().sync();
        } finally {
            //优雅的关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
