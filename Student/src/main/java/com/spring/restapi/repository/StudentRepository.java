package com.spring.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.restapi.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>{
	
		public Student findByName(String name);

	

}
