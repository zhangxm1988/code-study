package com.java.code.study.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 此类表示互联网协议 (IP) 地址
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("主机名：" + address.getHostName());
        System.out.println("IP地址：" + address.getHostAddress());

        InetAddress address1 = InetAddress.getByName("LAPTOP-AFVHVD6N");
        System.out.println("主机名：" + address1.getHostName());
        System.out.println("IP地址：" + address1.getHostAddress());

        byte[] bytes = address.getAddress();
        System.out.println(Arrays.toString(bytes));
    }
}
