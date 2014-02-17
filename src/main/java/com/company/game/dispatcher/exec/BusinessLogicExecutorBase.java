package com.company.game.dispatcher.exec;

import java.lang.reflect.Method;

import com.company.game.dispatcher.msg.RequestMsgBase;
import com.company.game.dispatcher.msg.ResponseMsgBase;

import io.netty.channel.Channel;

/**
 * 执行业务逻辑的基类
 * 实现Runnable接口
 * 
 * @author xingchencheng
 *
 */

public class BusinessLogicExecutorBase implements Runnable {

	protected Channel channel;
	
	protected RequestMsgBase msgObject;
	
	protected Class<?> clazz;
	
	protected Method method;
	
	public void run() {
		ResponseMsgBase response = new ResponseMsgBase(msgObject.getType());
		try {
			Object object = clazz.newInstance();
			// 此处返回一个Object[]更合理吧，有可能返回多个值
			Object result = method.invoke(object, msgObject.getParaArray());
			response.setResultArray(new Object[]{result});
			response.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			response.setSuccess(false);
		} finally {
			channel.writeAndFlush(response);
		}
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public RequestMsgBase getMsgObject() {
		return msgObject;
	}

	public void setMsgObject(RequestMsgBase msgObject) {
		this.msgObject = msgObject;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

}