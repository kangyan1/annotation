package com.example.annotation.controller;

import com.example.annotation.entity.User;
import com.example.annotation.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author yan.kang@hand-china.com
 * @date 2019/10/29 16:39
 */
@RestController
public class TestController {
    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/test")
    public String  test(){
        User user = testService.test();
        return user.toString();
    }
}
