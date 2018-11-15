package com.lannuokeji.netty4;

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
		EventLoopGroup bossGroup = new NioEventLoopGroup();
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
					}).option(ChannelOption.SO_BACKLOG, 1024 * 40)
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
