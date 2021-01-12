package com.abc.springdemo.crud.studentservice;

import java.util.List;

import com.abc.springdemo.crud.entity.Student;

public interface StudentService {

	public List<Student> findAll();

	public void save(Student student);

	public Student findById(int id);

	public void deleteById(int id);

}
