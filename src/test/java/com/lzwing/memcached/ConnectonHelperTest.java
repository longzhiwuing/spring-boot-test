package com.lzwing.memcached;

import lombok.extern.slf4j.Slf4j;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/22
 * Time: 15:00
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConnectonHelperTest {

    @Autowired
    MemcachedClientBuilder memcachedClientBuilder;

    // 演示集群操作
    @Test
    public void cluTest() throws  Exception{

        //MemcachedClient memcachedClient = ConnectonHelper.getClient();
        MemcachedClient memcachedClient = memcachedClientBuilder.build();

        String k1Value = memcachedClient.get("k1");
        System.out.println("k1Value="+k1Value);

        memcachedClient.set("v1",0,"Hello Jiangzh!!!");
        String V1Value = memcachedClient.get("V1");
        System.out.println("V1Value="+V1Value);


    }

    @Test
    public void test() throws Exception {

        // 连接配置
        // 创建与服务端之间的连接[ip地址，端口号，用户名和密码]
        // 获取操作业务对象
        MemcachedClient memcachedClient =
                new XMemcachedClient("10.1.11.109",2222);

        // 操作业务
        String str = "Hello Imooc!";
        boolean isSuccess = memcachedClient.set("k1", 3600, str);

        String value = memcachedClient.get("k1");

        System.out.println("value="+value);

        // 关闭与服务端连接
        memcachedClient.shutdown();

    }

}