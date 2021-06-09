package com.qfggk.jpastudy.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity(name="t_clazz")   //主键表（多个学生对应一个cid）
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long cid;

    @Column(length = 128)
    private String cname;

    //该属性为一对多
    @OneToMany(mappedBy = "clazz",fetch = FetchType.EAGER)  //对象关系的映射，不应写cid；mappedBy创建一对多的映射关系,值为对方关联列属性名称
    private List<Student> students;


    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                '}';
    }
}
