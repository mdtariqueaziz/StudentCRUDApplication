package com.abc.springdemo.crud.studentdao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.springdemo.crud.entity.Student;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
