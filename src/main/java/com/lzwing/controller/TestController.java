package com.lzwing.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.lzwing.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong
 * Date: 2018/8/28
 * Time: 17:05
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/simpleUser")
    @JsonView(User.UserSimpleView.class)
    public User getSimpleUser() {
        User user = new User();
        user.setUsername("simple");
        user.setPassword("simple");
        return user;
    }

    @GetMapping("/detailUser")
    @JsonView(User.UserDetailView.class)
    public User getDetailUser() {
        User user = new User();
        user.setUsername("detail");
        user.setPassword("detail");
        return user;
    }

    @GetMapping("/normalUser")
    @JsonView(User.UserDetailView.class)
    public User getNormalUser() {
        User user = new User();
        user.setUsername("normal");
        user.setPassword("normal");
        return user;
    }

}
