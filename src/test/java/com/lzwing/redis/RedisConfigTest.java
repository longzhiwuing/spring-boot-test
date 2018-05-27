package com.lzwing.redis;

import com.lzwing.base.BaseWebTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/27
 * Time: 11:37
 */
@Slf4j
public class RedisConfigTest extends BaseWebTest{

    @Autowired
    @Qualifier("jsonRedisTemp")
    private RedisTemplate template;

    @Autowired
    JedisPool jedisPool;

    @Test
    public void testRedis() {
        template.opsForValue().set("test","test");
    }

    @Test
    public void contextLoads() {
        String uuid = UUID.randomUUID().toString();
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.setex(uuid, 1000, uuid);
        }
    }
}