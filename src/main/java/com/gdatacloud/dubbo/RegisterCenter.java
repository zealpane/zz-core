package com.gdatacloud.dubbo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;

public class RegisterCenter implements IRegisterCenter {

	private CuratorFramework curatorFramework;
	{
		// 根据ZkConfig中的字符串初始化curatorFramework
		curatorFramework = CuratorFrameworkFactory.builder().connectString("")
				.connectionTimeoutMs(1000).retryPolicy(null)
				.build();
	}
	
	@Override
	public void register(String serviceName, String serviceAddress) {
//		String servicePath = ZKConfig.ZK_REGISTER_PATH = "/" + serviceName;
	}
	
}
