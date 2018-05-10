package com.lzwing;

import com.lzwing.dao.RedisDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootTestApplicationTests {

	@Autowired
	RedisDao redisDao;

	@Test
	public void test() throws Exception {

		redisDao.setKey("abc","123");
		String abc = redisDao.getValue("abc");
		log.info("abc:{}",abc);
	}

}
