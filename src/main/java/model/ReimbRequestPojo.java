package model;

public class ReimbRequestPojo {
	private int empId;
	private String firstName;
	private String lastName;
	private int reimbId;
	private String status;
	public ReimbRequestPojo(int empId, String firstName, String lastName, int reimbId, String status) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reimbId = reimbId;
		this.status = status;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getReimbId() {
		return reimbId;
	}
	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	

	
}
