package com.abc.springdemo.crud.studentservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.springdemo.StudentExceptionHandler.StudentRecordNotFoundException;
import com.abc.springdemo.crud.entity.Student;
import com.abc.springdemo.crud.studentdao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public void save(Student student) {
		studentDao.save(student);
	}

	@Override
	public Student findById(int id) {
		Optional<Student> result = studentDao.findById(id);

		// If the record is not available throw Exception
		if (result.isEmpty()) {
			throw new StudentRecordNotFoundException("Record Doesn't exists for id :" + id);
		} else {
			// Record exists so get the object and return the object
			Student student = result.get();
			return student;
		}
	}

	@Override
	public void deleteById(int id) {

		Optional<Student> result = studentDao.findById(id);

		// If the record is not available throw Exception
		if (result.isEmpty()) {
			throw new StudentRecordNotFoundException("Record Doesn't exists for id :" + id);
		} else {
			studentDao.deleteById(id);
		}
	}

}
