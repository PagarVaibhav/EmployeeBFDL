package com.mpl;

import static org.assertj.core.api.Assertions.assertThat;
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
import com.mpl.ServiceI.GetEmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class GetEmployeeServiceTest extends EmployeeManagementSystemApplicationTests{

	@Mock
	private EmpRepo empRepo;
	
	@InjectMocks
	private GetEmployeeService getEmployeeService;
	
	@Test
	public void whenGivenId_ReturnsEmployee_ifFound() {
		
		Employee emp=new Employee();
		emp.setEmpid(emp.getEmpid());
		
		when(empRepo.findById(emp.getEmpid())).thenReturn(Optional.of(emp));
		Employee getEmp = getEmployeeService.getEmployee(emp.getEmpid());
		assertThat(getEmp).isSameAs(emp);
		//assertEquals(getEmp, emp);
		verify(empRepo).findById(emp.getEmpid());
	}
}
