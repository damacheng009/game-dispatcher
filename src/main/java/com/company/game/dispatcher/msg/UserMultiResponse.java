package com.company.game.dispatcher.msg;

import com.company.game.dispatcher.annotation.UserMsgAndExecAnnotation;

/**
 * 乘法请求响应消息类
 * 注意msgType是乘法请求类的msgType的负数
 * 
 * @author xingchencheng
 *
 */

@UserMsgAndExecAnnotation(msgType = -MsgType.MULTI)
public class UserMultiResponse extends ResponseMsgBase{
	
	private double result;
	
	public UserMultiResponse() {
		super(MsgType.MULTI);
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "result: " + this.result;
	}
}