package service;

import dao.EmployeeDao;
import dao.EmployeeDaoImpl;
import model.EmployeePojo;

public class EmployeeServiceImpl implements EmployeeService{
	
	//Creating an EmployeeDaoImpl to call dao layer from the service layer
	EmployeeDao employeeDao;
	
	public EmployeeServiceImpl() {
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public EmployeePojo empLogin(EmployeePojo employeePojo) {
		return employeeDao.empLogin(employeePojo);
	}

	@Override
	public EmployeePojo manLogin(EmployeePojo employeePojo) {
		return employeeDao.manLogin(employeePojo);
	}

	@Override
	public EmployeePojo empLogout(EmployeePojo employeePojo) {
		return employeeDao.empLogout(employeePojo);
	}

	@Override
	public EmployeePojo manLogout(EmployeePojo employeePojo) {
		return employeeDao.manLogout(employeePojo);
	}

	@Override
	public EmployeePojo empViewInfo(EmployeePojo employeePojo) {
		return employeeDao.empViewInfo(employeePojo);
	}

	@Override
	public EmployeePojo empUpdateInfo(EmployeePojo employeePojo) {
		return employeeDao.empUpdateInfo(employeePojo);
	}

	@Override
	public EmployeePojo manViewAll(EmployeePojo employeePojo) {
		return employeeDao.manViewAll(employeePojo);
	}

}
