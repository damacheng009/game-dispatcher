package com.company.game.dispatcher.codec;

import java.util.List;

import com.company.game.dispatcher.msg.RequestMsgBase;
import com.company.game.dispatcher.msg.ResponseMsgBase;
import com.company.game.dispatcher.util.GsonUtil;
import com.google.gson.Gson;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 解码器
 * 客户端和服务端均有使用
 * 0-1字节表示整个消息的长度（单位：字节）
 * 余下的是消息的json字符串（UTF-8编码）
 * 
 * @author xingchencheng
 *
 */

public class MsgDecoder extends ByteToMessageDecoder {

	private boolean isServer;
	
	public MsgDecoder(boolean isServer) {
		this.isServer = isServer;
	}
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf buf,
			List<Object> list) throws Exception {
		
		if (buf.readableBytes() < 2) {
			return;
		}
		
		Gson gson = GsonUtil.getGson();
		short jsonBytesLength = (short) (buf.readShort());
		
		byte[] tmp = new byte[jsonBytesLength];
		buf.readBytes(tmp);
		String json = new String(tmp, "UTF-8");
		
		Class<?> clazz = RequestMsgBase.class;
		if (isServer == false) {
			clazz = ResponseMsgBase.class;
		}
		
		Object msgObj = gson.fromJson(json, clazz);
		list.add(msgObj);
	}
}
