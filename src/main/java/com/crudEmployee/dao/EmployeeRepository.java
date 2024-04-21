package com.crudEmployee.dao;

import com.crudEmployee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// orm
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!





    public List<Employee> findAllByOrderByLastNameDesc();



}
