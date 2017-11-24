package org.bejond.netty.sample1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ResponseHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext channelHandlerContext, Object message) {
		channelHandlerContext.write(message);
		channelHandlerContext.flush();
	}
}
