package com.lzwing.enableconfig;

import com.lzwing.base.BaseWebTest;
import com.lzwing.dao.AuthorMapper;
import com.lzwing.entity.Author;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/7/21
 * Time: 22:25
 */
@Slf4j
public class Tester extends BaseWebTest {

    @Autowired
    protected ApplicationContext ctx;

    @Test
    public void test() {
        AuthorMapper bean = ctx.getBean(AuthorMapper.class);

        Author authorBean = ctx.getBean(Author.class);

        log.info("info:{}", bean);
        log.info("authorBean:{}", authorBean);
    }
}
