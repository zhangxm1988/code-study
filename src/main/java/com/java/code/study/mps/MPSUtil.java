package com.java.code.study.mps;

import java.net.MalformedURLException;
import java.net.URL;

public class MPSUtil {

    public static void main(String[] args) {
        URL url;
        try {
            String audioUrl = "https://meta-boom.oss-cn-shanghai.aliyuncs.com/users/2023-03-08/1ce0b63b051f49cdadfa38523ec7bcb4.wav";
            url = new URL(audioUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("input URL error");
        }

        String audioFileName = url.getFile().replaceFirst("\\/", "");
        System.out.println("audioFileName:" + audioFileName);

        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getProtocol());
    }
}
