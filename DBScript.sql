DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS reimbursements;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS roles;



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
CREATE TABLE status(
status_id serial,
status VARCHAR(255) NOT NULL,
PRIMARY KEY(status_id)
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



INSERT INTO roles(role) VALUES ('Manager');
INSERT INTO roles(role) VALUES ('Employee');
INSERT INTO status(status) VALUES ('pending');
INSERT INTO status(status) VALUES ('approved');
INSERT INTO status(status) VALUES ('denied');
INSERT INTO employees(first_name, last_name, user_name, hashed_password, emp_role_id) VALUES ('logan', 'lastName', 'cat', '$2a$10$HwO.e2gax/jJuW49MfLbvujyUQu8Wr6yppRHXFkLp11./Hnaj74Nu', 1);
INSERT INTO employees(first_name, last_name, user_name, hashed_password, emp_role_id) VALUES ('doggy', 'lastName', 'dog', '$2a$10$HwO.e2gax/jJuW49MfLbvujyUQu8Wr6yppRHXFkLp11./Hnaj74Nu', 2);
INSERT INTO reimbursements(reimb_amt, reimb_status_id, requester_id, approver_id) VALUES (200.00, 1, 2,1);
INSERT INTO reimbursements(reimb_amt, reimb_status_id, requester_id, approver_id) VALUES (300.00, 1, 2,1);
INSERT INTO reimbursements(reimb_amt, reimb_status_id, requester_id, approver_id) VALUES (40.00, 2, 2,1);
INSERT INTO reimbursements(reimb_amt, reimb_status_id, requester_id, approver_id) VALUES (2.00, 3, 2,1);








;