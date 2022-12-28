package com.mpl.ServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpl.Exceptions.ResourceNotFoundException;
import com.mpl.Model.Employee;
import com.mpl.Repository.EmpRepo;
@Service
public class UpdateEmployeeService {

	@Autowired
	private EmpRepo empRepo;
	
	  public Employee updateEmployee(Integer empid ,Employee emp) {
	    	this.empRepo.findById(empid).orElseThrow(()-> new ResourceNotFoundException("Employee", "ID", empid));
	    	emp.setEmpid(empid);
	    	return empRepo.save(emp);
	    }
}
