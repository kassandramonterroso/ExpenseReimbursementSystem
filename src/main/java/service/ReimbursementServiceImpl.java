package service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import exception.ApplicationException;
import model.ReimbRequestPojo;
import model.ReimbursementPojo;

public class ReimbursementServiceImpl implements ReimbursementService{
	final Logger LOG = LogManager.getLogger(ReimbursementServiceImpl.class);
	
	//Creating an ReimbursementDaoImpl to call dao layer from the service layer
		ReimbursementDaoImpl reimbursementDao;
		
		public ReimbursementServiceImpl() {
			reimbursementDao = new ReimbursementDaoImpl();
		}

	@Override
	public ReimbursementPojo submitRequest(int empId, int amt) throws ApplicationException{
		LOG.info("Hit submitRequest() in RiembursementServiceImpl");
		ReimbursementPojo currRequest = new ReimbursementPojo(0, amt, 1, empId, 2);
		ReimbursementPojo reimbursementPojo = reimbursementDao.submitRequest(currRequest);
		LOG.info("returning submitRequest() in RiembursementServiceImpl");
		return reimbursementPojo;
	}

	@Override

	public ReimbursementPojo manUpdateRequest(ReimbursementPojo reimbursementPojo, int reimbId) throws ApplicationException{
		LOG.info("Hit manUpdateRequest() in RiembursementServiceImpl");
		LOG.info("returning manUpdateRequest() in RiembursementServiceImpl");
		
		return reimbursementDao.manUpdateRequest(reimbursementPojo, reimbId);
	}

	public ReimbursementPojo manApproveRequest(ReimbursementPojo reimbursementPojo, int reimbInt) throws ApplicationException{
		LOG.info("Hit manUpdateRequest() in RiembursementServiceImpl");
		LOG.info("returning manUpdateRequest() in RiembursementServiceImpl");
		
		return reimbursementDao.manApproveRequest(reimbursementPojo, reimbInt);

	}

	@Override

	public ReimbursementPojo manDenyRequest(ReimbursementPojo reimbursementPojo, int reimbInt) throws ApplicationException{
		LOG.info("Hit manUpdateRequest() in RiembursementServiceImpl");
		LOG.info("returning manUpdateRequest() in RiembursementServiceImpl");
		
		return reimbursementDao.manDenyRequest(reimbursementPojo, reimbInt);
	}
	
	@Override
	public List<ReimbursementPojo> empViewPending(int empId) throws ApplicationException{

		LOG.info("Hit empViewPending() in RiembursementServiceImpl");
		
		List<ReimbursementPojo> reimbursementPojo = this.reimbursementDao.empViewPending(empId);
		LOG.info("returning empViewPending() in RiembursementServiceImpl");
		
		return reimbursementPojo;
	}

	@Override
	public List<ReimbursementPojo> empViewResolved(int empId) throws ApplicationException{
		LOG.info("Hit empViewResolved() in RiembursementServiceImpl");
		

		List<ReimbursementPojo> reimbRequestPojo = reimbursementDao.empViewResolved(empId);

		List<ReimbursementPojo> reimbursementPojo = reimbursementDao.empViewResolved(empId);

		LOG.info("returning empViewResolved() in RiembursementServiceImpl");
		
		return reimbursementPojo;
	}

	@Override
	public
	List<ReimbRequestPojo> manViewAllPending() throws ApplicationException{
		LOG.info("Hit manViewAllPending() in RiembursementServiceImpl");
		List<ReimbRequestPojo> allPending = reimbursementDao.manViewAllPending();
		LOG.info("returning manViewAllPending() in RiembursementServiceImpl");
		
		return allPending;
	}

	@Override
	public List<ReimbRequestPojo> manViewAllResolved() throws ApplicationException{
		LOG.info("Hit manViewAllResolved() in RiembursementServiceImpl");
		
		List<ReimbRequestPojo> allResolved = reimbursementDao.manViewAllResolved();
		LOG.info("returning manViewAllResolved() in RiembursementServiceImpl");
		
		return allResolved;
	}

	@Override
	public ReimbRequestPojo manViewRequest(int requesterId) throws ApplicationException{
		LOG.info("Entered manViewRequest() in service.");
		ReimbRequestPojo returnReimbursementPojo = reimbursementDao.manViewRequest(requesterId);
		LOG.info("Exited manViewRequest() in service.");
		return returnReimbursementPojo;
	}

	

}
