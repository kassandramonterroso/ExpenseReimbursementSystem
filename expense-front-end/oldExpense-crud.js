
function getAllEmployees(){ //manViewAll method
    //use fetch api to consume end points java
     fetch("http://localhost:8082/emps")
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
            for(let e of responseJson){
                employeeTableData += `<tr>
                                        <td>
                                            <a href="#" onclick="viewSpecificEmployeeRequest()">
                                                ${e.empId}
                                            </a>
                                        </td>
                                        <td>
                                            <a href="#" onclick="viewSpecificEmployeeRequest()">
                                                ${e.empFirstName}
                                            </a>                                            
                                        </td>
                                        <td>${e.empLastName}</td>
                                        <td>${e.reimbId}</td>
                                        <td>${e.reimbAmt}</td>
                                        <td>${e.status}</td>`
                                        if(e.empRoleId == 1){
                                            employeeTableData += `
                                           <td>
                                            <button 
                                                type="button" 
                                                class="btn btn-primary"
                                                onclick="ApproveRequest(${e.reimbId})"> Approve 
                                            </button>
                                            <button 
                                                type="button" 
                                                class="btn btn-danger"
                                                onclick="RejectRequest(${e.reimbId})"> Reject 
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

