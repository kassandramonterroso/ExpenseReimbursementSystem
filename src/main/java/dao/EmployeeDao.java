package dao;

import exception.ApplicationException;
import model.EmployeePojo;

public interface EmployeeDao {
	
	//method for login
	EmployeePojo login(String username, String password) throws ApplicationException;
	
	//Method for logout
	EmployeePojo logout(EmployeePojo employeePojo);
	
	//Method for employee to view their information
	EmployeePojo empViewInfo(EmployeePojo employeePojo);
	
	//Method for employee to update their information
	EmployeePojo empUpdateInfo(EmployeePojo employeePojo);
	
	//Method for manager to view all employees
	EmployeePojo manViewAll(EmployeePojo employeePojo);

}
