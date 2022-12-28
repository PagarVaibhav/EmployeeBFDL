package com.mpl.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mpl.Model.Employee;
import com.mpl.ServiceI.UpdateEmployeeService;

@RestController
public class UpdateEmployeeController {

	@Autowired
	private UpdateEmployeeService updateEmployeeService;
	
	@PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@PutMapping(value="/updateData/{empid}")
	public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee emp , @PathVariable Integer empid){
		
		Employee updateEmployee = this.updateEmployeeService.updateEmployee(empid, emp);
		
		return new ResponseEntity<Employee>(updateEmployee , HttpStatus.OK);
	}
}
