package com.example.annotation.service.impl;

import com.example.annotation.annnotation.Process;
import com.example.annotation.entity.User;
import com.example.annotation.service.TestService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * description
 *
 * @author yan.kang@hand-china.com
 * @date 2019/10/29 16:41
 */
@Service
public class TestServiceImpl implements TestService {
    @Override
    @Process(name = "kang",
            flag = true)
    public User test() {
        User user = new User();
        user.setAge(18);
        user.setName("健康");
        user.setBirth(new Date());
        return user;
    }
}
