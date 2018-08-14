package com.lzwing.customconfig;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @create 2018/8/13
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "user.custom")
public class UserProperty {

    private String username;

    private String nickname;

    private String email;

    private String password;

    private String job;
}