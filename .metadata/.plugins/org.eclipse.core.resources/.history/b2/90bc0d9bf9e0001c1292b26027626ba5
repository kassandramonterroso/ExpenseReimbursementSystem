package service;

import dao.ReimbursementDao;
import dao.ReimbursementDaoImpl;
import model.ReimbursementPojo;

public class ReimbursementServiceImpl implements ReimbursementService{
	
	//Creating an ReimbursementDaoImpl to call dao layer from the service layer
		ReimbursementDao reimbursementDao;
		
		public ReimbursementServiceImpl() {
			reimbursementDao = new ReimbursementDaoImpl();
		}

	@Override
	public ReimbursementPojo submitRequest(ReimbursementPojo reimbursementPojo) {
		return reimbursementDao.submitRequest(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo manUpdateRequest(ReimbursementPojo reimbursementPojo) {
		return reimbursementDao.manUpdateRequest(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo empViewPending(ReimbursementPojo reimbursementPojo) {
		return reimbursementDao.empViewPending(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo empViewResolved(ReimbursementPojo reimbursementPojo) {
		return reimbursementDao.empViewResolved(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo manViewAllPending(ReimbursementPojo reimbursementPojo) {
		return reimbursementDao.manViewAllPending(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo manViewAllResolved(ReimbursementPojo reimbursementPojo) {
		return reimbursementDao.manViewAllResolved(reimbursementPojo);
	}

	@Override
	public ReimbursementPojo manViewRequest(ReimbursementPojo reimbursementPojo) {
		return reimbursementDao.manViewRequest(reimbursementPojo);
	}

}
