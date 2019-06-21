package com.java.code.study.java.lang.system;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangxm
 * @description threadLocal out of memory
 * @create 2019-06-21 17:13
 */
public class ThreadLocalOOMTest {

  private static final int THREAD_LOOP_SIZE = 500;
  private static final int MOCK_DIB_DATA_LOOP_SIZE = 10000;

  private static ThreadLocal<List<User>> threadLocal = new ThreadLocal<>();

  public static void main(String[] args) {

    // ThreadLocal内存泄漏的根源是：由于ThreadLocalMap的生命周期跟Thread一样长，如果没有手动删除对应key就会导致内存泄漏，而不是因为弱引用。

    ExecutorService executorService = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);

    for (int i = 0; i < THREAD_LOOP_SIZE; i++) {
      executorService.execute(() -> {
        threadLocal.set(new ThreadLocalOOMTest().addBigList());
        System.out.println(Thread.currentThread().getName());
        threadLocal.remove();
      });

      try {
        Thread.sleep(1000L);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    executorService.shutdown();
  }

  private List<User> addBigList() {
    List<User> bigList = new ArrayList<>(MOCK_DIB_DATA_LOOP_SIZE);
    for (int i = 0; i < MOCK_DIB_DATA_LOOP_SIZE; i++) {
      bigList.add(new User("zhangxm", "password" + i, "男", i));
    }

    return bigList;
  }

  class User {
    private String username;
    private String password;
    private String sex;
    private int age;

    public User(String username, String password, String sex, int age) {
      this.username = username;
      this.password = password;
      this.sex = sex;
      this.age = age;
    }

  }
}
