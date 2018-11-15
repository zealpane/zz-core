package com.gdatacloud.zz;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class MyHearSocket extends SimpleChannelInboundHandler<Object> {

	private ChannelHandlerContext ctx;
	private boolean inCoonect = false;
	
	@Override
	protected void channelRead0(ChannelHandlerContext arg0, Object arg1) throws Exception {
		// TODO Auto-generated method stub

	}

}
