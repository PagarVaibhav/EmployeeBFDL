package com.mpl.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mpl.ServiceI.DeleteEmployeeService;

@RestController
public class DeleteEmployeeController {

	@Autowired
	private DeleteEmployeeService deleteEmployeeService;
	

	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	@DeleteMapping(value="/deleteData/{empid}")
	public ResponseEntity<String> deleteEmployee(@PathVariable Integer empid){
		this.deleteEmployeeService.deleteEmployee(empid);
		return new ResponseEntity<String>("Record Deleted Successfully" , HttpStatus.OK);
	}

}
