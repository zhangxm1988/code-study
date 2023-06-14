package com.java.code.study.mps;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.mts.model.v20140618.QueryJobListRequest;
import com.aliyuncs.mts.model.v20140618.QueryJobListResponse;
import com.aliyuncs.mts.model.v20140618.SubmitJobsRequest;
import com.aliyuncs.mts.model.v20140618.SubmitJobsResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * *****   使用须知     ******
 * 本demo为基本的转码处理示例，不含水印、拼接等操作
 *
 * *****   方法介绍     ******
 * submitJobs  提交转码任务 https://help.aliyun.com/document_detail/602834.html
 * queryJobList  查询转码作业 https://help.aliyun.com/document_detail/602836.html
 * cancelJob  取消转码作业 https://help.aliyun.com/document_detail/602835.html
 * listJob  遍历转码作业 https://help.aliyun.com/document_detail/602837.html
 * 具体参数详情参考  https://help.aliyun.com/document_detail/29253.html
 *
 * *****   main方法     ******
 * main方法中仅以submitJobs作为调用示例, 如需调用其他方法请自行替换response
 */
public class TransCodeJobs {

    //管道ID, 可以在MPS控制台 > 全局设置 > 管道查看
    private static String pipelineId = "4caaf301df1046339392c8972fd42010";
    //模板ID, 预置模板参考 https://help.aliyun.com/document_detail/29256.html
    private static String templateId = "fb2d21716a58474dbf9ae4acce092e0e";

    public static void main(String[] args) throws ClientException {

        //初始化调用 client
        DefaultAcsClient client = InitClient.initMpsClient();

        SubmitJobsResponse response;
        try {
            response = submitJobs(client);
            System.out.println("RequestId is:"+response.getRequestId());
            //多个output请遍历getJobResultList()获取结果
            if (response.getJobResultList().get(0).getSuccess()) {
                System.out.println("JobId is:" + response.getJobResultList().get(0).getJob().getJobId());
                System.out.println("Response is:" + JSON.toJSONString(response));
            } else {
                System.out.println("SubmitJobs Failed code:" + response.getJobResultList().get(0).getCode() +
                        " message:" + response.getJobResultList().get(0).getMessage());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            QueryJobListResponse response1 = queryJobList(client);
            System.out.println(response1.getJobList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交转码作业
     * @param client
     * @return
     * @throws Exception
     */
    public static SubmitJobsResponse submitJobs(DefaultAcsClient client) throws Exception {

        SubmitJobsRequest request = new SubmitJobsRequest();
        //构建输出参数
        JSONArray outputs = new JSONArray();

        //构建input, 需要保证Location区域和服务client区域一致
        JSONObject input = new JSONObject();
        input.put("Location", "oss-cn-beijing");
        input.put("Bucket", "changxiangyinfu-app");

        //构建一个输出对象
        JSONObject output = new JSONObject();
        try {
            input.put("Object", URLEncoder.encode("/works/2023-05-22/0d932a5bf2ba4be88c6ffa1ff24ff8be.wav", "utf-8"));
            String outPutObject = URLEncoder.encode("/works/test/2023-06-12/test-0d932a5bf2ba4be88c6ffa1ff24ff8be.mp3", "utf-8");
            output.put("OutputObject", outPutObject);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("input URL encode failed");
        }
        output.put("TemplateId", templateId);
        outputs.add(output);

        request.setInput(input.toJSONString());
        request.setOutputs(outputs.toJSONString());
        //指定输出bucket
        request.setOutputBucket("changxiangyinfu-app");
        //输出bucket的所在区域,格式: oss-cn-****, 例如北京  oss-cn-beijing
        request.setOutputLocation("oss-cn-beijing");
        // PipelineId
        request.setPipelineId(pipelineId);

        return client.getAcsResponse(request);
    }

    /**
     * 查询转码作业
     * @param client
     * @return
     * @throws Exception
     */
    public static QueryJobListResponse queryJobList(DefaultAcsClient client) throws Exception {

        QueryJobListRequest request = new QueryJobListRequest();
        //支持查询多个JobID,一次最多查询10个,使用半角逗号（,）分隔
        request.setJobIds("b55bddb2febe4292b1582db91e4e205b");

        return client.getAcsResponse(request);
    }
}
