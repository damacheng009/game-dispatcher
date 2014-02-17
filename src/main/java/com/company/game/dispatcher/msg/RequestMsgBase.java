package com.company.game.dispatcher.msg;

/**
 * 请求消息基类
 * 
 * @author xingchencheng
 *
 */

public class RequestMsgBase extends AbstractMsg {
	
	// 请求参数列表，对应业务逻辑方法的参数列表
	private Object[] paraArray;
	
	public RequestMsgBase() {
	}
	
	public RequestMsgBase(short type) {
		super(type);
	}

	public Object[] getParaArray() {
		return paraArray;
	}

	public void setParaArray(Object[] paraArray) {
		this.paraArray = paraArray;
	}
	
}
