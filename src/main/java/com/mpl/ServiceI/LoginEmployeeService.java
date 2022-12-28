package com.mpl.ServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpl.Model.Employee;
import com.mpl.Repository.EmpRepo;

@Service
public class LoginEmployeeService {

	@Autowired
	private EmpRepo empRepo;
	
	public Employee loginEmployee(Employee employee) {
		Employee saveEmp = this.empRepo.save(employee);
		return saveEmp;
	}
}
