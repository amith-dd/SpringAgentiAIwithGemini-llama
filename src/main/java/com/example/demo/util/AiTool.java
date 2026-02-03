package com.example.demo.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;

@Component
public class AiTool {
	@Autowired
	public EmployeeRepo employeeRepo;
	
	@Tool("get employee profile by employee id")
	public Employee getEmployeeById(@P("employee id number")  int id) {
		return employeeRepo.findById(id);
	}
	@Tool("get active employee profiles")
	public  List<Employee> getActiveEmployees() {
		return employeeRepo.findActiveProfiles();
	}
	@Tool("calculate sum of all employee salaries of a department")
	public Double getSumSalaryByDepartment(@P("department name")  String department) {
		return employeeRepo.findSumSalaryByDepartment(department);
	}
	@Tool("get maximum salary of a department")
	public Double getMaxSalaryByDepartment(@P("department name")  String department) {
		return employeeRepo.findMaxSalaryByDepartment(department);
	}
	@Tool("get salary by employee id")
	public double getSalaryById(@P("employee id number")   int id) {
		return employeeRepo.findById(id).getSalary();
	}

	@Tool("get all the employees/profiles by a department")
	public List<Employee> getEmployeesByDepartment( @P("department name")  String department){
		return employeeRepo.findBydepartment(department);
	}
	@Tool("fetch  all the employees or profiles")
	public List<Employee> getEmployees(){
		return employeeRepo.findAll();
	}
	@Tool("get inactive employee profiles")
	public List<Employee> getInactiveEmployees(){
		return employeeRepo.findInActiveProfiles();
	}
	@Tool("find nth employee from a department")
	public Employee findnthEmployeeFromList( @P("department name") String department,
	        @P("number of employees to return") int n) {
		List<Employee> employees = employeeRepo.findBydepartment(department);
	    if (n > 0 && n <= employees.size()) {
	        return employees.get(n - 1); // Adjusting for zero-based index
	    } else {
	        return null; // or throw an exception based on your requirement
	    }
	}
	@Tool("get top 'n' number of employees by salary")
	public List<Employee> getTopNEmployees( @P("department name") String department,
	        @P("number of employees to return") int n){
		
		List<Employee> topNEmployees = employeeRepo.findBydepartment(department).stream()
				.sorted((e1 , e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
				.limit(n)
				.toList();
		return topNEmployees;
	}
	

	

//	public Object getEmployeeData(int id, SalaryQueryIntent intent,String department) {
//		if (id != 0) {
//			switch (intent) {
//			case NET_SALARY:
//				return employeeRepo.findById(id).getSalary() ; // Example calculation
//			case GROSS_SALARY:
//				return employeeRepo.findById(id).getSalary() ; // Example calculation
//			case SALARY:
//				return employeeRepo.findById(id).getSalary();
//			case PROFILE_DATA: 
//				return employeeRepo.findById(id);
//			case PROFILE: 
//				return employeeRepo.findById(id);
//			default:
//				return "Invalid Intent";
//			}
//		}else {
//			switch (intent) {
//			case ACTIVE_PROFILE:
//				return employeeRepo.findActiveProfiles();
//			case SUM_SALARY_BY_DEPARTMENT:
//				return employeeRepo.findSumSalaryByDepartment(department);
//			case MAX_SALARY_BY_DEPARTMENT:
//				return employeeRepo.findMaxSalaryByDepartment(department);
//			default:
//				return "Invalid Intent";
//			} 
//		}
//
//	}

}
