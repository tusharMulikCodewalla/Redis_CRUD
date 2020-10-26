package com.example.Redis_CRUD_HashID.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSessionAttributeListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Redis_CRUD_HashID.Repository.StudentRepository;
import com.example.Redis_CRUD_HashID.entity.Student;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@DeleteMapping("/deleteStudent/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") String id){
		studentRepository.deleteById(id);
		return new ResponseEntity<>("Student With Id "+id+" Is Deleted.",HttpStatus.OK);
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable (name = "id") String id, @RequestBody Student student){
		Optional<Student> std = studentRepository.findById(id);
		if(std.isPresent()) {
			Student studentDB = std.get(); 
			studentDB.setGrade(student.getGrade());
			studentDB.setName(student.getName());
			Student updatedStudent = studentRepository.save(studentDB);
			return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
		}
		
		return null;
	}
	
	@PostMapping("/insertStudent")
	public ResponseEntity<Student> insertStudent(@RequestBody Student student){
		
		System.out.println(student);
		Student savedStudent = studentRepository.save(student);
		
		return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students = new ArrayList<>();
		studentRepository.findAll().forEach(students :: add);
		return new ResponseEntity<>(students,HttpStatus.OK);
	}

}
