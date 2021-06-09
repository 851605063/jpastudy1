package com.qfggk.jpastudy;

import com.qfggk.jpastudy.dao.clazzDao;
import com.qfggk.jpastudy.dao.studentDao;
import com.qfggk.jpastudy.pojo.Clazz;
import com.qfggk.jpastudy.pojo.Student;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class Test2 {

    @Autowired
    clazzDao clazzDao;

    @Autowired
    studentDao studentDao;
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void tset(int i)
    {
        Clazz clazz = new Clazz();
        clazz.setCname("测控15"+i);
        clazzDao.save(clazz);

    }

    @Test
    void test1()
    {
        Clazz clazz = new Clazz();
        clazz.setCid(1L);
        Student student = new Student();
        student.setSname("王家琪2");
        student.setClazz(clazz);
        studentDao.save(student);

    }
    @Test
    void test2()
    {
        List<Clazz> all = clazzDao.findAll();
        //OneToMany默认使用懒加载，当没有用到student的信息时不会去查，用到才会去查询
        //ManyToOne默认使用立即加载
        for(Clazz clz:all) {
            System.out.println("cid:" + clz.getCid() + ",cname:" + clz.getCname());
            /**
             * no session 异常
             * 原因：当查询完班级信息后会话已被关闭
             * 解决：设置立即加载EAGER或者延迟session生命周期,建议懒加载，立即加载可能会使性能降低，
             *
             * https://blog.csdn.net/zhouzhiwengang/article/details/108407426  -->>StackOverflowError的解释，调用磨人的tostring会报错
             */
            List<Student> students = clz.getStudents();
            for(Student s:students)
            {
                System.out.println(s);
            }
        }
    }
}
