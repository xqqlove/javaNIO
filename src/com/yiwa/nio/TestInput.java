package com.yiwa.nio;

import org.junit.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutionException;

public class TestInput {

    @Test
    public void methed() throws IOException {
        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("D:/qiangInFile/file1.txt"));
            byte[] buf = new byte[1024];
            int read = in.read(buf);
            while (read != -1) {
                System.out.print(new String(buf, 0, read,"UTF-8"));
                read = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            in.close();

        }
    }
    @Test
    public void method1() throws IOException{
        FileInputStream fileInputStream=null;
        try {
            fileInputStream=new FileInputStream("D:/qiangInFile/file1.txt");
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer buf=ByteBuffer.allocate(1024);
            int read = channel.read(buf);
            System.out.println(read);
            while (read!=-1){
                buf.flip();
                while(buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                buf.compact();
                read=channel.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileInputStream.close();
        }

    }

    /**
     * NIO
     */
    @Test
    public void method2() throws Exception {
        FileInputStream in=new FileInputStream("D:/qiangInFile/file1.txt");
        //创建文件的操作管道
        FileChannel channel = in.getChannel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        output("初始化",buffer);
        channel.read(buffer);
        output("调用read:",buffer);
        buffer.flip();
        output("调用flip:",buffer);
        while (buffer.remaining()>0){
            System.out.print(((char)buffer.get()));
        }
        System.out.println("");
        output("调用get",buffer);
        buffer.clear();
        output("调用clear",buffer);
        in.close();

    }

    public static void output(String step, Buffer buffer){
        System.out.println(step+"：");
        //容量
        System.out.println("capacity:"+buffer.capacity()+"，");
        //游标位置，位置会自动由相应的 get( )和 put( )函数更新。
        System.out.println("position:"+buffer.position()+"，");
        //锁定值，flip，数据操作范围索引只能在position-limit之间：缓冲区的第一个不能被读或写的元素。或者说,缓冲区中现存元素的计数。
        System.out.println("limit:"+buffer.limit()+",");
        //下一个读或者写的元素的索引位置会自动由相应的 get( )和 put( )函数更新。
        System.out.println("mark:"+buffer.mark());
        System.out.println("===============================================================================");
    }

    @Test
    public void method3(){
        IntBuffer buffer=IntBuffer.allocate(8);
        for (int i=0;i<buffer.capacity();i++){
            int j=(i+1);
            buffer.put(j);
        }
        buffer.flip();
        while (buffer.hasRemaining()){
            System.out.print(buffer.get());
        }
    }

    @Test
    public void method4(){
        ByteBuffer buffer=ByteBuffer.allocate(10);
        for (int i=0;i<buffer.capacity();i++){
            buffer.put((byte) i);
        }

        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice=buffer.slice();

        for (int i=0;i<slice.capacity();i++){
            byte b=slice.get(i);
            b*=10;
            slice.put(i,b);
            System.out.println(b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());
        while (buffer.remaining()>0)
            System.out.print(buffer.get()+" ");
    }

    @Test
    public void  method5() throws Exception{
        FileInputStream fin=new FileInputStream("D:/qiangInFile/file1.txt");
        FileChannel channel = fin.getChannel();
        FileOutputStream fout=new FileOutputStream("D:/qiangInFile/qq.txt");
        FileChannel channel1 = fout.getChannel();

        ByteBuffer buffer=ByteBuffer.allocate(10);

        while (true) {
            buffer.clear();
            int read = channel.read(buffer);
            buffer.compact();
            if (read==-1) break;
            buffer.flip();
            channel1.write(buffer);
        }


    }
}
