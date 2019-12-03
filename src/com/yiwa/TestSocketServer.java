package com.yiwa;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TestSocketServer {
    //server
    public static void main(String[] args)
    {
        ServerSocket serverSocket=null;
        InputStream in=null;

        try {
            serverSocket=new ServerSocket(8085);
            int recvMsgsize=0;
            byte[] recvBuf=new byte[1024];
            while (true){
                Socket xlntSocket=serverSocket.accept();
                SocketAddress clentAddress=xlntSocket.getRemoteSocketAddress();
                System.out.println("Handling client at "+clentAddress);
                in=xlntSocket.getInputStream();
                while ((recvMsgsize=in.read(recvBuf))!=-1){
                    byte[] temp=new byte[recvMsgsize];
                    System.arraycopy(recvBuf,0,temp,0,recvMsgsize);
                    System.out.println(new String(temp));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (serverSocket!=null) {
                    serverSocket.close();
                }
                if (in!=null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
