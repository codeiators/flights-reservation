package com.ashu.student.dal;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ashu.student.dal.entities.Student;
import com.ashu.student.dal.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {
	
	@Autowired
	StudentRepository studentRepository;

	@Test
	public void testCreateStudent()
	{
		Student student1=new Student();
		student1.setName("John");
		student1.setCourse("Java Rest web services");
		student1.setFee(30d);
		studentRepository.save(student1);
		
	}
	
	@Test
	public void testFindStudentById()
	{
		Optional<Student> student=studentRepository.findById(1L);
		System.out.println(student.get().getName());
		
		
	}
	
	@Test
	public void testUpdateStudent()
		{
		Student student1=studentRepository.findById(1L).get();
		
		student1.setFee(50d);
		studentRepository.save(student1);
		
		
		
	}
	
	@Test
	public void testDeleteStudent()
		{
		studentRepository.deleteById(1L);
		
		
		
		
		
	}

}

