package service;

import java.util.List;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import exception.ApplicationException;
import model.EmployeePojo;
import model.ReimbursementPojo;

public class ReimbursementServiceImpl implements ReimbursementService{
	
	//Creating an ReimbursementDaoImpl to call dao layer from the service layer
		ReimbursementDao reimbursementDao;
		
		public ReimbursementServiceImpl() {
			reimbursementDao = new ReimbursementDaoImpl();
		}

	@Override
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException{
		return reimbursementDao.submitRequest(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo manUpdateRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException{
		return reimbursementDao.manUpdateRequest(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo empViewPending(int empId) throws ApplicationException{
		ReimbursementPojo reimbursementPojo = this.reimbursementDao.empViewPending(empId);
		return reimbursementPojo;
	}

	@Override
	public ReimbursementPojo empViewResolved(int empId) throws ApplicationException{
		ReimbursementPojo reimbursementPojo = this.reimbursementDao.empViewResolved(empId);
		return reimbursementPojo;
	}

	@Override
	public
	List<ReimbursementPojo> manViewAllPending() throws ApplicationException{
		ReimbursementPojo allPending = this.reimbursementDao.manViewAllPending();
		return (List<ReimbursementPojo>) allPending;
	}

	@Override
	public
	List<ReimbursementPojo> manViewAllResolved() throws ApplicationException{
		ReimbursementPojo allResolved = this.reimbursementDao.manViewAllResolved();
		return (List<ReimbursementPojo>) allResolved;
	}

	@Override
	public ReimbursementPojo manViewRequest(int requesterId) throws ApplicationException{
		//logger.info("Entered manViewRequest() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.manViewRequest(requesterId);
		//logger.info("Exited manViewRequest() in service.");
		return returnReimbursementPojo;
	}

}
