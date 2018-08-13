package com.lzwing.controller;

import com.lzwing.applicationevent.DemoPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Slf4j
public class HelloController {

    @Autowired
    DemoPublisher demoPublisher;

    @GetMapping("/test")
    @ResponseBody
    public String test() {

        demoPublisher.publish("访问test5......");

        return "test5";
    }

    @GetMapping("/bbb")
    public String demo(HttpServletRequest request) {
        ServletWebRequest servletWebRequest = new ServletWebRequest(request);
        try {
            String name = ServletRequestUtils.getRequiredStringParameter(servletWebRequest.getRequest(), "name");
            log.info("name:{}",name);
        } catch (ServletRequestBindingException e) {
            new RuntimeException(e);
        }
        return "hello";
    }

    @RequestMapping(value = "/hello/{name}/{age}/{gender}", method = RequestMethod.GET)
    public String hello(HttpServletRequest request,Model model) {
        Map<String, String> pathVariables = resolvePathVariables(request);
        log.info("pathVariables:"+pathVariables);
        model.addAttribute("name", "spbt");
        return "hello";
    }

    private Map<String, String> resolvePathVariables(HttpServletRequest request) {
        return (Map<String, String>) request
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    }

}