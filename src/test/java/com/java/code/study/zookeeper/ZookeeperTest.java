package com.java.code.study.zookeeper;

import com.java.code.study.zookeeper.client.ZookeeperApi;
import com.java.code.study.zookeeper.watcher.WatcherApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhxiaoming1988@163.com
 * @description zookeeper test
 *
 * @date 2021/5/10 15:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZookeeperTest {

    @Autowired
    private ZookeeperApi zookeeperApi;

    @Test
    public void createZNodeTest() {
        zookeeperApi.createNode("/java-client", "java-value");
    }

    @Test
    public void getDataTest() {
        String nodeValue = zookeeperApi.getData("/java-client", new WatcherApi());
        System.out.println("path:/study-zookeeper node value is " + nodeValue);
    }

}
