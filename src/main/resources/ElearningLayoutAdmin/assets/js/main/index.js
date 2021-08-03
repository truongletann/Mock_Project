// KIỂM TRA ĐĂNG NHẬP
function checkLogin() {
    // LẤY TOKEN TỪ LOCALSTORAGE
    let token = localStorage.getItem('USER_TOKEN');
    if(token == null || token.length == 0){
        document.location.href = "./login.html";
    }
}

// ĐĂNG XUẤT
function logout() {
    // LẤY TOKEN TỪ LOCALSTORAGE
    let token = localStorage.getItem('USER_TOKEN');
    if(token != null){
        // XÓA TOKEN KHỎI LOCALSTORAGE
        localStorage.removeItem('USER_TOKEN');
        document.location.href = "./login.html";
    }
}

checkLogin();


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
        // document.getElementById('iAvatar').src = `http://localhost:8080/img/${resp.data.avatar}`;
        document.getElementById('admin-info0').innerHTML = `
        
         <div class="dropdown-toggle" data-toggle="dropdown">
                                        <img src="/static/img/${resp.data.avatar}" class="img-radius"
                                            alt="User-Profile-Image">
                                        <span>${resp.data.full_name}</span>
                                        <i class="feather icon-chevron-down"></i>
                                    </div>
                                    <input type="hidden" id="useID" value="${resp.data.user_id}">
                                    <ul class="show-notification profile-notification dropdown-menu"
                                        data-dropdown-in="fadeIn" data-dropdown-out="fadeOut">
                                        <li>
                                            <a href="javascript:void(0)" onclick="logout()">
                                                <i class="feather icon-log-out"></i> Logout
                                            </a>
                                        </li>
                                    </ul>
            
        `;


    })
    .catch(function(err){
        console.log(err)
    })
}

getInfo();