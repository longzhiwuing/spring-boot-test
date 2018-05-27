package com.lzwing.email;

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
 * Time: 12:07
 */
@Slf4j
public class EmailControllerTest extends BaseWebTest{

    @Test
    public void sendEmail() throws Exception{
        String content = getMvc().perform(get("/registerEmail?email=chenzhongyong@cecdat.com")
                .accept(MediaType.TEXT_HTML))
                /*.andExpect(status().isOk())
                .andExpect(jsonPath("$.total").value(754))
                .andExpect(jsonPath("$.rows", Matchers.hasSize(5)))
                .andExpect(jsonPath("$.rows[0].desc",Matchers.notNullValue()))*/
                .andDo(MockMvcResultHandlers.print())
                .andReturn().getResponse().getContentAsString();

        log.info("content:{}",content);
    }

    @Test
    public void activateMail() {
    }
}