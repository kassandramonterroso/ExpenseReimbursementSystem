
function getAllEmployees(){ //manViewAll method
    //use fetch api to consume end points java
     fetch("http://localhost:8082/emps")
     .then(response => response.json())
     .then(responseJson => {
         console.log(responseJson)
         let employeeTableData = ` <div class="loginbox">
                                    <table>
                                    <thead>
                                    <tr>
                                        <th>Employee ID</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                    </tr>
                                    </thead>
                                    <tbody>`;
            for(let e of responseJson){
                employeeTableData += `<tr>
                                        <td>
                                            <a href="#" onclick="viewSpecificEmployeeRequest( ${e.empId} )">
                                            ${e.empId}
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" onclick="viewSpecificEmployeeRequest(${e.empFirstName} ")>
                                            ${e.empFirstName}
                                            </a>                                            
                                        </td>

                                        <td>${e.empLastName}</td>
                                    `
                                        if(e.empRoleId == 2){
                                            employeeTableData += `
                                           <td>
                                            <button 
                                                type="button" 
                                                class="btn btn-primary"
                                                onclick="approveRequest(${e.reimbId})"> Approve 
                                            </button>
                                            <button 
                                                type="button" 
                                                class="btn btn-danger"
                                                onclick="rejectRequest(${e.reimbId})"> Reject 
                                            </button>
                                            </td>`
                                        }
                                        employeeTableData += `</tr>`;
                employeeTableData += `</tr>`;

            }
            employeeTableData += `</tbody></table></div>`;
            document.getElementById("content").innerHTML = employeeTableData;
        })
     .catch(error => console.log(error));
 }


 function viewSpecificEmployeeRequest(eid){ //manViewRequest method
    fetch("http://localhost:8082/emps/"+eid)
    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson)
        let employeeData = `<div class="row">
                                <div class="col-xs-1 center-block">
                                    <p class = "solid">
                                        <h4>Employee Details</h4>
                                        <p> Employee Id : ${empId} </p><br>
                                        <p>Employee First Name : ${empFirstName}</p>
                                        <br>
                                        <p>Employee Last Name : ${empLastName}</p>
                                        <br>
                                        <p>Employee Reimubursement Request Id : {reimbId}</p>
                                        <br>
                                        <p>Reimbursement Request Amount : ${reimbAmt}</p>
                                        <br>
                                        <p> Request Status : ${status}</p>
                                        <br>
                                        <div>
                                            <button type="button" class="btn btn-primary" onclick="submitRequest()">Approve</button>
                                            <button type="button" class="btn btn-danger" onclick="cancelRequest()">Reject</button>
                                        </div>
                                    </p>
                                </div>
                            </div>`
        document.getElementById("content").innerHTML = employeeData;
    }).catch(error => console.log(error));
}

 function approveRequest(reimbId){
    let newApproveRequest = {
        reimbId: 0,
        reimbAmt: 0,
        reimbStatusId: 2,
        requesterId: 0,
        approverId: 0,
    }

    fetch("http://localhost:8082/reimbursements"+reimbId, {
        method: 'put',
        body: JSON.stringify(newApproveRequest)
    })
    .then(response => getAllEmployees())
 }

 function rejectRequest(reimbId){
    let newRejectRequest = {
        reimbId: 0,
        reimbAmt: 0,
        reimbStatusId: 3,
        requesterId: 0,
        approverId: 0,
    }

    fetch("http://localhost:8082/reimbursements"+reimbId, {
        method: 'put',
        body: JSON.stringify(newRejectRequest)
    })
    .then(response => getAllEmployees())
 }

 


 function displayRequest(){

    let requestForm = `<div class="container">
                        <form>
                             <div class="mb-3 mt-3">
                                <label for="eId" class="form-label">Employee Id : </label>
                                <input type="text" class="form-control" id="eId" placeholder="Enter Employee Id" name="empId">
                            </div>
                            <div class="mb-3 mt-3">
                                <label for="rAmount" class="form-label"> Request Amount : </label>
                                <input type="text" class="form-control" id="rAmount" placeholder="Enter request amount" name="reimbAmt">
                            </div>
                            <button type="button" class="btn btn-primary" onclick="submitRequest()">Submit Request</button>
                            <button type="button" class="btn btn-primary" onclick="cancelRequest()">Cancel</button>
                        </form>
                    </div>
                    `;
    document.getElementById("content").innerHTML = requestForm;
}

