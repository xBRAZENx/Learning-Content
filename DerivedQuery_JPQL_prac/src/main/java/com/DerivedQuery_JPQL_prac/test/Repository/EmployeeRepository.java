package com.DerivedQuery_JPQL_prac.test.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.DerivedQuery_JPQL_prac.test.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByNameStartingWithIgnoreCase(String prefix);
	
	@Query("SELECT e.name FROM Employee e JOIN Employee d ON e.id = d.id WHERE e.name LIKE ?1 || '%'")
	  List<Object[]> findByNameStartingWithJoin(String prefix);
}
