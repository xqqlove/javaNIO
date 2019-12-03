package com.yiwa;



import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class TestSocketChannel {
   //clent
    public static void main(String[] args) {
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        SocketChannel socketChannel=null;
        try {

            socketChannel=SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("10.100.130.206",8085));

            if (socketChannel.finishConnect()){
                int i=0;
                while (true){
                    TimeUnit.SECONDS.sleep(1);
                    String info="I am "+i+++"-th information from client";
                    buffer.clear();
                    buffer.put(info.getBytes());
                    buffer.flip();
                    while(buffer.hasRemaining()){
                        System.out.println(buffer);
                        socketChannel.write(buffer);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {
                if (socketChannel!=null){
                    socketChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
