package com.lzwing.email;

import com.lzwing.email.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/14
 * Time: 16:43
 */
@Controller
@Slf4j
public class EmailController {

    @Autowired
    EmailService emailService;


    @RequestMapping(value = "registerEmail")
    @ResponseBody
    public String sendEmail(@RequestParam String email) throws Exception{
        User user = new User();
        user.setName("chenzhongyong");
        user.setEmail("chenzhongyong@cecdat.com");
        new Thread(){
            @Override
            public void run(){
                try {
                    emailService.senEmail(user,email);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return "邮件已发送至您的邮箱，请激活";
    }

    @RequestMapping(value = "activateMail")
    @ResponseBody
    public String activateMail(@RequestParam String emailToken){
        log.info(String.format("emailToken:%s", emailToken));
        if (emailService.balanceToken(emailToken)){
            return "success";
        }
        return "error1";
    }
}
