package com.java.code.study.mps;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;

/**
 * *****   使用须知     ******
 * InitClient为初始化client demo
 * accessKeyId和accessKeySecret是必须参数，如何获取参考https://help.aliyun.com/document_detail/29258.html
 * mpsRegionId为您要使用的MPS服务区域，请确保您处理的OSS文件区域和服务区域是一致的，服务支持的区域参考https://help.aliyun.com/document_detail/602824.html
 */
public class InitClient {

    public static String accessKeyId = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
    public static String accessKeySecret = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");
    public static String mpsRegionId = System.getenv().getOrDefault("MPS_REGION_ID", "cn-beijing");

    public static DefaultAcsClient initMpsClient() throws ClientException {
        if (accessKeyId == null || accessKeySecret == null) {
            throw new IllegalStateException("ALIBABA_CLOUD_ACCESS_KEY_ID and ALIBABA_CLOUD_ACCESS_KEY_SECRET env vars must be set");
        }

        DefaultProfile profile = DefaultProfile.getProfile(mpsRegionId, accessKeyId, accessKeySecret);
        DefaultAcsClient client = new DefaultAcsClient(profile);

        return client;
    }
}
