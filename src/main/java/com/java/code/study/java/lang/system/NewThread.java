package com.java.code.study.java.lang.system;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-06-18 11:07
 */
public class NewThread implements Runnable {

  @Override
  public synchronized void run() {
    while (true) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      System.out.println("自定义线程启动了");
    }
  }

  public static void main(String[] args) {

    // JAVA多线程中的 wait()方法 与 notify()/notifyAll()方法的用法。
    // ①wait() 与 notify/notifyAll 方法必须在同步代码块中使用
    // ②wait() 与  notify/notifyAll() 的执行过程
    // ③中断 调用wait()方法进入等待队列的 线程
    // ④notify 通知的顺序不能错
    // ⑤多线程中测试某个条件的变化用 if 还是用 while？
    NewThread newThread = new NewThread();
    Thread thread = new Thread(newThread);
    thread.start();
    while (true) {
      synchronized (newThread) {
        System.out.println("主线程运行了");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

        newThread.notifyAll();
      }
    }
  }
}
