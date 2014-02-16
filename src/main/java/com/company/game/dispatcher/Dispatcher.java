package com.company.game.dispatcher;

import io.netty.channel.Channel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.company.game.dispatcher.exec.BusinessLogicExecutorBase;
import com.company.game.dispatcher.msg.RequestMsgBase;
import com.company.game.dispatcher.util.ClassUtil;

/**
 * 抽象了分发器
 * 多线程执行
 * 某个消息对象msgObject指定某个业务逻辑对象executor
 * submit到线程池中
 * @author xingchencheng
 *
 */

public class Dispatcher {
	
	private static final int MAX_THREAD_NUM = 50;
	
	private static ExecutorService executorService =
			Executors.newFixedThreadPool(MAX_THREAD_NUM);
	
	public static void submit(Channel channel, Object msgObject) 
			throws InstantiationException, IllegalAccessException {
		
		RequestMsgBase msg = (RequestMsgBase) msgObject;
		Class<?> executorClass = ClassUtil.getExecutorClassByType(msg.getType());
		BusinessLogicExecutorBase executor = 
				(BusinessLogicExecutorBase) executorClass.newInstance();
		executor.setChannel(channel);
		executor.setMsgObject(msgObject);
		
		executorService.submit(executor);
	}
}