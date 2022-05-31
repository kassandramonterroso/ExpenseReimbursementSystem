package dao;

import exception.ApplicationException;
import model.EmployeePojo;

public interface EmployeeDao {
	
	//Method for employee login
		EmployeePojo empLogin(EmployeePojo employeePojo);
		
		//Method for manager login
		EmployeePojo manLogin(EmployeePojo employeePojo);
		
		//Method for employee logout
		EmployeePojo empLogout(EmployeePojo employeePojo);
		
		//Method for manager logout
		EmployeePojo manLogout(EmployeePojo employeePojo);
		
		//Method for employee to view their information
		EmployeePojo empViewInfo(EmployeePojo employeePojo) throws ApplicationException;
		
		//Method for employee to update their information
		EmployeePojo empUpdateInfo(EmployeePojo employeePojo) throws ApplicationException;
		
		//Method for manager to view all employees
		EmployeePojo manViewAll(EmployeePojo employeePojo) throws ApplicationException;

}
