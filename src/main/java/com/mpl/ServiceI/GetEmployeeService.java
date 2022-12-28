package com.mpl.ServiceI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpl.Exceptions.ResourceNotFoundException;
import com.mpl.Model.Employee;
import com.mpl.Repository.EmpRepo;
@Service
public class GetEmployeeService {

	@Autowired
	private EmpRepo empRepo;
	
	 public Employee getEmployee(Integer empid) {
	    	
	    	Employee getById = this.empRepo.findById(empid)
	    			.orElseThrow(()-> new ResourceNotFoundException("Employee","Id",empid));
	    	
	    	return getById;
	    }
}
