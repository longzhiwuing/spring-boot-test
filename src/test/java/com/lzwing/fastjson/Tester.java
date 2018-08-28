package com.lzwing.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.lzwing.base.BaseWebTest;
import com.lzwing.entity.Author;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/8/28
 * Time: 16:40
 */
@Slf4j
public class Tester extends BaseWebTest{

    @Test
    public void testJSONField() {
        Author author = new Author();

        author.setId(1L);
        author.setNickName("nickName");
        author.setRealName("realName");

        log.info("author:{}", author);

        //转json 属性标识@JSONField进行修改
        String jsonStr = JSON.toJSONString(author);

        log.info("json:{}", jsonStr);

        //反序列化
        Author author1 = JSONObject.parseObject(jsonStr,new TypeReference<Author>() {});

        log.info("author1:{}", author1);
    }

}
