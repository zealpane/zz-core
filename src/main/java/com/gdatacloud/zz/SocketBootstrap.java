package com.gdatacloud.zz;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class SocketBootstrap {
	public void start(int port) throws Exception {
		// 网络事件处理，接受客户端连接
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		// 进行网络通讯读写
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						public void initChannel(SocketChannel ch)
								throws Exception {
							ch.pipeline().addLast(new LineBasedFrameDecoder(2048));
//							ch.pipeline().addLast(new StringDecoder());
							// 注册handler
							ch.pipeline().addLast(new MonitorServerInHandler());
						}
					})
					/**
					  * BACKLOG用于构造服务端套接字ServerSocket对象，标识当服务器请求处理线程全满时，
					  * 用于临时存放已完成三次握手的请求的队列的最大长度。如果未设置或所设置的值小于1，将使用默认值50。
					  * 服务端处理客户端连接请求是顺序处理的，所以同一时间只能处理一个客户端连接，多个客户端来的时候，
					  * 服务端将不能处理的客户端连接请求放在队列中等待处理，backlog参数指定了队列的大小
					  */
					.option(ChannelOption.SO_BACKLOG, 1024 * 40)
					.childOption(ChannelOption.SO_KEEPALIVE, true);

			System.out.println("已启动？");
			final ChannelFuture f = b.bind(port).sync();

			f.channel().closeFuture().sync();
			/*new Runnable() {
				@Override
				public void run() {
					try {
						f.channel().closeFuture().sync();// 关闭连接
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			};*/
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		SocketBootstrap server = new SocketBootstrap();
		server.start(1139);
	}
}
