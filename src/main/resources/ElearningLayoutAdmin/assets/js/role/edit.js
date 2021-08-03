let token = localStorage.getItem('USER_TOKEN');
let url_str = window.location.href;
let url = new URL(url_str);
let id = url.searchParams.get('id');

function loadRole(){
    axios({
        url:`http://localhost:8082/api/admin/role/${id}`,
        method:'get',
        headers:{
            "Authorization":`Bearer ${token}`
        }
    })
    .then(function(resp){
        document.getElementById('name').value = resp.data.role_id;
        document.getElementById('desc').value = resp.data.role_name;
    })
    .catch(function(err){
        let data = err.response.data;
        if(data.status == 401){
            document.location.href = "./login.html";
        }
        else if(data.status == 403){
            if(token != null){
                // XÓA TOKEN KHỎI LOCALSTORAGE
                localStorage.removeItem('USER_TOKEN');
                document.location.href = "./login.html";
            }
        }
    })
}

loadRole();

function editRole(){
    let desc = document.getElementById('desc');

    let role = {
        "role_name": desc.value,
        "role_id": id
    }

    axios({
        url:'http://localhost:8082/api/admin/role',
        method:'PUT',
        data:role,
        headers:{
            "Authorization":`Bearer ${token}`
        }
    })
    .then(function(resp){
        swal("successfully !", "You clicked the button!", "success").then(resp =>{
            window.location.href = '../ElearningLayoutAdmin/role-index.html';
        }) 
    })
    .catch(function(err){
        let data = err.response.data;
        if(data.status == 401){
            document.location.href = "./login.html";
        }
        else if(data.status == 403){
            if(token != null){
                // XÓA TOKEN KHỎI LOCALSTORAGE
                localStorage.removeItem('USER_TOKEN');
                document.location.href = "./login.html";
            }
        }else{
            swal("Unsuccessfully !", "You clicked the button!", "error")
        }

    })
}