package nettydemo.danmu;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 服务端 ChannelInitializer
 * @author cz
 */
public class WebSocketDanmuServerInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	public void initChannel(SocketChannel ch) throws Exception {//2
		ChannelPipeline pipeline = ch.pipeline();
		// HTTP协议解码
		pipeline.addLast("http-decodec", new HttpRequestDecoder());
		// 限制HTTP请求大小
		pipeline.addLast("http-aggregator", new HttpObjectAggregator(65536));
		// HTTP协议编码
		pipeline.addLast("http-encodec", new HttpResponseEncoder());
		pipeline.addLast("http-chunked", new ChunkedWriteHandler());
		// Servlet
		pipeline.addLast("http-request", new HttpRequestHandler("/ws"));
		// 实现WebSocket协议的编码和解码
		pipeline.addLast("WebSocket-protocol", new WebSocketServerProtocolHandler("/ws"));
		// 实现弹幕发送业务
		pipeline.addLast("WebSocket-request", new TextWebSocketFrameHandler());
	}
}
