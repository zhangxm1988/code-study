package com.java.code.study.java.time;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author zhxiaoming1988@163.com
 * @description
 * @date 2020/5/13 17:32
 */
public class InstantTest {

    public static void main(String[] args) {
        Instant ins = Instant.now();
        System.out.println(ins);

        OffsetDateTime time=ins.atOffset(ZoneOffset.ofHours(8));
        System.out.println(time);
    }

}
