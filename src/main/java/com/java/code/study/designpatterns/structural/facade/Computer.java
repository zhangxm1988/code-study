package com.java.code.study.designpatterns.structural.facade;

/**
 * @author zhangxm
 * @description ${description}
 * @create 2019-07-01 19:00
 */
public class Computer {

  private CPU cpu;
  private Memory memory;
  private Disk disk;

  public Computer() {
    this.cpu = new CPU();
    this.memory = new Memory();
    this.disk = new Disk();
  }

  public void start() {
    cpu.start();
    memory.start();
    disk.start();
  }

  public void shutdown() {
    cpu.shutdown();
    memory.shutdown();
    disk.shutdown();
  }

}
