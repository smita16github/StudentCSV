package com.spring.restapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restapi.entity.Student;
import com.spring.restapi.service.ServiceImpl;
import com.spring.restapi.service.ServiceStudent;

@RestController
@RequestMapping("/students")
public class StudentController {
	private final ServiceStudent service;
    @Autowired
	public StudentController(ServiceImpl service) {
		this.service = service;
	}

	@GetMapping("/get")
	public List<Student> getAllStudent() {
		return service.getAllStudent();
	}

	@PostMapping("/save")
	public String saveStudent(@RequestBody Student stud) {
		service.saveStudent(stud);
		return "Student with ID " + stud.getId() + " is saved successfully";
	}

	@DeleteMapping("/delete")
	public String deleteStudent(@RequestParam(value = "studId") Integer id) {
		service.deleteStudent(id);
		return "Deleted Student associated with ID " + id;
	}

	@GetMapping("/DownloadCSV")
	public void generateCSVForAllStudent(HttpServletResponse response) {
		service.generateCSV(response);
	}




}
