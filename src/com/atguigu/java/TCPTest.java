package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author DavidWong
 * @create 2020-03-23 21:13
 */

public class TCPTest{
    @Test
    public void client() throws IOException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");//指明对方的ip和端口号
        int port  = 9090;
        Socket socket = new Socket(inetAddress,port);
        OutputStream os = socket.getOutputStream();
        os.write("你好！".getBytes());

        os.close();
        socket.close();

    }
    @Test
    public void service() throws IOException {
        int port = 9090;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[1024];
   //     ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
        int len;
        while ((len = inputStream.read(buffer)) != -1){
//          byteArrayInputStream.
//            System.out.println(string);
        }

        inputStream.close();
        socket.close();
//        serverSocket.close(); 服务器对象一般不关闭
    }
}
