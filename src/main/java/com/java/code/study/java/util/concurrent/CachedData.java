package com.java.code.study.java.util.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangxm
 * @description readWriteLock study
 *
 * @create 2019-06-26 14:57
 */
public class CachedData {

  Object data;
  volatile boolean cacheValid;
  final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

  public void processCacheData() {
    readWriteLock.readLock().lock();
    if (!cacheValid) {
      // must release read lock before acquiring write lock
      readWriteLock.readLock().unlock();
      readWriteLock.writeLock().lock();

      try {
        if (!cacheValid) {
          // Recheck state because another thread might have,
          // acquired write lock and changed state before we did.

          data = new Object();
          cacheValid = true;
        }
        // 在释放写锁之前通过获取读锁降级写锁(注意此时还没有释放写锁)
        readWriteLock.readLock().lock();

      } finally {
        readWriteLock.writeLock().unlock();
        readWriteLock.readLock().unlock();
      }
    }
  }

}
