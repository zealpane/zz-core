package com.gdatacloud.redis;

import redis.clients.jedis.Jedis;

public class JedisClient {

	public static void main(String[] args) {
		// 1、建立连接；2、RESP协议。redis快的因素：基于内存、单线程、RESP协议
		Jedis jedis = new Jedis("localhost", 6379);
		jedis.getSet("name", "zzp");
		jedis.set("name", "zzp");
		jedis.close();
	}
}
