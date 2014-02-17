package com.company.game.dispatcher.codec;

import com.company.game.dispatcher.msg.AbstractMsg;
import com.company.game.dispatcher.util.GsonUtil;
import com.google.gson.Gson;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 * 客户端和服务端均有使用
 * 0-1字节表示整个消息的长度（单位：字节）
 * 余下的是消息的json字符串（UTF-8编码）
 * 
 * @author xingchencheng
 *
 */

public class MsgEncoder extends MessageToByteEncoder<AbstractMsg>{

	@Override
	protected void encode(ChannelHandlerContext ctx, AbstractMsg msg,
			ByteBuf buf) throws Exception {
		
		Gson gson = GsonUtil.getGson();
		String json = gson.toJson(msg);

		byte[] jsonBytes = json.getBytes("UTF-8");
		buf.writeShort(jsonBytes.length);
		buf.writeBytes(jsonBytes);
	}
	
}
