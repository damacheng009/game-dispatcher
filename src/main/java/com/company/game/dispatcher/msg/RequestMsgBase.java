package com.company.game.dispatcher.msg;

/**
 * 请求消息基类
 * 
 * @author xingchencheng
 *
 */

public class RequestMsgBase extends AbstractMsg {
	public RequestMsgBase() {
	}
	
	public RequestMsgBase(short type) {
		super(type);
	}
}
