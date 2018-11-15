package com.lannuokeji.netty4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lannuokeji.netty4.utils.NettyChannel;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.AttributeKey;

// 该handler是InboundHandler类型  
public class MonitorServerInHandler extends SimpleChannelInboundHandler<ByteBuf> {
	private static Logger logger = LoggerFactory.getLogger(MonitorServerInHandler.class);
	public static final AttributeKey<NettyChannel> NETTY_CHANNEL_KEY = AttributeKey.valueOf("netty.channel");
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.netty.channel.ChannelInboundHandlerAdapter#channelRegistered(io.netty.
	 * channel.ChannelHandlerContext)
	 */
	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		super.channelRegistered(ctx);
		System.out.println("注册");
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		System.out.println("激活");
		
		/*System.out.println(getRemoteAddress(ctx));
		System.out.println(getIPString(ctx));*/
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * io.netty.channel.ChannelInboundHandlerAdapter#channelUnregistered(io.netty.
	 * channel.ChannelHandlerContext)
	 */
	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		super.channelUnregistered(ctx);
		System.out.println("注销");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see io.netty.channel.ChannelInboundHandlerAdapter#channelInactive(io.netty.
	 * channel.ChannelHandlerContext)
	 */
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelInactive(ctx);
		System.out.println("关闭");
	}
		
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		// TODO Auto-generated method stub
//		logger.info("HelloServerInHandler.channelRead");
		// 接收，先取出地址码（地址码在数据的第九和第十字节），回复；然后再判断类型，处理数据
		ByteBuf adrByteBuf = null;
		
		adrByteBuf = msg.copy(8, 2);
		byte[] adrByte = new byte[adrByteBuf.readableBytes()];
		// 存储的是ByteBuf类型的数据，把数据读取到byte[]中
		adrByteBuf.readBytes(adrByte);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}

	public static String getRemoteAddress(ChannelHandlerContext ctx) {
		String socketString = "";
		socketString = ctx.channel().remoteAddress().toString();
		return socketString;
	}

	public static String getIPString(ChannelHandlerContext ctx) {
		String ipString = "";
		String socketString = ctx.channel().remoteAddress().toString();
		int colonAt = socketString.indexOf(":");
		ipString = socketString.substring(1, colonAt);
		return ipString;
	}
}