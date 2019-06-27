package com.java.code.study.java.util.concurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangxm
 * @description 读写锁
 *
 * @create 2019-06-26 14:47
 */
public class ReadWriteLockTest {

  private Map<String, Object> map = new HashMap<>(128);

  private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

  public static void main(String[] args) {

    new Thread(new Runnable() {
      @Override
      public void run() {
        Object value = new ReadWriteLockTest().get("key");
        System.out.println("value:" + value.toString());
      }
    }).start();

  }

  public Object get(String key) {
    Object value = null;
    readWriteLock.readLock().lock();
    try {
      // 缓存中没有 开启写锁
      if (map.get(key) == null) {
        readWriteLock.readLock().unlock();
        readWriteLock.writeLock().lock();
        try {
          if (value == null) {
            value = "redis-value";
          }
          readWriteLock.readLock().lock();
        } finally {
          readWriteLock.writeLock().unlock();
        }
      }
    } finally {
      readWriteLock.readLock().unlock();
    }

    return value;
  }

}