function submitRequest(){

    // construct a java script object whose properties match the bookpojo object's properties
        // of the back end application
    let newRequest = {
        reimbId: 0,
        reimbAmt: document.getElementById("eId").value,
    }
    fetch("http://localhost:8082/requests", {
        method: 'post',
        body: JSON.stringify(newRequest) // converts JS object to JSON 
    })
    .then(response => getAllEmployees());
}


function empViewPending(empId){ //call empViewPending method
    console.log(status);
    fetch("http://localhost:8082/employees"+empId)
    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson);
         let employeePending = `<table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Reimbursement Request Id</th>
                                <th>Reimbursement Request Amount</th>
                                <th>Reimbursement Request Status</th>
                            </tr>
                            </thead>
                            <tbody>`;
            for(let emp of responseJson){
                employeePending += `<tr>
                                        <td>${emp.empId}</td>
                                        <td>${emp.empFirstName}</td>
                                        <td>${emp.empastName}</td>
                                        <td>${emp.reimbId}</td>
                                        <td>${emp.reimbAmt}</td>
                                        <td>${emp.status}</td>
                                    </tr>`;
            }
            employeeTableData += `</tbody></table>`;
            document.getElementById("content").innerHTML = employeePending;
        })
     .catch(error => console.log(error));
 }
function viewInfo(){
    let user = JSON.parse(sessionStorage.getItem('currUser'));
    console.log(user);
    let content = "";
    if (user === undefined){
        content = `<h1>login first</h1>`
        document.getElementById("content").innerHTML = content;
    } else {
        fetch("http://localhost:8082/empRoleId/"+user.empId)
    .then(response => response.json())
    .then(responseJson => {
        content = `<div class="card" style="width: 18rem;">
        <div class="card-header">
          ${user.empUserName}'s information
        </div>
        <ul class="list-group list-group-flush">
          <li class="list-group-item">First name: ${user.empFirstName}</li>
          <li class="list-group-item">Last name: ${user.empLastName}</li>
          <li class="list-group-item">Employee Id: ${user.empId}</li>
          <li class="list-group-item">Employee Role: ${responseJson.role}</li>
        </ul>
      </div>`
      document.getElementById("content").innerHTML = content;

    }).catch(error => console.log(error));
    
    
    }
}
        


function empViewResolved(empId){ //call empViewResolved method
    console.log(status);
    fetch("http://localhost:8082/employees"+empId)
    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson);
         let employeeResolved = `<table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Reimbursement Request Id</th>
                                <th>Reimbursement Request Amount</th>
                                <th>Reimbursement Request Status</th>
                            </tr>
                            </thead>
                            <tbody>`;
            for(let emp of responseJson){
                employeeResolved += `<tr>
                                        <td>${emp.empId}</td>
                                        <td>${emp.empFirstName}</td>
                                        <td>${emp.empastName}</td>
                                        <td>${emp.reimbId}</td>
                                        <td>${emp.reimbAmt}</td>
                                        <td>${emp.status}</td>
                                    </tr>`;
            }
            employeeTableData += `</tbody></table>`;
            document.getElementById("content").innerHTML = employeeResolved;
        })
     .catch(error => console.log(error));
 }

