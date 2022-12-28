package com.mpl.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mpl.Model.Employee;
import com.mpl.ServiceI.CreateEmployeeService;

@RestController
public class CreateEmployeeController {

	@Autowired
     CreateEmployeeService createEmployeeService;
	
	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@PostMapping(value= "/saveData")
	 ResponseEntity<String> createEmployee(@Valid @RequestBody Employee emp) throws Exception{
		
			Employee saveEmployee = this.createEmployeeService.saveEmployee(emp);
		
		if(saveEmployee!=null) {
		String s1="Employee data saved successfully & Your Id Is = " + saveEmployee.getEmpid();
		return new ResponseEntity<>(s1 , HttpStatus.CREATED);
		}
		String s2="Please Provide Valid Information" ;
		return new ResponseEntity<String>(s2 , HttpStatus.BAD_REQUEST);
	
	}
}
