package com.mpl.ServiceI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mpl.Model.Address;
import com.mpl.Model.Employee;
import com.mpl.Repository.EmpRepo;
@Service
public class CreateEmployeeService {

	@Autowired
	private EmpRepo empRepo;
	
	public Employee saveEmployee(Employee emp) {
		
		List<Address> addresses=new ArrayList<>();
		
		Address ad1=new Address();
		ad1.setCity("Nashik");
		ad1.setState("Maharashtra");
		
		Address ad2=new Address();
		ad2.setCity("Satana");
		ad2.setState("Maharashtra");
		
		Address ad3=new Address();
		ad3.setCity("Malegaon");
		ad3.setState("Maharashtra");
		
		addresses.add(ad1);
		addresses.add(ad2);
		addresses.add(ad3);
		
		ad1.setEmployee(emp);
		ad2.setEmployee(emp);
		ad3.setEmployee(emp);
		
		emp.setAddresses(addresses);
		Employee save = empRepo.save(emp);
		return save;
	}
}
