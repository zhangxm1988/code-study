package com.java.code.study.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.Buffer;

/**
 * 基于tcp协议的socket通讯，客户端提交信息
 * socket客户端
 */
public class ClientSocketTest {

    public static void main(String[] args) {
        try {
            // 1、与服务器端建立连接，指定服务器端地址、端口
            Socket socket = new Socket("localhost", 8989);
            // 2、获取输出流  包装成打印流
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("username=admin;password=123456");
            printWriter.flush();
            socket.shutdownOutput();
            // 3、获取服务器端响应信息
            InputStream inputStream = socket.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String info = null;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println(info);
            }
            socket.shutdownInput();
            // 4、关闭相应的资源
            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            reader.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
