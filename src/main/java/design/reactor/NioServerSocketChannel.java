package design.reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Auther: cjw
 * @Date: 2019/4/24 15:42
 * @Description:
 */
public class NioServerSocketChannel extends AbstractNioChannel{

    private int port;

    private ChannelHandel handel;

    public NioServerSocketChannel(int port, ChannelHandel handel) {
        this.port = port;
        this.handel = handel;
    }

    @Override
    public void bind() throws IOException {
        getChannel().socket().bind(new InetSocketAddress(port));
    }

    @Override
    public ServerSocketChannel getChannel() {
        return (ServerSocketChannel)super.getChannel();
    }

    @Override
    public ByteBuffer read(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel) key.attachment();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        int read = channel.read(byteBuffer);
        byteBuffer.flip();
        if(read == -1){
            throw  new IOException();
        }
        return byteBuffer;
    }

    @Override
    public void write(SelectionKey key, Object data) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer)data;
        ((SocketChannel)key.channel()).write(byteBuffer);
    }


}
