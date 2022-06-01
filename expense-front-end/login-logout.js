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
                            <div class="mb-3 mt-3" id = "empStatus">
                                <label for="pass" class="form-label"> Employee Category : </label>
                                <div class="form-check">
                                    <input type="radio" class="form-check-input" id="empRadio" name="optradio" value="employee">
                                    <label class="form-check-label" for="empRadio">Employee</label>
                                </div>
                                <div class="form-check">
                                    <input type="radio" class="form-check-input" id="manRadio" name="optradio" value="manager">
                                    <label class="form-check-label" for="manRadio">Manager</label>
                                </div>
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
session["currUser"] = null;

//todo make this content pretty or change it to what it needs to be
let content = `<div><p>logged out</p></div>`
document.getElementById("content").innerHTML = content;

}

function changePassword(){
    let newPassword=  document.getElementById("pass").value;
    fetch(`http://localhost:8082/changePass/${newPassword}`, {method:"post", body: JSON.stringify(session["currUser"])}).then( response=>response.json()).then(responseJson=>{


    }).catch(error => console.log(error));; 
}

function register(){
    
}

//json data here to send document.getElementById().value
     //JSON.stringify(jsontexthere);
function login(){
    let username= document.getElementById("user").value;
    let password=  document.getElementById("pass").value;
 fetch(`http://localhost:8082/login/${username}/${password}`, {method:"post"}).then( response=>response.json()).then(responseJson=>{
    
 console.log(responseJson.localizedMessage);
 session["currUser"] = responseJson;

 //todo make this content pretty or change it to what it needs to be
 let content = `<div><p>Welcome ${responseJson.empUserName}</p></div>`
    document.getElementById("content").innerHTML = content;
 }).catch(error => console.log(error)); 
}