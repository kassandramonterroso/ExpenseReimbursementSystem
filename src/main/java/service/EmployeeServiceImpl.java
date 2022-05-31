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
	EmployeeDao employeeDao;
	
	public String hashPassword(String password) {
		// takes your password and returns an encrypted version of it
		String hashedPass = BCrypt.hashpw(password, BCrypt.gensalt(10));

		return hashedPass;
	}
	public boolean checkPass(String password, String hashedPass) {
		// takes your password and an encrypted password and compares it to see if its
		// the same values
		// as the password, if so it returns true
		if (BCrypt.checkpw(password, hashedPass)) {
			return true;
		} else {
			return false;
		}
	}
	@Override
	public EmployeePojo login(String username, String password) {
		Connection conn;
		ResultSet result = null;
		EmployeePojo employeePojo = null;
		try {
			conn = DBUtil.dbConnection();
			String query = "SELECT * FROM employees WHERE user_name = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, username);
			result = stmt.executeQuery();
			if(result.next()) {
				boolean checkPassword = checkPass(password, result.getString("hashed_password"));
				if (checkPassword == true) {
					// if correct password returns the user and their information
					employeePojo = new EmployeePojo(result.getInt(1), result.getString(2), result.getString(3),
							result.getString(4), result.getString(5), result.getInt(6));
					return employeePojo;
				} else {
					throw new SQLException();
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
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
