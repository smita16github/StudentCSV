package com.spring.restapi.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.restapi.entity.Student;
import com.spring.restapi.repository.StudentRepository;

@Component
public class Runner implements CommandLineRunner{
	private final StudentRepository repo;
	 
	   public Runner (StudentRepository repo)
	   {
		   this.repo=repo;
	   }
	
	@Override
	public void run(String... args) throws Exception {
	
		List<Student> stud=new ArrayList<Student>();	
		stud.add(new Student("Sonali","Pune"));
		stud.add(new Student("Sonal","Hyderabad"));
		stud.add(new Student("Shree","Purna"));
		stud.add(new Student("Somesh","Nanded"));
		stud.add(new Student("Santosh","Nagpur"));
		stud.add(new Student("Saiee","Nanded"));
		stud.add(new Student("Samarth","Pune"));
		repo.saveAll(stud);
		System.out.println("List of Student"+repo);
		}

	}


