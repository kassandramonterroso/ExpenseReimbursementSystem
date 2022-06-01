package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
	public EmployeePojo empViewInfo(int empId) throws ApplicationException{
		//logger.info("Entered empViewInfo() in service.");
		EmployeePojo returnEmployeePojo = this.employeeDao.empViewInfo(empId);
		//logger.info("Exited empViewInfo() in service.");
		return returnEmployeePojo;
	}

	@Override
	public EmployeePojo empUpdateInfo(EmployeePojo employeePojo, String currPassword) throws ApplicationException{
		//logger.info("Entered empUpdateInfo() in service.");
		Boolean checkPassword = employeeDao.checkPass(currPassword, employeePojo.getEmpPassword());
		if (checkPassword == true) {
			EmployeePojo returnEmployeePojo = this.employeeDao.empUpdateInfo(employeePojo);
			return returnEmployeePojo;
		}else {
			throw new ApplicationException("incorrect Password");
		}
		
		//logger.info("Exited empUpdateInfo() in service.");
		
	}

	@Override
	public List<EmployeePojo> manViewAll() throws ApplicationException{
		//logger.info("Entered manViewAll() in service.");
		EmployeePojo allEmployees = this.employeeDao.manViewAll();
		//logger.info("Exited manViewAll() in service.");
		return (List<EmployeePojo>) allEmployees;
	}
	@Override
	public EmployeePojo logout(EmployeePojo employeePojo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public EmployeePojo changePassword(int empId) throws ApplicationException {
		//logger.info("Entered changePassword() in service.");
		EmployeePojo returnEmployeePojo = this.employeeDao.changePassword(empId);
		//logger.info("Exited changePassword() in service.");
		return returnEmployeePojo;
	}

}
