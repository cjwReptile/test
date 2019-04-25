package design.reactor;

import java.io.IOException;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Auther: cjw
 * @Date: 2019/4/24 15:41
 * @Description:
 */
public class Reactor {

    private Selector selector;

    private ExecutorService executorService;

    public Reactor() throws IOException {
        this.selector = Selector.open();
        executorService = Executors.newSingleThreadExecutor();
    }

    public Reactor register(AbstractNioChannel channel) throws IOException {
        SelectionKey key = channel.getChannel().register(selector,SelectionKey.OP_ACCEPT);
        channel.bind();
        key.attach(channel);
        return this;
    }

    public void start(){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    eventLoop();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public void eventLoop() throws IOException {

        while(true){
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator iterator = keys.iterator();
            while(iterator.hasNext()){
                SelectionKey key = (SelectionKey)iterator.next();
                if(key.isAcceptable()){
                    onAcceptEventHandle(key);
                }else if(key.isReadable()){
                    onReadEventHandle(key);
                }else if(key.isWritable()){
                    onWriteEventHandle(key);
                }
                iterator.remove();
            }
        }

    }

    public void onAcceptEventHandle(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel  =(ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        SelectionKey readKey = socketChannel.register(selector,SelectionKey.OP_READ);
        readKey.attach(key.attachment());
    }

    public void onReadEventHandle(SelectionKey key){


    }

    public void onWriteEventHandle(SelectionKey key){
        SocketChannel socketChannel =(SocketChannel) key.attachment();
    }

}
