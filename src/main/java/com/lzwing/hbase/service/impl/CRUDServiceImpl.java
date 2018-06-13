package com.lzwing.hbase.service.impl;

import com.lzwing.hbase.dto.User;
import com.lzwing.hbase.mapper.UserRowMapper;
import com.lzwing.hbase.service.ICRUDService;
import com.spring4all.spring.boot.starter.hbase.api.HbaseTemplate;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/13
 * Time: 11:34
 */
@Service
public class CRUDServiceImpl implements ICRUDService{

    @Autowired
    private HbaseTemplate hbaseTemplate;

    @Override
    public User findByRow(String tableName, String row) {
        return hbaseTemplate.get(tableName,row,new UserRowMapper());
    }

    @Override
    public List<User> findBySERow(String tableName, String startRow, String endRow) {

        Scan scan = new Scan(Bytes.toBytes(startRow), Bytes.toBytes(endRow));

        return hbaseTemplate.find(tableName,scan,new UserRowMapper());
    }

    @Override
    public List<Mutation> saveOrUpdate(String tableName, List<Mutation> datas) {
        hbaseTemplate.saveOrUpdates(tableName,datas);

        return datas;
    }
}
