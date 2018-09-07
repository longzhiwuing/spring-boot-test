package com.lzwing.dbpass;

import com.lzwing.base.BaseWebTest;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/9/7
 * Time: 11:27
 */
public class TestDBEncryptor extends BaseWebTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String result = stringEncryptor.encrypt("mysdc");
        System.out.println(result);
    }
}
