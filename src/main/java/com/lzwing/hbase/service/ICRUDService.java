package com.lzwing.hbase.service;

import com.lzwing.hbase.dto.User;
import org.apache.hadoop.hbase.client.Mutation;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/13
 * Time: 11:30
 */
public interface ICRUDService {

    User findByRow(String tableName, String row);

    List<User> findBySERow(String tableName, String startRow, String endRow);

    List<Mutation> saveOrUpdate(String tableName, List<Mutation> datas);
}
