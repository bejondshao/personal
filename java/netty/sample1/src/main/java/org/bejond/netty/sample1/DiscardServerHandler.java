package org.bejond.netty.sample1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		// Discard the received data silently.
		// ((ByteBuf) msg).release();

		ByteBuf in = (ByteBuf) msg;
		try {
			System.out.println(in.toString(io.netty.util.CharsetUtil.US_ASCII));
			/*while (in.isReadable()) {
				System.out.println((char) in.readByte());
				System.out.flush();
			}*/
			ctx.fireChannelRead(msg); // send message to next handler
		} finally {
			//ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		// Close the connection when an exception is raised.
		cause.printStackTrace();
		ctx.close();
	}
}
