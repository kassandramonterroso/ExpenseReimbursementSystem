package service;

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
	public ReimbursementPojo empViewPending(ReimbursementPojo reimbursementPojo) throws ApplicationException{
		return reimbursementDao.empViewPending(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo empViewResolved(ReimbursementPojo reimbursementPojo) throws ApplicationException{
		return reimbursementDao.empViewResolved(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo manViewAllPending(ReimbursementPojo reimbursementPojo) throws ApplicationException{
		return reimbursementDao.manViewAllPending(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo manViewAllResolved(ReimbursementPojo reimbursementPojo) throws ApplicationException{
		return reimbursementDao.manViewAllResolved(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo manViewRequest(int requesterId) throws ApplicationException{
		//logger.info("Entered manViewRequest() in service.");
		ReimbursementPojo returnReimbursementPojo = this.reimbursementDao.manViewRequest(requesterId);
		//logger.info("Exited manViewRequest() in service.");
		return returnReimbursementPojo;
	}

}
