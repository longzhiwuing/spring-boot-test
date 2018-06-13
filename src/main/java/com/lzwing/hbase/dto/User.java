package com.lzwing.hbase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/13
 * Time: 10:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String row;
    private BaseInfo baseInfo;
    private OtherInfo otherInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BaseInfo{
        private String name;
        private Integer age;
        private String sex;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OtherInfo{
        private String phone;
        private String address;

    }

}
