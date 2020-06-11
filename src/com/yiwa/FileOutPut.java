package com.yiwa;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileOutPut {
    static private final byte message[]={12,32,45,65,76,87,98,12,32,43,115,127};

    public static void main(String[] args) throws IOException {
        FileOutputStream fout=new FileOutputStream("e:/io1.txt");
        FileChannel fc=fout.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        for (int i=0;i<message.length;i++){
            buffer.put(message[i]);
        }
        TestBuffer.output("buffer中加入数据后",buffer);
        buffer.flip();
        TestBuffer.output("切换buffer到读模式后",buffer);
        fc.write(buffer);
        TestBuffer.output("写出后",buffer);
        buffer.flip();
        TestBuffer.output("切换模式后",buffer);
        buffer.clear();
        TestBuffer.output("clear()后",buffer);
        fout.close();

    }
}
