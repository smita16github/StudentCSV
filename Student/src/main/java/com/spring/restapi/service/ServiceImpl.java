package com.spring.restapi.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.spring.restapi.entity.Student;
import com.spring.restapi.repository.StudentRepository;


@Service
public class ServiceImpl implements ServiceStudent{
private final StudentRepository repository;
    
	public ServiceImpl (StudentRepository repository)
	{
		this.repository=repository;
	}


	@Override
	public List<Student> getAllStudent() {
		List<Student> findAll=repository.findAll();
		return findAll;
	
	}

	@Override
	public void saveStudent(Student stud) {
		repository.save(stud);
		
	}

	@Override
	public void deleteStudent(Integer studId) {
		repository.deleteById(studId);
		
	}

	@Override
	public void generateCSV(HttpServletResponse response) {
		List<Student> allStudent = getAllStudent();
		String filename = "Student.csv";
		response.setContentType("text/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");
		StatefulBeanToCsv<Student> writer;
		try {
			writer = new StatefulBeanToCsvBuilder<Student>(response.getWriter())
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
					.withOrderedResults(true).build();
			writer.write(allStudent);
		} catch (Exception e) {
			e.printStackTrace();
		
	
		
	
		
	}


	}
}
