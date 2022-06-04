
function getAllEmployees(){ //manViewAll method
    // document.write("Data printed on the document");
    document.getElementById("content").innerHTML = "Data printed on the document";
     console.log("Data written on console");
     //use fetch api to consume end points java
     fetch("http://localhost:8082/requests")
     .then(response => response.json())
     .then(responseJson => {
         console.log(responseJson)
         let employeeTableData = `<table class="table table-striped">
                            <thead>
                            <tr>
                                <th>Employee ID</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Reimbursement Request Id</th>
                                <th>Reimbursement Request Amount</th>
                                <th>Reimbursement Request Status</th>
                                <th>Approve/Reject</th>
                            </tr>
                            </thead>
                            <tbody>`;
            for(let emp of responseJson){
                employeeTableData += `<tr>
                                        <td>
                                            <a href="#" onclick="viewSpecificEmployeeRequest()">
                                                ${emp.empId}
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" onclick="viewSpecificEmployeeRequest()">
                                                ${emp.firstName}
                                            </a>                                            
                                        </td>
                                        <td>${emp.lastName}</td>
                                        <td>${emp.reimbId}</td>
                                        <td>${emp.reimbAmt}</td>
                                        <td>${emp.status}</td>`
                                        if(emp.empRoleId == 2){
                                            employeeTableData += `
                                           <td>
                                            <button 
                                                type="button" 
                                                class="btn btn-primary"
                                                onclick="ApproveRequest(${emp.reimbId})"> Approve 
                                            </button>
                                            <button 
                                                type="button" 
                                                class="btn btn-danger"
                                                onclick="RejectRequest(${emp.reimbId})"> Reject 
                                            </button>
                                            </td>`
                                        }
                                        employeeTableData += `</tr>`;
            }
            employeeTableData += `</tbody></table>`;
            document.getElementById("content").innerHTML = employeeTableData;
        })
     .catch(error => console.log(error));
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

function viewSpecificEmployeeRequest(){ //manViewRequest method
    fetch("http://localhost:8082/employees")
    .then(response => response.json())
    .then(responseJson => {
        console.log(responseJson)
        let employeeData = `<table class="table table-striped">
                           <thead>
                           <tr>
                               <th>Employee ID</th>
                               <th>First Name</th>
                               <th>Last Name</th>
                               <th>Reimbursement Request Id</th>
                               <th>Reimbursement Request Amount</th>
                               <th>Reimbursement Request Status</th>
                               <th>Approve/Reject</th>
                           </tr>
                           </thead>
                           <tbody>`;
                           employeeTableData += `<tr>
                                        <td>${emp.empId}</td>
                                        <td>${emp.firstName}</td>
                                        <td>${emp.lastName}</td>
                                        <td>${emp.reimbId}</td>
                                        <td>${emp.reimbAmt}</td>
                                        <td>${emp.status}</td>
                                        </tr>`;
            employeeData += `</tbody></table>`;
            document.getElementById("content").innerHTML = employeeData;
    }).catch(error => console.log(error));
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
    fetch("http://localhost:9494/employees")
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
    fetch("http://localhost:9494/employees")
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
    fetch("http://localhost:9494/employees")
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


         
      


 function loginEmp(){
    let loginForm = `<div class="container">
                        <form id = "form">
                             <div class="mb-3 mt-3">
                                <label for="user" class="form-label">Username : </label>
                                <input type="text" class="form-control" id="user" placeholder="Enter Username" name="empUserName">
                            </div>
                            <div class="mb-3 mt-3">
                                <label for="pass" class="form-label"> Password : </label>
                                <input type="text" class="form-control" id="pass" placeholder="Enter password" name="empHashedPassword">
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

function logoutEmp(){
    sessionStorage.setItem("currUser", null);

//todo make this content pretty or change it to what it needs to be
let content = `<div><p>logged out</p></div>`
document.getElementById("content").innerHTML = content;

}

function changePassword(){
    let newPassword=  document.getElementById("pass").value;
    fetch(`http://localhost:8082/changePass/${newPassword}`, {method:"post", body: JSON.stringify(session["currUser"])})
    .then( response=>response.json()).then(responseJson=>{


    }).catch(error => console.log(error));; 
}


//json data here to send document.getElementById().value
     //JSON.stringify(jsontexthere);
function login(){
    let username= document.getElementById("user").value;
    let password=  document.getElementById("pass").value;
    let content = '';
 fetch(`http://localhost:8082/login/${username}/${password}`, {method:"post"}).then( response=>response.json()).then(responseJson=>{
     console.log(responseJson.localizedMessage);
if(responseJson.localizedMessage === "invalid username or password"){
    content = `<div><p>${responseJson.localizedMessage}</p></div>`
}else{
    sessionStorage.setItem("currUser", JSON.stringify(responseJson));
    //todo make this content pretty or change it to what it needs to be
    content = `<div><p>Welcome ${responseJson.empUserName}</p></div>`
}
 
    document.getElementById("content").innerHTML = content;
 }).catch(error => console.log(error)); 
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