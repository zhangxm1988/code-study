package com.java.code.study.java.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @author zhxiaoming1988@163.com
 * @description jdk1.8 时间对象调整
 *
 * @date 2020/5/13 17:50
 */
public class LocalDateTest {

    public static void main(String[] args) {
        // 计算时间
        LocalDate now = LocalDate.now(); //创建当前时间

        // 定义一个需要运算的时间 并规定格式
        LocalDate start = LocalDate.parse("2016-05-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 使用ChronoUnit 来计算年月日
        long daysDiff = ChronoUnit.DAYS.between(start, now);
        long monthDiff  = ChronoUnit.MONTHS.between(start, now);
        long yearsDiff = ChronoUnit.YEARS.between(start, now);

        // 结果：
        System.out.println("相差"+yearsDiff+"年"+monthDiff+"月"+daysDiff+"天");
    }

}
