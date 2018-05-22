package com.lzwing.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

import java.io.IOException;

public class ConnectonHelper {

    public static MemcachedClient getClient(){
        // 连接配置
        MemcachedClientBuilder memcachedClientBuilder =
                new XMemcachedClientBuilder(AddrUtil.getAddresses("10.1.11.109:2222"));
        // 创建与服务端之间的连接[ip地址，端口号，用户名和密码]
        // 获取操作业务对象
        MemcachedClient memcachedClient = null;
        try {
            memcachedClient = memcachedClientBuilder.build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return memcachedClient;
    }

}
