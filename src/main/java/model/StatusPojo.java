package model;

public class StatusPojo {
	//Status pojo variables
	private int status_Id;
	private String status;
	
	
	//Constructor for the superclass Object
	public StatusPojo() {
		super();
	}


	//Constructors for the fields
	public StatusPojo(int status_Id, String status) {
		super();
		this.status_Id = status_Id;
		this.status = status;
	}


	
	//Getter and Setter methods for the variables
	public int getStatus_Id() {
		return status_Id;
	}



	public void setStatus_Id(int status_Id) {
		this.status_Id = status_Id;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
}
