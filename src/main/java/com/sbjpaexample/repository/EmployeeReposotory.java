package com.sbjpaexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sbjpaexample.models.Employee;

@Repository
public interface EmployeeReposotory extends CrudRepository<Employee,Integer> {

}
