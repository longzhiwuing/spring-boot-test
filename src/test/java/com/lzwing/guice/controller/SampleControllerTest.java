package com.lzwing.guice.controller;

import com.lzwing.base.BaseWebTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/27
 * Time: 11:19
 */
@Slf4j
public class SampleControllerTest extends BaseWebTest{

    @Test
    public void greeting() throws Exception{
        String content = getMvc().perform(get("/greeting?name=abc")
                .accept(MediaType.TEXT_HTML))
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        log.info("content:{}",content);
    }
}