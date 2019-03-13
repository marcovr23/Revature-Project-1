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
    document.getElementById('sel1').addEventListener('click', newReimb);
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
        console.log(responseBody);
        localStorage.setItem('Table', response.headers.get('data'));
        console.log(localStorage.getItem('Table'));
    } 

    
}

async function newReimb() {
    console.log('in newReimb()');

    let newReimb = {
    
        reimbId: {},
        amount: document.getElementById('amount').value,
        resolver: 1,
        statusId: 1,
        author: {},
        desc: document.getElementById('desc').value,
        typeId: document.getElementById('sel1').value
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