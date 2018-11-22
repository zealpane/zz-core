package com.gdatacloud.dubbo;


public class RegisterCenter implements IRegisterCenter {

	/*private CuratorFramework curatorFramework;
	{
		// 根据ZkConfig中的字符串初始化curatorFramework
		curatorFramework = CuratorFrameworkFactory.builder().connectString(connectString)
	}*/
	
	@Override
	public void register(String serviceName, String serviceAddress) {
//		String servicePath = ZKConfig.ZK_REGISTER_PATH = "/" + serviceName;
	}
	
}
