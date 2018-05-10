package com.lzwing.mockTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/4/18
 * Time: 19:27
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MockTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void testEchart() throws Exception {
        String content = this.mvc.perform(get("/bbb")
                .accept(MediaType.TEXT_HTML))
                /*.andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(754))
                .andExpect(jsonPath("$.rows", Matchers.hasSize(5)))
                .andExpect(jsonPath("$.rows[0].desc",Matchers.notNullValue()))*/
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        log.info("content:{}",content);
    }
}
