package com.qfggk.jpastudy;

import com.qfggk.jpastudy.dao.userdao;
import com.qfggk.jpastudy.pojo.user;
import javassist.runtime.Desc;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@SpringBootTest
class JpastudyApplicationTests {


    @Autowired
    userdao userdao;
    @Test
//    @ParameterizedTest
//    @ValueSource(ints = { 1, 2, 3 })
    void contextLoads() {

        user user = new user();
        user.setName("wjq"+1);
        user.setEmail("851605063@qq.com");
        user.setPasswd("1231111111");
        user.setId(1L);
        userdao.save(user);


    }

    @Test
    void findtest()
    {
        try {
            //通过ID查询
            Optional<user> op = userdao.findById(11111L);
            user user = op.get();
            System.out.println(user);
            System.out.println("-------------------------------");
        }
        catch(NoSuchElementException e)
        {
            System.out.println("未查询到记录");
        }
        //倒叙查询，静态类不用创建外部类的对象就可以直接创建static class的对象，
        // static class可以引用外部类的static变量与static的方法，非静态不能引用
        Sort sort  = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        List<com.qfggk.jpastudy.pojo.user> all = userdao.findAll(sort);
        for(user u:all)
        {
            System.out.println(u);
        }
    }
    @Test
    void localClassTest()
    {
        int i=1;
        class aa{
            public void getI()
            {
                System.out.println("i: "+i);
            }
        }
        aa a = new aa();
        a.getI();
    }


    @Test
    void findAllWithPage()
    {
        //PageRequest是Pageable接口的实现类，构造器protect被保护，使用of方法创建
        PageRequest pg = PageRequest.of(0, 2);
        Page<user> userpg = userdao.findAll(pg);
        for(user user : userpg)
        {
            System.out.println(user);

        }


    }
}
