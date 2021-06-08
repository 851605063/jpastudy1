package com.qfggk.jpastudy;

import com.qfggk.jpastudy.dao.userdao;
import com.qfggk.jpastudy.pojo.user;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpastudyApplicationTests {


    @Autowired
    userdao userdao;
    @Test
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void contextLoads(int arg) {

        user user = new user();
        user.setName("wjq"+arg);
        user.setEmail("851605063@qq.com");
        user.setPasswd("123");
        userdao.save(user);

    }

}
