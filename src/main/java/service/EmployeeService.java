package service;

import exception.ApplicationException;
import model.EmployeePojo;

public interface EmployeeService {
	
	//Method for login
	EmployeePojo login(String username, String password)throws ApplicationException;
	
	//Method for logout
	EmployeePojo logout(EmployeePojo employeePojo);
	
	//Method for employee to view their information
	EmployeePojo empViewInfo(EmployeePojo employeePojo) throws ApplicationException;
	
	//Method for employee to update their information
	EmployeePojo empUpdateInfo(EmployeePojo employeePojo) throws ApplicationException;
	
	//Method for manager to view all employees
	EmployeePojo manViewAll(EmployeePojo employeePojo) throws ApplicationException;

}
