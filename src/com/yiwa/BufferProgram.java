package com.yiwa;
//==============================================================================================================

//    IO                                                        NIO




//

import java.nio.ByteBuffer;

/**
 * 缓冲区：在javaNIO中负责数据的存取 缓冲区就是数组  用于存储不同数据类型的数据，根据数据类型不同提供了相应的缓冲区 出国boolean
 * ByteBUffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBUffer
 * DoubleBuffer
 *
 *通过allocate（）获取缓冲区
 * 缓冲区存取数据两个核心方法
 * put()从如数据到缓冲区
 * get()获取缓冲区中的数据
 * 四个核心属性：
 * capacity limit position mark
 *
 */
public class BufferProgram {
    public static void main(String[] args) {
        String str="abcdf";
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
        buffer.flip();
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
        byte[] dst=new byte[buffer.limit()];
        buffer.get(dst);
        System.out.println(new String(dst,0,dst.length));
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
        buffer.rewind();
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
        buffer.clear();
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        System.out.println((char)buffer.get());
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());
        System.out.println(buffer.mark());
        System.out.println((char)buffer.get());
        buffer.reset();
        System.out.println(buffer.limit());
        System.out.println(buffer.position());
        System.out.println(buffer.capacity());

    }
}
