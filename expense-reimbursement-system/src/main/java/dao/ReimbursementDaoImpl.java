package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.ApplicationException;
import model.ReimbursementPojo;

public class ReimbursementDaoImpl implements ReimbursementDao {

	@Override
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementPojo manUpdateRequest(ReimbursementPojo reimbursementPojo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ReimbursementPojo empViewPending(ReimbursementPojo reimbursementPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT balance FROM account_details WHERE";   //I will fill this in                                                      
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			//reimbursementPojo.setBalance(resultSet.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursementPojo;
	}

	@Override
	public ReimbursementPojo empViewResolved(ReimbursementPojo reimbursementPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT balance FROM account_details WHERE user_id=";    //I will fill this in                                                        
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			//reimbursementPojo.setBalance(resultSet.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursementPojo;
	}

	@Override
	public ReimbursementPojo manViewAllPending(ReimbursementPojo reimbursementPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT balance FROM account_details WHERE user_id=";       //I will fill this in                                                     
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			//reimbursementPojo.setBalance(resultSet.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursementPojo;
	}

	@Override
	public ReimbursementPojo manViewAllResolved(ReimbursementPojo reimbursementPojo) {
		Connection connect;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT balance FROM account_details WHERE user_id=";       //I will fill this in                                                     
			ResultSet resultSet = stmt.executeQuery(query);
			resultSet.next();
			//reimbursementPojo.setBalance(resultSet.getDouble(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursementPojo;
	}

	@Override
	public ReimbursementPojo manViewRequest(ReimbursementPojo reimbursementPojo) {
		//LOG.info("Entered manViewAll() in Dao...");
		Connection connect = null;
		//ReimbursementPojo reimbursementPojo = null;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT e.emp_id,  e.first_name, e.last_name, r.reimb_id , s.status FROM employees e JOIN reimbursements r ON e.emp_id = r.requester_id JOIN status s ON r.reimb_status_id = s.status_id WHERE e. emp_id ="+reimbursementPojo.getRequesterId();
			ResultSet resultSet = stmt.executeQuery(query);
			if(resultSet.next()) {
				//reimbursementPojo = new ReimbursementPojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4));
				reimbursementPojo = new ReimbursementPojo(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getInt(5));
			}
		} catch (SQLException e) {
			throw new ApplicationException();
		}
		//LOG.info("Exited manViewAll() in Dao...");
			return reimbursementPojo;
	}

}
