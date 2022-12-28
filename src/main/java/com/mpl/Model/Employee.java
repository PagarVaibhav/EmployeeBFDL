package com.mpl.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Employee_Info")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Emp_Id")
	private Integer empid;
	
	@NotEmpty
	@Size(min = 4 , message="Employee name must be gretter than 4 characters")
	@Column(name="Emp_Name")
	private String empname;
	
	@Email(message = "Email address is not valid")
	@Column(name="Emp_Email")
	private String empemail;
	
	@NotEmpty
	@Size(min=4 , max=10 , message="Password lenght min of 4 chars & max of 10 chars")
	@Column(name="Emp_Password")
	private String emppass;
	
	@NotNull(message= "Null is not acceptable for salary")
	@Column(name="Emp_Salary")
	private double empsalary;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee" , cascade = CascadeType.ALL)
	private List<Address> addresseList=new ArrayList<>();

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpemail() {
		return empemail;
	}

	public void setEmpemail(String empemail) {
		this.empemail = empemail;
	}

	public String getEmppass() {
		return emppass;
	}

	public void setEmppass(String emppass) {
		this.emppass = emppass;
	}

	public double getEmpsalary() {
		return empsalary;
	}

	public void setEmpsalary(double empsalary) {
		this.empsalary = empsalary;
	}

	public List<Address> getAddresses() {
		return addresseList;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresseList = addresses;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", empemail=" + empemail + ", emppass=" + emppass
				+ ", empsalary=" + empsalary + ", addresses=" + addresseList + "]";
	}
	
	
}
