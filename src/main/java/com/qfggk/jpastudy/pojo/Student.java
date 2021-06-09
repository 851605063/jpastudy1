package com.qfggk.jpastudy.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * t_student
 *  sid sname cid(外键列)
 *   创建表时会执行：alter table t_student add constraint FKdoqw5tbx714ymdae2apufdo1k foreign key (cid) references t_clazz (cid)
 */
@Data
@Entity(name="t_student") //外检表、子表
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long sid;

    @Column(length = 128)
    private String sname;

    @ManyToOne  //该属性为多对一，多个学生对应一个班级
    @JoinColumn(name="cid") //制定关联列
    private Clazz clazz;




}
