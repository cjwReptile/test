package design.reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;

/**
 * @Auther: cjw
 * @Date: 2019/4/24 15:43
 * @Description:
 */
public abstract class AbstractNioChannel {

    private SelectableChannel channel;

    public abstract void bind() throws IOException;

    public SelectableChannel getChannel() {
        return channel;
    }

    public void setChannel(SelectableChannel channel) {
        this.channel = channel;
    }

    public abstract ByteBuffer read(SelectionKey key) throws IOException;

    public abstract void write(SelectionKey key,Object data) throws IOException;

}
