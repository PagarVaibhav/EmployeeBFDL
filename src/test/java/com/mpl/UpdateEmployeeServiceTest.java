package com.mpl;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mpl.Model.Employee;
import com.mpl.Repository.EmpRepo;
import com.mpl.ServiceI.UpdateEmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class UpdateEmployeeServiceTest extends EmployeeManagementSystemApplicationTests{

	@Mock
	private EmpRepo empRepo;
	
	@InjectMocks
	private UpdateEmployeeService updateEmployeeService;
	
	@Test
	public void whenGivenId_shouldUpdateEmployee_ifFound() {
		
		Employee emp=new Employee();
		emp.setEmpid(emp.getEmpid());
		emp.setEmpname(emp.getEmpname());
		
		Employee emp1=new Employee();
		emp1.setEmpname("Dipak Sonawane");
		
		when(empRepo.findById(emp.getEmpid())).thenReturn(Optional.of(emp));
		
		updateEmployeeService.updateEmployee(emp.getEmpid(), emp1);
		verify(empRepo).save(emp1);
		verify(empRepo).findById(emp.getEmpid());
	}
}
