package com.mpl.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mpl.Model.Employee;
import com.mpl.ServiceI.ServiceImpl;

@RestController
public class Controller {

	@Autowired
	private ServiceImpl serviceImpl;
	
//	@Autowired
//	private JwtGeneratorInterface jwtGeneratorInterface;
//	
	@PostMapping(value="/saveMulti")
	public ResponseEntity<String> createMultiEmployees(@Valid @RequestBody List<Employee> employees){
		List<Employee> saveMultipleEmployees = this.serviceImpl.saveMultipleEmployees(employees);
		
		return new ResponseEntity<String>("Mutiple Data Added Succesfully" , HttpStatus.CREATED);
	}
	
	
	@GetMapping(value="/getAll")
	public ResponseEntity<List<Employee>> retriveAllEmployees(){
		List<Employee> retrivedEmployees = this.serviceImpl.getAllEmployees();
		return new ResponseEntity<List<Employee>>(retrivedEmployees , HttpStatus.OK);
	}
	
	@PutMapping(value="/updateMulti")
	public ResponseEntity<List<Employee>> updateMuliEmployees(@Valid @RequestBody List<Employee> employees){
		List<Employee> updateMultiEmployees = this.serviceImpl.updateMultiEmployees(employees);
		return new ResponseEntity<List<Employee>>(updateMultiEmployees , HttpStatus.OK);
	}
	
	@GetMapping(value="/login/{empname}/{emppass}")
	public ResponseEntity<String> loginFunctionality(@PathVariable String empname , @PathVariable String emppass){
		Employee loginChecks = this.serviceImpl.loginCheck(empname, emppass);
		
		if(loginChecks!= null) {
			String msg="Login Successfully";
			return new ResponseEntity<String>(msg , HttpStatus.OK);
		}
		String msg1="Login Failed";
		return new ResponseEntity<String>(msg1 , HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value="/deleteAll")
	public ResponseEntity<String> deleteAllEmployees(){
		this.serviceImpl.deleteAllData();
		return new ResponseEntity<String>("All Data Deleted Successfully" , HttpStatus.OK);
	}
}
