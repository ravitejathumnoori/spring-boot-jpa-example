package com.sbjpaexample;

import java.sql.SQLException;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sbjpaexample.models.Employee;
import com.sbjpaexample.repository.EmployeeReposotory;

@SpringBootApplication
@EnableTransactionManagement//this annotation will enable @Transaction annotation related configurations
public class SpringBootJpaExampleApplication {
	
//	@PersistenceUnit
//	private EntityManagerFactory emf;
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
	@Autowired
	EmployeeReposotory employeeReposotory;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaExampleApplication.class, args);
	}
	
	@PostConstruct
	public void start() {
		
		Employee e = new Employee();
		e.setAge(20);
		e.setName("Foo Bar");
		e.setSsn("1234");
		e.setDob(new Date());
		//EntityManager entityManager = emf.createEntityManager();
		//EntityTransaction transaction = entityManager.getTransaction();
		employeeReposotory.save(e);
		
	}
	
	@Transactional(rollbackOn = SQLException.class) 
	//Use Transactional annotation to replace transaction.begin() and transaction.commit() methods
	public void updateEmployee(Employee employee) {
		
		employee.setName("Updated Name");
		employeeReposotory.save(employee);
		
	}

}
