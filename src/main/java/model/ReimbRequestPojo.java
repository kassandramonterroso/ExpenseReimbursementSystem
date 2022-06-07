package model;

public class ReimbRequestPojo {
	private int empId;
	private String firstName;
	private String lastName;
	private int reimbId;
	private double reimbAmt;
	private String status;
		
	public ReimbRequestPojo(int empId, String firstName, String lastName, int reimbId, double reimbAmt, String status) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reimbId = reimbId;
		this.reimbAmt = reimbAmt;
		this.status = status;
	}
	public ReimbRequestPojo(int empId, String firstName, String lastName, double reimbAmt, String status) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reimbAmt = reimbAmt;
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
	public double getReimbAmt() {
		return reimbAmt;
	}
	public void setReimbAmt(double reimbAmt) {
		this.reimbAmt = reimbAmt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReimbRequestPojo [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", reimbId="
				+ reimbId + ", reimbAmt=" + reimbAmt + ", status=" + status + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + empId;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(reimbAmt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbRequestPojo other = (ReimbRequestPojo) obj;
		if (empId != other.empId)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(reimbAmt) != Double.doubleToLongBits(other.reimbAmt))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
}
