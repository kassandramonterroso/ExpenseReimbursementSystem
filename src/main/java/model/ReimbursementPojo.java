package model;

public class ReimbursementPojo {

	private int reimbId;
	private double reimbAmt;
	private int reimbStatusId;
	private int requesterId;
	private int approverId;

	

	public ReimbursementPojo(int reimbId, double reimbAmt, int reimbStatusId, int requesterId, int approverId) {
		super();
		this.reimbId = reimbId;
		this.reimbAmt = reimbAmt;
		this.reimbStatusId = reimbStatusId;
		this.requesterId = requesterId;
		this.approverId = approverId;
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

	public int getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}

	public int getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}

	public int getApproverId() {
		return approverId;
	}

	public void setApproverId(int approverId) {
		this.approverId = approverId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + approverId;
		long temp;
		temp = Double.doubleToLongBits(reimbAmt);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + reimbId;
		result = prime * result + reimbStatusId;
		result = prime * result + requesterId;
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
		ReimbursementPojo other = (ReimbursementPojo) obj;
		if (approverId != other.approverId)
			return false;
		if (Double.doubleToLongBits(reimbAmt) != Double.doubleToLongBits(other.reimbAmt))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (reimbStatusId != other.reimbStatusId)
			return false;
		if (requesterId != other.requesterId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementPojo [reimbId=" + reimbId + ", reimbAmt=" + reimbAmt + ", reimbStatusId=" + reimbStatusId
				+ ", requesterId=" + requesterId + ", approverId=" + approverId + "]";
	}

}
