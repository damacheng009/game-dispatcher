package com.company.game.dispatcher.server;

import com.company.game.dispatcher.codec.MsgDecoder;
import com.company.game.dispatcher.codec.MsgEncoder;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 服务端启动类
 * 
 * @author xingchencheng
 *
 */

public class ServerBootstrapStarter {
	
	public static void start(int serverPort) {
		
		ServerBootstrap serverBootstrap = new ServerBootstrap();
		serverBootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup())
		.channel(NioServerSocketChannel.class)
		.childHandler(new ChannelInitializer<Channel>() {

			@Override
			protected void initChannel(Channel channel) throws Exception {
				ChannelPipeline pipeline = channel.pipeline();

				// pipeline.addLast("logger", new LoggingHandler(LogLevel.DEBUG));
				pipeline.addLast("encoder", new MsgEncoder());
				pipeline.addLast("LengthFieldBasedFrameDecoder", 
						new LengthFieldBasedFrameDecoder(65 * 1024, 0, 2));
				pipeline.addLast("decoder", new MsgDecoder());
				pipeline.addLast("handler", new ServerDispatcherHandler());
			}
	
		});
		
		ChannelFuture bindFuture = serverBootstrap.bind(serverPort);
		bindFuture.addListener(new ChannelFutureListener() {
			
			public void operationComplete(ChannelFuture channelFuture) throws Exception {
				if (channelFuture.isSuccess()) {
		            System.out.println("Server bound");
		        } else {
		            System.err.println("Bound attempt failed");
		            channelFuture.cause().printStackTrace();
		        }
			}
			
		});
	}
	
}