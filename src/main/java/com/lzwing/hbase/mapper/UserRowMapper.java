package com.lzwing.hbase.mapper;

import com.lzwing.hbase.dto.User;
import com.spring4all.spring.boot.starter.hbase.api.RowMapper;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/13
 * Time: 11:00
 */
public class UserRowMapper implements RowMapper<User>{

    private static byte[] FAMILY_B = "b".getBytes();
    private static byte[] NAME = "name".getBytes();
    private static byte[] AGE = "age".getBytes();
    private static byte[] SEX = "sex".getBytes();

    private static byte[] FAMILY_O = "o".getBytes();
    private static byte[] PHONE = "phone".getBytes();
    private static byte[] ADDRESS = "address".getBytes();

    @Override
    public User mapRow(Result result, int i) throws Exception {
        User.BaseInfo baseInfo = new User.BaseInfo(
                Bytes.toString(result.getValue(FAMILY_B,NAME)),
                Bytes.toInt(result.getValue(FAMILY_B,AGE)),
                Bytes.toString(result.getValue(FAMILY_B,SEX))
        );

        User.OtherInfo otherInfo = new User.OtherInfo(
                Bytes.toString(result.getValue(FAMILY_O,PHONE)),
                Bytes.toString(result.getValue(FAMILY_O,ADDRESS))
        );

        return new User(Bytes.toString(result.getRow()),baseInfo,otherInfo);
    }
}
