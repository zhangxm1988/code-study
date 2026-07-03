package com.java.code.study.java.util.collection.group;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zhxiaoming1988@163.com
 * @description stream 多字段分组、多个列汇总统计
 *
 * @date 2020/7/18 13:26
 */
public class StreamGroupTest {


    /**
     * 分组的条件
     *
     * @param attendanceStatisticByDayDTO 考勤统计
     * @return 返回分组的KEY
     */
    private static AttendanceStatisticByDayDTO fetchGroupKey(final AttendanceStatisticByDayDTO attendanceStatisticByDayDTO) {
        final AttendanceStatisticByDayDTO statisticByDay = new AttendanceStatisticByDayDTO();
        statisticByDay.setUserId(attendanceStatisticByDayDTO.getUserId());
        statisticByDay.setUserCode(attendanceStatisticByDayDTO.getUserCode());
        statisticByDay.setUserName(attendanceStatisticByDayDTO.getUserName());
        statisticByDay.setStatisticDate(attendanceStatisticByDayDTO.getStatisticDate());
        statisticByDay.setAttendanceTypeId(attendanceStatisticByDayDTO.getAttendanceTypeId());
        statisticByDay.setAttendanceTypeName(attendanceStatisticByDayDTO.getAttendanceTypeName());
        return statisticByDay;
    }

    public static void main(String[] args) {

        final List<AttendanceStatisticByDayDTO> attendanceStatisticByDayDTOS = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            final AttendanceStatisticByDayDTO attendanceStatisticByDayDTO = new AttendanceStatisticByDayDTO();
            attendanceStatisticByDayDTO.setUserId("" + (i % 5));
            attendanceStatisticByDayDTO.setUserCode("" + (i % 5));
            attendanceStatisticByDayDTO.setUserName("" + (i % 5));
            attendanceStatisticByDayDTO.setWorkDueHour((float) (i % 5));
            attendanceStatisticByDayDTO.setWorkRealHour((float) (i % 5));
            attendanceStatisticByDayDTO.setStatisticTimes(i);
            attendanceStatisticByDayDTO.setAttendanceTypeId("" + (i % 5));
            attendanceStatisticByDayDTO.setAttendanceTypeName("" + (i % 5));
            attendanceStatisticByDayDTOS.add(attendanceStatisticByDayDTO);
        }
        final Map<AttendanceStatisticByDayDTO, ComputeGroupByDTO> groupByMap =
            attendanceStatisticByDayDTOS.stream()
            .collect(Collectors.groupingBy(n -> fetchGroupKey(n)
                , Collectors.collectingAndThen(Collectors.toList(), m -> {
                    final long totalCount = m.stream().count();
                    final Double dueHourSum = m.stream()
                        .mapToDouble(AttendanceStatisticByDayDTO::getWorkDueHour).sum();
                    final Double realHourSum = m.stream()
                        .mapToDouble(AttendanceStatisticByDayDTO::getWorkDueHour).sum();
                    final ComputeGroupByDTO computeGroupBy = new ComputeGroupByDTO();
                    computeGroupBy.setTotalCount(totalCount);
                    computeGroupBy.setDueHourSum(dueHourSum);
                    computeGroupBy.setRealHourSum(realHourSum);
                    return computeGroupBy;
                })));
        System.out.println("groupByMap=" + groupByMap.size());
        groupByMap.forEach((k, v) -> {
            System.out.println(JSON.toJSONString(k));
            System.out.println(JSON.toJSONString(v));
        });
    }

}
