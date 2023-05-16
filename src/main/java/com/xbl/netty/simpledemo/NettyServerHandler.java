package com.xbl.netty.simpledemo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;

public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    //读取客户端的数据

    /**
     * ChannelHandlerContext 上下文对象，含有管道pipeline，通道channel，地址
     * Object msg客户端发送的数据包，以对象形式接收
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("服务器读取线程"+ Thread.currentThread().getName());
        System.out.println("server ctx = " +ctx);

        //将msg转为ByteBuffer
        ByteBuf buf = (ByteBuf)msg;
        System.out.println("客户端发送的消息是 ：" + buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址 ：" + ctx.channel().remoteAddress());

    }


    /**
     * ChannelHandlerContext 上下文对象，含有管道pipeline，通道channel，地址
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //数据写入缓冲区，并且刷新
        //一般讲，我们发送的数据需要进行编码
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello，客户端",CharsetUtil.UTF_8));
    }

    /**
     * 发生异常后一般需要关闭通道
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
