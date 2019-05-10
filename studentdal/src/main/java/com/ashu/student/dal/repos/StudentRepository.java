package com.ashu.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.ashu.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
