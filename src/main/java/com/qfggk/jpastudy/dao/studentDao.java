package com.qfggk.jpastudy.dao;

import com.qfggk.jpastudy.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface studentDao  extends JpaRepository<Student,Long> {
}
