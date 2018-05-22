package com.lzwing.memcached;

import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/22
 * Time: 15:13
 */
@Configuration
public class XMemcachedConfig {

    @Bean
    public MemcachedClientBuilder getXMBuilder() {
        MemcachedClientBuilder memcachedClientBuilder = null;
        try {
            String servers = "10.1.11.109:2222";
            memcachedClientBuilder = new XMemcachedClientBuilder(servers);
            memcachedClientBuilder.setFailureMode(false);

            //诸多Memcached配置
            return memcachedClientBuilder;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
