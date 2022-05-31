CREATE TABLE employees(
   emp_id serial,
   first_name VARCHAR(255) NOT NULL,
   last_name VARCHAR(255) NOT NULL,
   user_name VARCHAR(255) NOT NULL,
   hashed_password VARCHAR(255) NOT NULL,
   emp_role_id INT,
   PRIMARY KEY(emp_id)
);

CREATE TABLE roles(
role_id serial,
role VARCHAR(50) NOT NULL,
PRIMARY KEY(role_id)
);

CREATE TABLE reimbursements(
  reimb_id serial,
  reimb_amt double precision,
reimb_status_id INT,
requester_id int,
approver_id int,
PRIMARY KEY(reimb_id),
      FOREIGN KEY(reimb_status_id) 
      REFERENCES status(status_id),
FOREIGN KEY(requester_id) 
      REFERENCES employees(emp_id),
FOREIGN KEY(approver_id) 
      REFERENCES employees(emp_id)
);


CREATE TABLE status(
status_id serial,
status VARCHAR(255) NOT NULL,
PRIMARY KEY(status_id)
);