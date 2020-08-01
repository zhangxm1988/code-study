package com.java.code.study.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 基于tcp协议的socket通讯，实现用户登录
 * 服务器端socket
 */
public class ServerSocketTest {

    public static void main(String[] args) {
        try {
            // 1、创建一个服务器socket
            ServerSocket serverSocket = new ServerSocket(8989);
            // 2、监听客户端连接
            System.out.println("*****服务器socket启动，等待客户端连接*****");
            Socket socket = serverSocket.accept();// 阻塞状态
            // 3、获取输入流并且获取客户端信息
            InputStream inputStream = socket.getInputStream();// 字节输入流
            // 字节输入流转换成字符输入流
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println("服务器接收客户端信息：" + info);
            }
            // 4、服务器给客户端响应信息
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write("服务器给客户端连接响应信息：成功，谢谢合作");
            writer.flush();
            socket.shutdownOutput();
            // 5、关闭资源
            writer.close();
            writer.close();
            bufferedReader.close();
            reader.close();
            inputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
