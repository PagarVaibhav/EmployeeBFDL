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
import com.mpl.ServiceI.DeleteEmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class DeleteEmployeeServiceTest extends EmployeeManagementSystemApplicationTests{

	@Mock
	private EmpRepo empRepo;
	
	@InjectMocks
	private DeleteEmployeeService deleteEmployeeService;
	
	@Test
	public void whenGivenId_shouldDeleteEmployee_ifFound() {
		
		Employee emp=new Employee();
		emp.setEmpname(emp.getEmpname());
		emp.setEmpid(emp.getEmpid());
		
		when(empRepo.findById(emp.getEmpid())).thenReturn(Optional.of(emp));
		deleteEmployeeService.deleteEmployee(emp.getEmpid());
		verify(empRepo).deleteById(emp.getEmpid());
	}
}
