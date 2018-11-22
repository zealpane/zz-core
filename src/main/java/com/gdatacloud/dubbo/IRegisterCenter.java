package com.gdatacloud.dubbo;

public interface IRegisterCenter {

	/**
	 * 
	 * @param serviceName 本地服务名称
	 * @param serviceAddress 当前服务的地址
	 */
	void register(String serviceName, String serviceAddress);
}
