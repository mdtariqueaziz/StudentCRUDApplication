package com.abc.springdemo.crud.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.springdemo.StudentExceptionHandler.StudentRecordNotFoundException;
import com.abc.springdemo.crud.entity.Student;
import com.abc.springdemo.crud.studentservice.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public List<Student> findAll() {
		List<Student> theStudent = studentService.findAll();

		return theStudent;
	}

	@GetMapping("/students/{theStudentId}")
	public Student findById(@PathVariable int theStudentId) {

		Student student = studentService.findById(theStudentId);
		System.out.println(student);

		if (student == null) {
			throw new StudentRecordNotFoundException("Record not found for the give id :" + theStudentId);
		}

		return student;
	}

	@PostMapping("/students")
	public Student save(@RequestBody Student student) {

		student.setId(0);
		studentService.save(student);

		return student;
	}

	@PutMapping("/students")
	public Student update(@RequestBody Student student) {

		studentService.save(student);
		return student;
	}

	@DeleteMapping("/students/{theStudentId}")
	public String deleteById(@PathVariable int theStudentId) {
		Student student = studentService.findById(theStudentId);

		if (student == null) {
			throw new StudentRecordNotFoundException("Record not found for the give id :" + theStudentId);
		}

		studentService.deleteById(theStudentId);

		return "The student got deleted with the studentId has :" + theStudentId;
	}

}
