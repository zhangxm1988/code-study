package com.java.code.study.java.util.collection.group;

import lombok.Data;

/**
 * @author zhxiaoming1988@163.com
 * @description 用于统计的值
 *
 * @date 2020/7/18 13:29
 */
@Data
public class ComputeGroupByDTO {

    /**
     * 总条数
     */
    private long totalCount;

    /**
     * 总的工作小时数
     */
    private Double dueHourSum;

    /**
     * 真实的小时数
     */
    private Double realHourSum;

}
