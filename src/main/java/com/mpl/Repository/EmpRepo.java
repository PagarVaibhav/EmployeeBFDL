package com.mpl.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpl.Model.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {
	
	public Employee findByEmpnameAndEmppass(String empname , String emppass);
}
