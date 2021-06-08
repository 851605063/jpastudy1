package com.qfggk.jpastudy.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity(name="t_user")
public class user {
    @Id //唯一标识
    @GeneratedValue//唯一标识生成策略
    private Long id;

    @Column//标识是普通列，注解中可以指定很多属性，如长度，默认255
    private String name;
    private String passwd;
    private String email;
}
