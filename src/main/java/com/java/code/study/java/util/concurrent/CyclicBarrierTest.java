package com.java.code.study.java.util.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-28 09:56
 */
public class CyclicBarrierTest {

  // CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）。
  // 它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续工作。
  // CyclicBarrier默认的构造方法是CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，每个线程调用await方法告诉CyclicBarrier当前线程已经到达了屏障，然后当前线程被阻塞

  // 需要所有的子任务都完成时，才执行主任务，这个时候就可以选择使用CyclicBarrier
  //如在进行版权库匹配任务时，需要把曲库数据迁移至版权库，版权库中的匹配结果显示中才会有相应的数据，
  // 即多个线程一起迁移数据，等数据迁移完之后，再分别执行匹配任务。

  public static void main(String[] args) {
    int countSize = 5;
    CyclicBarrier cyclicBarrier = new CyclicBarrier(countSize);
    for (int i = 0; i < countSize; i++) {
      new CyclicBarrierThread(cyclicBarrier).start();
    }
  }

}

class CyclicBarrierThread extends Thread {
  private CyclicBarrier cyclicBarrier;
  public CyclicBarrierThread(CyclicBarrier cyclicBarrier) {
    this.cyclicBarrier = cyclicBarrier;
  }

  @Override
  public void run() {
    try {
      Thread.sleep((long) Math.random() * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    try {
      System.out.println("before await. Thread id:" + Thread.currentThread().getName());
      // TODO doImportTask() ; // 导入数据
      this.cyclicBarrier.await();

      // TODO doMatchTask();  // 进行匹配操作
      System.out.println("after await. Thread id:" + Thread.currentThread().getName());
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (BrokenBarrierException e) {
      e.printStackTrace();
    }

  }

}
