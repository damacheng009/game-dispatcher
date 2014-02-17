package com.company.game.dispatcher.util;

import java.lang.reflect.Method;

/**
 * 代表某个业务逻辑方法的反射相关数据
 * 
 * @author xingchencheng
 *
 */

public class HandlerReflectInfo {
	
	// 业务逻辑方法所在的类
	private Class<?> belongClazz;
	
	// 业务逻辑代表的方法
	private Method method;

	public Class<?> getBelongClazz() {
		return belongClazz;
	}

	public void setBelongClazz(Class<?> belongClazz) {
		this.belongClazz = belongClazz;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
	
}