function manViewAllResolved(){ 
    fetch("http://localhost:8082/employees")
    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson);
         let employeeResolved = `<table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Reimbursement Request Id</th>
                                <th>Reimbursement Request Amount</th>
                                <th>Reimbursement Request Status</th>
                            </tr>
                            </thead>
                            <tbody>`;
            for(let emp of responseJson){
                employeeResolved += `<tr>
                                        <td>${emp.empId}</td>
                                        <td>${emp.empFirstName}</td>
                                        <td>${emp.empastName}</td>
                                        <td>${emp.reimbId}</td>
                                        <td>${emp.reimbAmt}</td>
                                        <td>${emp.status}</td>
                                    </tr>`;
            }
            employeeTableData += `</tbody></table>`;
            document.getElementById("content").innerHTML = employeeResolved;
        })
     .catch(error => console.log(error));
 }

 function manViewAllPending(){ 
    fetch("http://localhost:8082/empPendings")
    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson);
         let employeeResolved = `<table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Reimbursement Request Id</th>
                                <th>Reimbursement Request Amount</th>
                                <th>Reimbursement Request Status</th>
                            </tr>
                            </thead>
                            <tbody>`;
            for(let emp of responseJson){
                employeeResolved += `<tr>
                                        <td>${emp.empId}</td>
                                        <td>${emp.empFirstName}</td>
                                        <td>${emp.empastName}</td>
                                        <td>${emp.reimbId}</td>
                                        <td>${emp.reimbAmt}</td>
                                        <td>${emp.status}</td>
                                    </tr>`;
            }
            employeeTableData += `</tbody></table>`;
            document.getElementById("content").innerHTML = employeeResolved;
        })
     .catch(error => console.log(error));

function empViewInfo() {
    fetch("http://localhost:8082/employees")
    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson);
        let employeeInfo = `<table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Username</th>
                            </tr>
                            </thead>
                            <tbody>`;
                 for (let emp of responseJson) {
                     employeeInfo += `<tr>
                                            <td>${emp.empId}</td>
                                            <td>${emp.empFirstName}</td>
                                            <td>${emp.empLastName}</td>
                                            <td>${emp.empUsername}</td>
                                        </tr>`;
            }
            employeeTableData += `</tbody></table>`;
            document.getElementById("content").innerHTML = employeeInfo;
         })
     .catch(error => console.log(error));
     }
 }

 

 function viewMyEmpDetails(empId,empRoleId){

    fetch("http://localhost:8082/empOwn/"+empId)

 function viewMyEmpDetails(empId){
    fetch("http://localhost:8082/emps/"+empId)

    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson)
        let employeeData1 = `<table class="table table-striped">
                           <thead>
                           <tr>
                               <th>Employee ID</th>
                               <th>First Name</th>
                               <th>Last Name</th>
                               <th>Reimbursement Request Id</th>
                               <th>Reimbursement Request Amount</th>
                               <th>Reimbursement Request Status</th>`
                           `</tr>
                           </thead>
                           <tbody>`;
            employeeData1 += `<tr>
                            <td>${emp.empId}</td>
                            <td>${emp.empFirstName}</td>
                            <td>${emp.empastName}</td>
                            <td>${emp.reimbId}</td>
                            <td>${emp.reimbAmt}</td>
                            <td>${emp.status}</td>
                            </tr>`;
            employeeData1 += `</tbody></table>`;
           document.getElementById("content").innerHTML = employeeData1;
       })
    .catch(error => console.log(error));
}



         
      


 function loginEmp(){
    let loginForm = `<div class="container">
                        <form id = "form">
                             <div class="mb-3 mt-3">
                                <label for="user" class="form-label">Username : </label>
                                <input type="text" class="form-control" id="username" placeholder="Enter Username" name="empUserName">
                            </div>
                            <div class="mb-3 mt-3">
                                <label for="pass" class="form-label"> Password : </label>
                                <input type="text" class="form-control" id="password" placeholder="Enter password" name="empHashedPassword">
                            </div>
                            
                            <div class="mb-3 mt-3">
                                <button type="button" class="btn btn-primary" onclick="login()">Login</button>
                                <button type="button" class="btn btn-primary" onclick="CancelLogin()">Cancel</button>
                            </div>
                            <div class="mb-3 mt-3">
                                <a href="https://www.w3schools.com">Forgot Password</a>
                            </div>
                        </form>
                    </div>
                    `;
    document.getElementById("content").innerHTML = loginForm;
}



 }

