package com.mpl.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpl.Model.Employee;
import com.mpl.ServiceI.GetEmployeeService;

@RestController
public class GetEmployeeController {

	@Autowired
	private GetEmployeeService getEmployeeService;
	
	 @PreAuthorize("hasAnyRole('ADMIN','MANAGER')")
	@GetMapping(value="/getData/{empid}")
	 ResponseEntity<String> retriveEmployee(@PathVariable Integer empid){
		Employee retrivedEmployee = this.getEmployeeService.getEmployee(empid);
		if(retrivedEmployee==null) {
			String s1="Please provide valid details";
			return new ResponseEntity<String>(s1 ,HttpStatus.BAD_REQUEST);
		}
		
		String s2="Employee Data Retriwed Successfully !!";
		return new ResponseEntity<String>(s2,HttpStatus.OK);
	}
	
}
