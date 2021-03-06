package dao;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exception.ApplicationException;
import model.EmployeePojo;
import model.ReimbRequestPojo;
import model.ReimbursementPojo;
import model.StatusPojo;

public class ReimbursementDaoImpl implements ReimbursementDao {
	final Logger LOG = LogManager.getLogger(ReimbursementDaoImpl.class);
	
	StatusPojo statusPojo = new StatusPojo();
	

	@Override
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException {
		LOG.info("hit submitRequest");
		try {
			Connection conn = DBUtil.dbConnection();
			Statement stmt = conn.createStatement();
			String query = "INSERT INTO reimbursements(reimb_amt) VALUES='("+reimbursementPojo.getReimbAmt()+")' JOIN employees ON reimbursements.requester_id=employees.emp_Id WHERE empId ='"+ reimbursementPojo.getRequesterId()+";";
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			reimbursementPojo.setReimbId(rs.getInt(1));
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("returning submitRequest");
		return reimbursementPojo;
	}

	@Override

	public ReimbursementPojo manUpdateRequest(ReimbursementPojo reimbursementPojo, int reimbId) throws ApplicationException {
		
		return null;
		
	}
	
	
	
	
	

	public ReimbursementPojo manApproveRequest(ReimbursementPojo reimbursementPojo, int reimbId) throws ApplicationException {
		LOG.info("hit manUpdateRequest");
		try {
			Connection conn = DBUtil.dbConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE status SET status='approved' WHERE status_id ="+reimbursementPojo.getReimbId();
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("returning manUpdateRequest");
		return reimbursementPojo;
	}
	
	@Override
	public ReimbursementPojo manDenyRequest(ReimbursementPojo reimbursementPojo, int reimbId) throws ApplicationException {

		LOG.info("hit manUpdateRequest");
		try {
			Connection conn = DBUtil.dbConnection();
			Statement stmt = conn.createStatement();

			String query = "update reimbursement set reimb_status_id='"+reimbursementPojo.getReimbStatusId()+"' where reimbId='"+reimbId+"'";

//			String query = "UPDATE status SET status='denied' WHERE status_id ="+reimbursementPojo.getReimbId();

			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("returning manUpdateRequest");
		return reimbursementPojo;
	}
	
	
	
	

	@Override
	public List<ReimbursementPojo> empViewPending(int empId) throws ApplicationException{
		LOG.info("hit empViewPending");
		Connection connect;
		List<ReimbursementPojo> reimbursementPojo = new ArrayList<ReimbursementPojo>();
		
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT status, status_id FROM status JOIN reimbursements ON status.status_id = reimbursements.reimb_status_id WHERE status ='pending' AND requester_id="+empId;                                                    
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()) {
				reimbursementPojo.add(new ReimbursementPojo(resultSet.getInt(1), resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5)));
			}
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("returning empViewPending");
		return reimbursementPojo;
	}

	@Override
	public List<ReimbursementPojo> empViewResolved(int empId) throws ApplicationException{
		LOG.info("hit empViewResolved");
		Connection connect;
		List<ReimbursementPojo> reimbursementPojo = new ArrayList<ReimbursementPojo>();

		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT status, status_id FROM status JOIN reimbursements ON status.status_id = reimbursements.reimb_status_id WHERE status ='resolved' AND requester_id="+empId;                                                    
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()) {
				reimbursementPojo.add(new ReimbursementPojo(resultSet.getInt(1), resultSet.getInt(2),resultSet.getInt(3),resultSet.getInt(4),resultSet.getInt(5)));
			}
			
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("returning empViewResolved");
		return reimbursementPojo;
	}

	@Override
	public List<ReimbRequestPojo> manViewAllPending() throws ApplicationException{
		LOG.info("hit manViewAllPending");
		Connection connect;
		List<ReimbRequestPojo> reimbRequestPojo = new ArrayList<ReimbRequestPojo>();
		
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT e.emp_id,  e.first_name, e.last_name, r.reimb_id ,r.reimb_amt, s.status FROM employees e JOIN reimbursements r ON e.emp_id = r.requester_id JOIN status s ON r.reimb_status_id = s.status_id WHERE e. emp_id =2 AND status_id = 1";                                                     
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()) {
				
				reimbRequestPojo.add(new ReimbRequestPojo(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6)));
			}
		} catch (SQLException e) {
			
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("returning manViewAllPending");
		return reimbRequestPojo;
	}

	@Override
	public List<ReimbRequestPojo> manViewAllResolved() throws ApplicationException{
		
		LOG.info("hit manViewAllResolved");
		Connection connect;
		List<ReimbRequestPojo> reimbRequestPojo = new ArrayList<ReimbRequestPojo>();
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT e.emp_id,  e.first_name, e.last_name, r.reimb_id ,r.reimb_amt, s.status FROM employees e JOIN reimbursements r ON e.emp_id = r.requester_id JOIN status s ON r.reimb_status_id = s.status_id WHERE e. emp_id =2 AND status_id = 2 OR status_id = 3;";                                                  
			ResultSet resultSet = stmt.executeQuery(query);
			while(resultSet.next()) {
				reimbRequestPojo.add(new ReimbRequestPojo(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6)));
				
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		System.out.println(reimbRequestPojo);
		LOG.info("returning manViewAllResolved");
		return reimbRequestPojo;
	}

	@Override
	public ReimbRequestPojo manViewRequest(int requesterId) throws ApplicationException{
		LOG.info("hit manViewRequest");
		Connection connect = null;
		ReimbRequestPojo reimbRequestPojo = null;
		try {
			connect = DBUtil.dbConnection();
			Statement stmt = connect.createStatement();
			String query = "SELECT e.emp_id,  e.first_name, e.last_name, r.reimb_id ,r.reimb_amt, s.status FROM employees e JOIN reimbursements r ON e.emp_id = r.requester_id JOIN status s ON r.reimb_status_id = s.status_id WHERE r.reimb_id="+ requesterId+" ;";
			ResultSet resultSet = stmt.executeQuery(query);
			if(resultSet.next()) {
				reimbRequestPojo =new ReimbRequestPojo(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getInt(5),resultSet.getString(6));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e.getMessage());
		}
		LOG.info("returning manViewRequest");
			return reimbRequestPojo;
	}

}
