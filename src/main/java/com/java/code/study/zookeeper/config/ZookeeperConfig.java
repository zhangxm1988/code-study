package com.java.code.study.zookeeper.config;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhxiaoming1988@163.com
 * @description zookeeper config
 *
 * @date 2021/5/10 14:59
 */
@Configuration
public class ZookeeperConfig {

    private static final Logger logger = LoggerFactory.getLogger(ZookeeperConfig.class);

    @Value("${zookeeper.address}")
    private String connectString;

    @Value("${zookeeper.timeout}")
    private int timeout;

    @Bean("zookeeperClient")
    public ZooKeeper zooKeeperClient() {
        ZooKeeper zooKeeper = null;

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        try {
            // 连接成功后，会回调watcher监听，此连接操作是异步的，执行完new语句后，直接调用后续代码
            // 可指定多台服务地址 127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183
            zooKeeper = new ZooKeeper(connectString, timeout, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    if (Event.KeeperState.SyncConnected == watchedEvent.getState()) {
                        //如果收到了服务端的响应事件,连接成功
                        countDownLatch.countDown();
                    }
                }
            });

            countDownLatch.await();
            logger.info("初始化ZooKeeper连接状态....={}", zooKeeper.getState());
        } catch (Exception ex) {
            logger.error("初始化ZooKeeper连接异常....】={}", ex);
        }

        return zooKeeper;
    }

}
