package com.java.code.study.socket;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 统一资源定位符
 * 协议名称:资源名称
 */
public class URLTest {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.baidu.com");

            URL newUrl = new URL(url, "/index.html?username=hero#test");
            System.out.println(newUrl.getProtocol());
            System.out.println(newUrl.getHost());
            // 如果为指定端口号，则使用默认端口号
            System.out.println(newUrl.getPort());
            System.out.println(newUrl.getPath());
            System.out.println(newUrl.getFile());
            System.out.println(newUrl.getRef());
            System.out.println(newUrl.getQuery());

            // 读取

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
