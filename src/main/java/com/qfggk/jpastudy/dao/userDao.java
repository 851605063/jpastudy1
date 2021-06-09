package com.qfggk.jpastudy.dao;

import com.qfggk.jpastudy.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface userDao extends JpaRepository<User,Long> {


    @Query(value = "select t from  com.qfggk.jpastudy.pojo.User t order by id desc")
     List<User> selAllUsers();

    /**
     * 注意：这样查询封装成的是一个Object对象数组，泛型要写Object[]
     *
     */
    @Query(value = "select id,name,passwd from  com.qfggk.jpastudy.pojo.User t order by id desc")
    List<Object[]> selAllUsers2();

    /**
     *
     * 这样就封装到了实体类中
     */
    @Query(value = "select new com.qfggk.jpastudy.pojo.User(id,name,passwd) from  com.qfggk.jpastudy.pojo.User t order by id desc")
    List<User> selAllUsers3();
}
