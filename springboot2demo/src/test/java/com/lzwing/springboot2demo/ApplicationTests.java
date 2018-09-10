package com.lzwing.springboot2demo;

import com.lzwing.springboot2demo.entity.Order;
import com.lzwing.springboot2demo.provider.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	OrderSender orderSender;

	@Test
	public void contextLoads() {
		Order order = new Order();
		order.setId("20180818001");
		order.setName("测试订单1");
		order.setMessageId(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString());

		orderSender.sendOrder(order);

	}



}
