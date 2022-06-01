package service;

import java.util.List;

import exception.ApplicationException;
import model.EmployeePojo;

public interface EmployeeService {
	
	//Method for login

	EmployeePojo login(String username, String password) throws ApplicationException;

	EmployeePojo login(String username, String password)throws ApplicationException;

	
	//Method for logout
	EmployeePojo logout(EmployeePojo employeePojo) throws ApplicationException;
	
	//Method for employee to view their information
	EmployeePojo empViewInfo(int empId) throws ApplicationException;
	
	//Method for employee to update their information
	EmployeePojo empUpdateInfo(EmployeePojo employeePojo) throws ApplicationException;
	
	//Method for manager to view all employees
	List<EmployeePojo> manViewAll() throws ApplicationException;
	
	//Method to changePassword only
	EmployeePojo changePassword(int empId) throws ApplicationException;

}