function updateEmployeePage(){
    let user = JSON.parse(sessionStorage.getItem('currUser'));
    console.log(user);
    let content = "";
    if (user === undefined){
        content = `<h1>login first</h1>`
        document.getElementById("content").innerHTML = content;
    } else {
        fetch("http://localhost:8082/empRoleId/"+user.empId)
    .then(response => response.json())
    .then(responseJson => {
        
        content = `<div class="card" style="width: 18rem;">
       
        <form>
        <ul class="list-group list-group-flush">
        <li class="list-group-item">Username: ${user.empUserName}<input type = "text" name="empUserNameUpdate" id = "empUserNameUpdate"></li>
          <li class="list-group-item">First name: ${user.empFirstName}<input type = "text" name="empFirstNameUpdate"id = "empFirstNameUpdate"></li>
          <li class="list-group-item">Last name: ${user.empLastName}<input type = "text" name="empLastNameUpdate"id = "empLastNameUpdate"></li>
          <li class="list-group-item"> Input current password<input type = "text" name="updatePass"id = "updatePass"></li>
          <li class="list-group-item">Employee Id: ${user.empId}</li>
          <li class="list-group-item">Employee Role: ${responseJson.role}</li>
          <button name = "updateBtn" id = "updateBtn" onClick = "updateEmployee()">Update my info</button>
        </ul>
        </form>
      </div>`
      document.getElementById("content").innerHTML = content;
      document.getElementById("empUserNameUpdate").setAttribute('value',user.empUserName);
       document.getElementById("empFirstNameUpdate").setAttribute('value',user.empFirstName);
       document.getElementById("empLastNameUpdate").setAttribute('value',user.empLastName);
       

    }).catch(error => console.log(error));
    
    
    }

}
function logoutEmp(){
    sessionStorage.setItem("currUser", null);

    window.location.replace("Login.html")

}
function updateEmployee(){
    let user = JSON.parse(sessionStorage.getItem('currUser'));
    let username= document.getElementById("empUserNameUpdate").value;
    let first= document.getElementById("empFirstNameUpdate").value;
    let last= document.getElementById("empLastNameUpdate").value;
    let currPass= document.getElementById("updatePass").value;
   
    let empUpdate = {
        empFirstName: first,
        empId : user.empId,
        empLastName: last,
        empPassword: user.empPassword,
        empRoleId: user.empRoleId,
        empUserName: username
    }
    fetch(`http://localhost:8082/empUpdate/${currPass}`, {
        method: 'put',
        body: JSON.stringify(empUpdate) 
    })
    .then(response => response.json()).then(responseJson=>{
        sessionStorage.setItem("currUser", JSON.stringify(responseJson));

    }).catch(error => console.log(error));
}
function login(){
    let username= document.getElementById("username").value;
    let password=  document.getElementById("password").value;
    
 fetch(`http://localhost:8082/login/${username}/${password}`, {method:"post"}).then( response=>response.json()).then(responseJson=>{
    
if(responseJson.localizedMessage === "invalid username or password"){
    content = `<div><p>${responseJson.localizedMessage}</p></div>`
}else{
    sessionStorage.setItem("currUser", JSON.stringify(responseJson));
}
let user = JSON.parse(sessionStorage.getItem('currUser'));
console.log(user.role)
if (user.empRoleId === 1){
    window.location.replace("ManagerHome.html")
}else{
    window.location.replace("EmployeeHome.html")
}

 }).catch(error => console.log(error)); 
}