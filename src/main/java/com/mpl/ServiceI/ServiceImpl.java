package com.mpl.ServiceI;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpl.Exceptions.ResourceNotFoundException;
import com.mpl.Model.Employee;
import com.mpl.Repository.EmpRepo;

@Service
public class ServiceImpl {

	@Autowired
	private EmpRepo empRepo;
	
	public List<Employee> saveMultipleEmployees(List<Employee> employees){
		List<Employee> saveAll = this.empRepo.saveAll(employees);
		return saveAll;
	}
    
    public List<Employee> getAllEmployees(){
    	List<Employee> getAllEmp = this.empRepo.findAll();
    	return getAllEmp;
    }
    
    public List<Employee> updateMultiEmployees(List<Employee> employees){
    	List<Employee> updatedMultiEmp = this.empRepo.saveAll(employees);
    	return updatedMultiEmp;
    }
    
    public Employee loginCheck(String empname ,String emppass) {
    	Employee loginCheck = this.empRepo.findByEmpnameAndEmppass(empname, emppass);
    	return loginCheck;
    }
    
    public void deleteAllData() {
    	this.empRepo.deleteAll();
    }
}
