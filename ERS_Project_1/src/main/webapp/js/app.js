window.onload = function() {
    document.getElementById('to-login').addEventListener('click', login);
    document.getElementById('to-register').addEventListener('click', configureRegister);
    //document.getElementById('to-logout').addEventListener('click', logout);
    document.getElementById('alert-msg').style.display = "none";
}

/*
    Login component

        - loadLogin()
        - configureLogin()
        - login()
*/
// async function loadLogin() {
//     console.log('in loadLogin()');
    
//     APP_VIEW.innerHTML = await fetchView('login.view');
//     DYNAMIC_CSS_LINK.href = 'css/home.css';
//     configureLogin();
// }

// function configureLogin() {
//     console.log('in configureLogin()');
//     document.getElementById('alert-msg').style.display = "none";
//     login();
// }

async function login() {
    console.log('in login()');
    let credentials = [];
    credentials.push(document.getElementById('usr').value);
    credentials.push(document.getElementById('pwd').value);

    let response = await fetch('auth', {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(credentials)
    });

    if(response.status == 200) {
        document.getElementById('alert-msg').style.display = "none";
        localStorage.setItem('jwt', response.headers.get('Authorization'));
        console.log(localStorage.getItem('jwt', response.headers.get('Authorization')));
        loadEmployeeDashboard();
    } else {
        document.getElementById('alert-msg').style.display = "block";
    }

}

//-------------------------------------------------------------------------------------

/*
    Register component

        - loadRegister()
        - configureRegister()
        - validateUsername()
        - validatePassword()
        - register()
*/

async function loadRegister() {
    console.log('in loadRegister()');
    APP_VIEW.innerHTML = await fetchView('register.view');
    DYNAMIC_CSS_LINK.href = 'css/register.css';
    configureRegister();
}

function configureRegister() {
    console.log('in configureRegister()');
    document.getElementById('register-username').addEventListener('blur', validateUsername);
    document.getElementById('register-password').addEventListener('keyup', validatePassword);
    register();
}

function validateUsername(event) {
    console.log('in validateUsername');
    console.log(event.target.value);
}

function validatePassword(event) {
    console.log('in validatePassword');
    console.log(event.target.value);
}

async function register() {
    console.log('in register()');

    let newUser = {
        id: 0,
        username: document.getElementById('register-username').value,
        password: document.getElementById('register-password').value,
        firstname: document.getElementById('register-fn').value,
        lastname: document.getElementById('register-ln').value,
        email: document.getElementById('register-email').value
    };

    let response = await fetch('users', {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newUser)
    });

    let responseBody = await response.json();
    console.log(responseBody);
}

//-------------------------------------------------------------------------------------

/*
    Dashboard component
        - loadDashboard()
 */

async function loadEmployeeDashboard() {
    console.log('in loadEmployeeDashboard()');
    APP_VIEW.innerHTML = await fetchView('employee.view');
    DYNAMIC_CSS_LINK.href = 'css/employee.css';
    configureDashboard();
};

async function configureDashboard() {
    console.log('in configureDashboard()');
    document.getElementById('to-add-reimb').addEventListener('click', newReimb);
    let response = await fetch('reimb', {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem('jwt')
        } 
    });

    if(response.status == 200) {
        let responseBody = await response.json();
        localStorage.setItem('role', response.headers.get('role'));
        console.log(responseBody);
        populateTable(responseBody);
        //aPT(responseBody);
    } 

    
}
function aPT (response){
    console.log("Inside APT with " + response);
    for(let i = 0; i < response.length; i++){
        console.log(response[i]);
        console.log(response[i].desc);
        
    }
}
function populateTable(response){
    console.log("Inside of populateTable")
    for(let i = 0; i < response.length; i++){
        let row = document.createElement('tr');
        console.log(response[i].desc);
        let d = response[i].desc;
        let resp = response[i];
        //let type = resp[i].type;
        let type = 1;
        switch(type){
            case(1):
                type = "Lodging";
                break;
            case(2):
                type="Travel";
                break;
            case(3):
                type="Food";
                break;
            case(4):
                type="Other";
                break;
        }
        if(response[i].statusId = 3){
            console.log(response[i]);
            let one = document.createElement('td');
            one.innerText = resp.reimbId;
            row.appendChild(one);

            let twp = document.createElement('td');
            twp.innerHTML = resp.amount
            row.appendChild(twp);
/*
        row.innerHTML = 
        "<td>" + "a" + resp.reimbId + "</td>"
        "<td>" + "a" +resp.amount + "</td>"
        "<td>" + "a" +d + "</td>"
        "<td>" + "a" +type + "</td>"
        "<td>" + "a" +resp.author + "</td>"
        "<td>" + "a" +resp.submitted + "</td>";
*/

        if(localStorage.getItem('role') == "admin"){
            row.innerHTML += "<td><button id=\"approve" + i + ">Approve</button></td><td><button id=\"deny" + i + ">Deny</button></td>";
        }
            document.getElementById("pending-table-body").append(row);
        } else {
            if(response[i].statusId = 1){
                let status = "Approved"
            }else if(response[i].statusId = 2){
                let status = "Denied"
            }
            row.innerHTML = 
            "<td>" + response[i].reimbId + "</td>"
            "<td>" + response[i].amount + "</td>"
            "<td>" + response[i].desc + "</td>"
            "<td>" + type + "</td>"
            "<td>" + response[i].author + "</td>"
            "<td>" + response[i].submitted + "</td>"
            "<td>" + status + "</td>"
            "<td>" + response[i].resolver + "</td>";
            document.getElementById("past-table-body").append(row);
        }
    }
}

async function newReimb() {
    console.log('in newReimb()');

    let reimbType =  document.getElementById('sel1').value;
    switch(reimbType){
        case("Lodging"):
            reimbType = 1;
            break;
        case("Food"):
            reimbType = 3;
            break;
        case("Travel"):
            reimbType = 2;
            break;
        case("Other"):
            reimbType = 4;
            break;
    }
    let newReimb = {
        
        amount: document.getElementById('amount').value,
        desc: document.getElementById('desc').value,
        typeId: reimbType
    };
    
    // POST information to servlet
    let response = await fetch('reimb', {
        method: 'POST',
        mode: 'cors',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': localStorage.getItem('jwt')
        },
        body: JSON.stringify(newReimb)
    });
    
    let responseBody = await response.json();
    console.log(responseBody);
    console.log(newReimb);
    console.log(response);

    // if(response.status == 200) {
    //     viewReim();
    // }

}

async function viewReim() {
    console.log('in viewReim');

    APP_VIEW.innerHTML = await fetchView('view-reim.view');
    DYNAMIC_CSS_LINK.href = 'css/app.css';
}
//-------------------------------------------------------------------------------------
async function fetchView(uri) {
    console.log(localStorage.getItem('jwt'));
    let response = await fetch(uri, {
        method: 'GET',
        mode: 'cors',
        headers: {
            'Authorization': localStorage.getItem('jwt')
        }
    });

    if(response.status == 401) loadLogin();
    return await response.text();
}

//-------------------------------------------------------------------------------------

const APP_VIEW = document.getElementById('app-view');
const DYNAMIC_CSS_LINK = document.getElementById('dynamic-css');