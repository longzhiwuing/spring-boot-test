package com.lzwing.hbase.service.impl;

import com.lzwing.base.BaseWebTest;
import com.lzwing.hbase.service.ICRUDService;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/6/13
 * Time: 11:43
 */
public class CRUDServiceImplTest extends BaseWebTest{

    @Autowired
    private ICRUDService service;

    private String tableName = "demo:user";

    @Test
    public void testSaveOrUpdate() {
        List<Mutation> datas = new ArrayList<>();

        Put put = new Put(Bytes.toBytes("root"));

        put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("name"), Bytes.toBytes("qinyi"));
        put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("age"), Bytes.toBytes("25"));
        put.addColumn(Bytes.toBytes("b"), Bytes.toBytes("sex"), Bytes.toBytes("m"));
        put.addColumn(Bytes.toBytes("o"), Bytes.toBytes("phone"), Bytes.toBytes("12345678"));
        put.addColumn(Bytes.toBytes("o"), Bytes.toBytes("address"), Bytes.toBytes("beijing"));

        /*Delete delete = new Delete(Bytes.toBytes("root"));

        datas.add(delete);*/

        datas.add(put);

        List<Mutation> results = service.saveOrUpdate(tableName, datas);
        System.out.println(results);
    }

    @Test
    public void testFindByRow() {
        System.out.println(service.findByRow(tableName, "root"));
    }

    @Test
    public void testFindBySERow() {
        System.out.println(service.findBySERow(tableName, "r", "z"));

    }
}