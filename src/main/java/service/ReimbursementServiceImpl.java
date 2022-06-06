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
		ReimbursementDao reimbursementDao;
		
		public ReimbursementServiceImpl() {
			reimbursementDao = new ReimbursementDaoImpl();
		}

	@Override
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException{
		LOG.info("Hit submitRequest() in RiembursementServiceImpl");
		LOG.info("returning submitRequest() in RiembursementServiceImpl");
		return reimbursementDao.submitRequest(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo manUpdateRequest(ReimbursementPojo reimbursementPojo) throws ApplicationException{
		LOG.info("Hit manUpdateRequest() in RiembursementServiceImpl");
		LOG.info("returning manUpdateRequest() in RiembursementServiceImpl");
		
		return reimbursementDao.manUpdateRequest(reimbursementPojo);
	}

	@Override
	public List<ReimbursementPojo> empViewPending(int empId) throws ApplicationException{
		LOG.info("Hit empViewPending() in RiembursementServiceImpl");
		
		List<ReimbursementPojo> reimbursementPojo = this.reimbursementDao.empViewPending(empId);
		LOG.info("returning empViewPending() in RiembursementServiceImpl");
		
		return reimbursementPojo;
	}

	@Override
	public List<ReimbRequestPojo> empViewResolved(int empId) throws ApplicationException{
		LOG.info("Hit empViewResolved() in RiembursementServiceImpl");
		
		List<ReimbRequestPojo> reimbRequestPojo = reimbursementDao.empViewResolved(empId);
		LOG.info("returning empViewResolved() in RiembursementServiceImpl");
		
		return reimbRequestPojo;
	}

	@Override
	public
	List<ReimbursementPojo> manViewAllPending() throws ApplicationException{
		LOG.info("Hit manViewAllPending() in RiembursementServiceImpl");
		List<ReimbursementPojo> allPending = reimbursementDao.manViewAllPending();
		LOG.info("returning manViewAllPending() in RiembursementServiceImpl");
		
		return allPending;
	}

	@Override
	public
	List<ReimbursementPojo> manViewAllResolved() throws ApplicationException{
		LOG.info("Hit manViewAllResolved() in RiembursementServiceImpl");
		
		List<ReimbursementPojo> allResolved = reimbursementDao.manViewAllResolved();
		LOG.info("returning manViewAllResolved() in RiembursementServiceImpl");
		
		return allResolved;
	}

	@Override
	public ReimbursementPojo manViewRequest(int requesterId) throws ApplicationException{
		LOG.info("Entered manViewRequest() in service.");
		ReimbursementPojo returnReimbursementPojo = reimbursementDao.manViewRequest(requesterId);
		LOG.info("Exited manViewRequest() in service.");
		return returnReimbursementPojo;
	}

}
