package com.mpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mpl.Model.Employee;
import com.mpl.Repository.EmpRepo;
import com.mpl.ServiceI.CreateEmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class CreateEmployeeServiceTest extends EmployeeManagementSystemApplicationTests{

	@Mock
	private EmpRepo empRepo;
	
	@InjectMocks
	private CreateEmployeeService createEmployeeService;
	
	@Test
	public void whenSaveEmp_ReturnEmployee() {
		
		Employee emp=new Employee();
		
		emp.setEmpname(emp.getEmpname());
		
		when(empRepo.save(ArgumentMatchers.any(Employee.class))).thenReturn(emp);
		Employee saveEmployee = createEmployeeService.saveEmployee(emp);
		assertThat(saveEmployee.getEmpname()).isSameAs(emp.getEmpname());
		verify(empRepo).save(emp);
	}
}
