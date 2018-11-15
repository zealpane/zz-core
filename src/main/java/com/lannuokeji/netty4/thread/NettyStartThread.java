package com.lannuokeji.netty4.thread;

import com.lannuokeji.netty4.SocketBootstrap;

public class NettyStartThread extends Thread {

	@Override
	public void run() {
		  SocketBootstrap server = new SocketBootstrap();
	        try {
				server.start(1139);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	
}
