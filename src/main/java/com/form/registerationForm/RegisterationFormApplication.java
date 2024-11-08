package com.form.registerationForm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.form.registerationForm.entity.StudentEntity;
import com.form.registerationForm.repository.Repo;

@SpringBootApplication
public class RegisterationFormApplication implements CommandLineRunner{
	@Autowired
	Repo repository;
	public static void main(String[] args) {
		SpringApplication.run(RegisterationFormApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		ExampleMatcher match = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues();
		
		StudentEntity student = new StudentEntity();
		student.setName("ASHISH");

		Example<StudentEntity> ex = Example.of(student,match);
		 List<StudentEntity> list= repository.findAll(ex);

		 list.forEach(System.out::println);
		
	}

}
