package com.yiwa;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestBuffer {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("e:/io.txt");
        FileChannel fc=fis.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        output("初始化",buffer);
        fc.read(buffer);
        output("调用read()",buffer);
        buffer.flip();
        output("调用flip(),",buffer);
        while(buffer.remaining()>0){
            byte b=buffer.get();
            System.out.print((char)b);
        }
        output("调用get()",buffer);
        buffer.clear();
        output("d调用clear(),",buffer);
        fis.close();

    }
    public static void output(String step, Buffer buffer){
        System.out.println(step+":" );
        System.out.println("capacity:"+buffer.capacity()+"，");
        System.out.println("position:" +buffer.position()+",");
        System.out.println("limit:"+buffer.limit()+",");
        System.out.println("mark:" +buffer.mark()+".");
        System.out.println("+++++++++++++++++++++++++++++++++");
    }
}
