function login() {
    let email = document.getElementById("lgEmail").value;
    let pass = document.getElementById("lgPassword").value;


    let userLogin = {
        "email": email,
        "password": pass
    };

    axios({
        url: 'http://localhost:8082/api/admin/auth',
        method: 'POST',
        data: userLogin
    })
        .then(function(response){
            swal("Good job!", "Login SuccessFull", "success").then(function(resp){

                document.getElementById("lgEmail").value = "";
                document.getElementById("lgPassword").value = "";


                localStorage.setItem('USER_TOKEN', response.data);

                document.location.href = "../EleaningLayoutUser/index.html";
            })
        })
        .catch(function(err){
            if(err.response.status==400){
                swal("Unsuccessfull !", "Account Invalid !", "error");
            }
        })
}


function getInfo(){
    let token = localStorage.getItem('USER_TOKEN');
    axios({
        url:`http://localhost:8082/api/account`,
        method: 'get',
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
        .then(function(resp){
            document.getElementById('divSign').innerHTML =
                `
         <img src="/static/img/${resp.data.avatar}"  style="border-radius: 50%; margin-right: 10px" alt="User-Profile-Image" width="35px" height="35px">
        <div class="dropdown" style="float: right;
        margin-right: 30px;">
        <button class="btn btn-outline-info dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
           ${resp.data.full_name}
        </button>
        <div class="dropdown-menu" aria-labelledby="dropdownMenu2">
          <button class="dropdown-item" type="button"><a style="text-decoration: none; color:black;" href="../EleaningLayoutUser/profile.html?id=${resp.data.user_id}">My Profile</a></button>
          <button class="dropdown-item" type="button"><a style="text-decoration: none; color:black;" href="../EleaningLayoutUser/course.html?id=${resp.data.user_id}">My Course</a></button>
            <button class="dropdown-item" type="button" onclick="logout()">Logout</button>
        </div>
      </div>
        `
        })
        .catch(function(err){
            console.log(err)
        })
}
getInfo();


function logout() {
    // LẤY TOKEN TỪ LOCALSTORAGE
    let token = localStorage.getItem('USER_TOKEN');
    if(token != null){
        // XÓA TOKEN KHỎI LOCALSTORAGE
        localStorage.removeItem('USER_TOKEN');
        document.location.href = "../EleaningLayoutUser/index.html";
    }
}