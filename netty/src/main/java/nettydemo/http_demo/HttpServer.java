package nettydemo.http_demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;

/**
 * 1、初始化Bootstrap （连接）
 * 2、初始化pipeline(编解码)
 * 3、业务处理
 * Created by Tommy on 2018/1/23.
 */
public class HttpServer {

    /**
     *
     */

    public void openServer() {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.channel(NioServerSocketChannel.class);
        EventLoopGroup boot = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup(8);
        bootstrap.group(boot, work);
        bootstrap.childHandler(new ChannelInitializer() {
            @Override
            protected void initChannel(Channel ch) throws Exception {
                ch.pipeline().addLast("http-decode", new HttpRequestDecoder());//解码request 1
                ch.pipeline().addLast("http-encode", new HttpResponseEncoder());// 编码response 3
                ch.pipeline().addLast("http-server-handler", new HttpServerHandler()); // 业务处理2
            }
        });
        try {
            ChannelFuture f = bootstrap.bind(8080).sync();
            System.out.println("服务启动成功：8080");
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boot.shutdownGracefully();
            work.shutdownGracefully();
        }
    }

    private static class HttpServerHandler extends SimpleChannelInboundHandler {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {

            DefaultFullHttpResponse response =
                    new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
                            HttpResponseStatus.OK);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=utf-8");
            String src = "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>hello word</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "hello word\n" +
                    "</body>\n" +
                    "</html>";
            response.content().writeBytes(src.getBytes("UTF-8"));
            ChannelFuture f = ctx.writeAndFlush(response);
            ChannelFuture f2=ctx.channel().writeAndFlush(response);
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        server.openServer();
    }
}
