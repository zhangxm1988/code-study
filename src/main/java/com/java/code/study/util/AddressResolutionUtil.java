package com.java.code.study.util;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhxiaoming1988@163.com
 * @description
 * @date 2021/8/4 15:16
 */
public class AddressResolutionUtil {

    /**
     * 解析地址
     *
     * @author lin
     * @param address
     * @return
     */
    public static List<Map<String,String>> addressResolution(String address) {
        String regex = "(?<province>[^省]+自治区|.*?省|.*?行政区|.*?市)(?<city>[^市]+自治州|.*?地区|.*?行政单位|.+盟|市辖区|.*?市|.*?县)(?<county>[^县]+县|.+区|.+市|.+旗|.+海域|.+岛)?(?<town>[^区]+区|.+镇)?(?<village>.*)";
        Matcher m = Pattern.compile(regex).matcher(address);
        String province, city, county, town, village;
        List<Map<String,String>> table = new ArrayList<Map<String,String>>();
        Map<String,String> row;
        while (m.find()) {
            row = new LinkedHashMap<String,String>();
            province = m.group("province");
            row.put("province", province == null ? "": province.trim());
            city = m.group("city");
            row.put("city", city == null ? "": city.trim());

            county = m.group("county");
            row.put("county", county == null ? "" : county.trim());
            town = m.group("town");
            row.put("town", town == null ? "": town.trim());
            village = m.group("village");
            row.put("village", village == null ? "" : village.trim());

            table.add(row);
        }

        return table;
    }

    public static void main(String[] args) {
        System.out.println(addressResolution("湖北省武汉市洪山区"));
        System.out.println(addressResolution("湖北省恩施土家族苗族自治州恩施市"));
        System.out.println(addressResolution("北京市市辖区朝阳区"));
        System.out.println(addressResolution("内蒙古自治区兴安盟科尔沁右翼前旗"));
        System.out.println(addressResolution("西藏自治区日喀则地区日喀则市"));
        System.out.println(addressResolution("海南省省直辖县级行政单位中沙群岛的岛礁及其海域"));
    }
}
