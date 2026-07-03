package com.java.code.study.java.util.collection.group;

import lombok.Data;

import java.util.Date;

/**
 * @author zhxiaoming1988@163.com
 * @description
 * @date 2020/7/18 13:28
 */
@Data
public class AttendanceStatisticByDayDTO {
    /**
     * 员工ID
     */
    private String userId;

    /**
     * 员工编码
     */
    private String userCode;

    /**
     * 员工名称
     */
    private String userName;

    /**
     * 统计日期
     */
    private Date statisticDate;

    /**
     * 应上时长
     */
    private Float workDueHour;

    /**
     * 实上时长
     */
    private Float workRealHour;

    /**
     * 统计次数
     */
    private Integer statisticTimes;

    /**
     * 考勤配置ID
     */
    private String attendanceTypeId;

    /**
     * 考勤配置名称
     */
    private String attendanceTypeName;

}
