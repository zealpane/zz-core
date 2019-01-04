package com.lannuokeji.netty4;

import org.jboss.netty.channel.SimpleChannelHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class HttpServerBootstrap {
	public void start(int port) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			// 管道类型
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
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		HttpServerBootstrap server = new HttpServerBootstrap();
		server.start(1139);
	}
	
	
	/**
	 * 入栈Handler
	 * @author 泽朋
	 *
	 */
	public class HttpServerHanlder extends SimpleChannelInboundHandler<ByteBuf> {

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
			// TODO Auto-generated method stub
			
		}
		
	}
}
