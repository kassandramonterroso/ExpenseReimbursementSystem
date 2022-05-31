package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.ApplicationException;
import model.EmployeePojo;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public EmployeePojo empLogin(EmployeePojo employeePojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePojo manLogin(EmployeePojo employeePojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePojo empLogout(EmployeePojo employeePojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePojo manLogout(EmployeePojo employeePojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeePojo empViewInfo(EmployeePojo employeePojo) {
		//LOG.info("Entered empViewInfo() in Dao...");
				Connection connect = null;
				//EmployeePojo employeePojo = new EmployeePojo();
				try {
					connect = DBUtil.dbConnection();
					Statement stmt = connect.createStatement();
					String query = "SELECT * FROM employees WHERE emp_id="+employeePojo.getEmpId();
					ResultSet resultSet = stmt.executeQuery(query);
					if(resultSet.next()) {
						employeePojo = new EmployeePojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
					}
				} catch (SQLException e) {
					throw new ApplicationException();
				}
				//LOG.info("Exited empViewInfo() in Dao...");
				return employeePojo;
	}

	@Override
	public EmployeePojo empUpdateInfo(EmployeePojo employeePojo) {
		//LOG.info("Entered empUpdateInfo() in Dao...");
				Connection connect = null;
				try {
					connect = DBUtil.dbConnection();
					Statement stmt = connect.createStatement();
					String query1 = "UPDATE employees SET first_name = '"+employeePojo.getEmpFirstName()+ "' WHERE emp_id = " +employeePojo.getEmpId();
					int rowsAffected1 = stmt.executeUpdate(query1);
					String query2 = "UPDATE employees SET last_name = '"+employeePojo.getEmpLastName()+ "' WHERE emp_id = " +employeePojo.getEmpId();
					int rowsAffected2 = stmt.executeUpdate(query2);
					String query3 = "UPDATE employees SET user_name = '"+employeePojo.getEmpUserName()+ "' WHERE emp_id = " +employeePojo.getEmpId();
					int rowsAffected3 = stmt.executeUpdate(query3);
					String query4 = "UPDATE employees SET hashed_password = '"+employeePojo.getEmpPassword()+ "' WHERE emp_id = " +employeePojo.getEmpId();
					int rowsAffected4 = stmt.executeUpdate(query4);

				} catch (SQLException e) {
					e.printStackTrace();
					throw new ApplicationException();
				}
				//LOG.info("Exited empUpdateInfo() in Dao...");
				return employeePojo;
	}

	@Override
	public EmployeePojo manViewAll(EmployeePojo employeePojo) {
		//LOG.info("Entered manViewAll() in Dao...");
				Connection connect = null;
				//EmployeePojo employeePojo = new EmployeePojo();
				try {
					connect = DBUtil.dbConnection();
					Statement stmt = connect.createStatement();
					String query = "SELECT e.emp_id,  e.first_name, e.last_name, r.reimb_id , s.status FROM employees e JOIN reimbursements r ON e.emp_id = r.requester_id JOIN status s ON r.reimb_status_id = s.status_id";
					ResultSet resultSet = stmt.executeQuery(query);
					if(resultSet.next()) {
						employeePojo = new EmployeePojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
					}
				} catch (SQLException e) {
					throw new ApplicationException();
				}
						//LOG.info("Exited manViewAll() in Dao...");
				return employeePojo;
			}
	}


