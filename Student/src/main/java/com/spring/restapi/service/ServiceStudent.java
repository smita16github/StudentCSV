package com.spring.restapi.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.spring.restapi.entity.Student;

public interface ServiceStudent {
	public List<Student> getAllStudent();
    public void saveStudent(Student stud);
    public void deleteStudent(Integer studId);
    void generateCSV(HttpServletResponse response);


}
