package dao;

import java.util.List;

import exception.ApplicationException;
import model.EmployeePojo;
import model.RolesPojo;

public interface EmployeeDao {
	
	//method for login
	EmployeePojo login(String username, String password) throws ApplicationException;
	
	//Method for logout
	EmployeePojo logout(EmployeePojo employeePojo) throws ApplicationException;
	
	//Method for employee to view their information
	EmployeePojo empViewInfo(int empId) throws ApplicationException;
	
	//Method for employee to update their information
	EmployeePojo empUpdateInfo(EmployeePojo employeePojo) throws ApplicationException;
	
	//Method for manager to view all employees
	List<EmployeePojo> manViewAll() throws ApplicationException;
	

	boolean checkPass(String password, String hashedPass);

	String hashPassword(String password);
	//method to get role information
	RolesPojo getRole(int id) throws ApplicationException;

	
}
