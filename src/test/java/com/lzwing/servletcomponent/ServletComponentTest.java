package com.lzwing.servletcomponent;

import com.lzwing.base.BaseWebTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import javax.servlet.ServletContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/5/27
 * Time: 10:25
 */
@Slf4j
public class ServletComponentTest extends BaseWebTest{

    @Autowired
    private ServletContext servletContext;

    @Test
    public void checkTest() throws Exception{
        String content = getMvc().perform(get("/bbb")
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
    public void givenServletFilter_whenGetHello_thenRequestFiltered() {

        ResponseEntity<String> responseEntity =
                getRestTemplate().getForEntity("/hello", String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("filtering hello", responseEntity.getBody());
    }

    @Test
    public void givenServletContext_whenAccessAttrs_thenFoundAttrsPutInServletListner() {

        assertNotNull(servletContext);
        assertNotNull(servletContext.getAttribute("servlet-context-attr"));
        assertEquals("test", servletContext.getAttribute("servlet-context-attr"));
    }
}