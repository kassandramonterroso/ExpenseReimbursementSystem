package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import dao.DBUtil;
import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import exception.ApplicationException;
import model.EmployeePojo;

public class EmployeeServiceImpl implements EmployeeService{
	
	//Creating an EmployeeDaoImpl to call dao layer from the service layer
	EmployeeDao employeeDao= new EmployeeDaoImpl();
	

	@Override
	public EmployeePojo login(String username, String password) throws ApplicationException {
		EmployeePojo user = null;
		try {
			user=employeeDao.login(username, password);
			return user;
		}catch(ApplicationException e) {
			throw new ApplicationException(e.getLocalizedMessage());
		}
		
	}

	@Override
	public EmployeePojo empViewInfo(EmployeePojo employeePojo) throws ApplicationException{
		return employeeDao.empViewInfo(employeePojo);
	}

	@Override
	public EmployeePojo empUpdateInfo(EmployeePojo employeePojo) throws ApplicationException{
		return employeeDao.empUpdateInfo(employeePojo);
	}

	@Override
	public EmployeePojo manViewAll(EmployeePojo employeePojo) throws ApplicationException{
		return employeeDao.manViewAll(employeePojo);
	}
	@Override
	public EmployeePojo logout(EmployeePojo employeePojo) {
		// TODO Auto-generated method stub
		return null;
	}

}
