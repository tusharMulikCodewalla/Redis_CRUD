package com.example.Redis_CRUD_HashID.Repository;

import org.springframework.data.repository.CrudRepository;

import com.example.Redis_CRUD_HashID.entity.Student;

public interface StudentRepository extends CrudRepository<Student, String>{

}
