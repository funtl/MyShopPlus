package com.funtl.myshop.plus.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BusinessOAuth2Tests {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Test
    public void testPasswordEncoder() {
        System.out.println(passwordEncoder.encode("secret"));
    }

}
