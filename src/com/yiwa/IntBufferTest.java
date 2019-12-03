package com.yiwa;

import java.nio.IntBuffer;

public class IntBufferTest {
    public static void main(String[] args) {
        IntBuffer ib=IntBuffer.allocate(64);
        for(int i=0;i<32;i++){
            int j=i+1;
            ib.put(j);
        }
        TestBuffer.output("初始分配",ib);
        ib.flip();//写模式转换为读模式
        TestBuffer.output("初始分配",ib);
        while (ib.hasRemaining()){
            int j=ib.get();
            System.out.print(j+"  ");
        }
    }
}
