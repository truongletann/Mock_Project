let token = localStorage.getItem('USER_TOKEN');
let url_str = window.location.href;
let url = new URL(url_str);
let id = url.searchParams.get('id');

function loadTarget(){
    axios({
        url:`http://localhost:8082/api/admin/target/${id}`,
        method:'get',
        headers:{
            "Authorization":`Bearer ${token}`
        }
    })
    .then(function(resp){
        document.getElementById('title').value = resp.data.target_title;
        document.getElementById('courseID').value = resp.data.course_id;
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

loadTarget();


function editTarget(){
    let title = document.getElementById('title');
    let courseID = document.getElementById('courseID');


    let role = {
        "target_id": id,
        "target_title": title.value,
        "course_id":courseID.value
    }

    axios({
        url:'http://localhost:8082/api/admin/target',
        method:'put',
        data:role,
        headers:{
            "Authorization":`Bearer ${token}`
        }
    })
    .then(function(resp){
        swal("Successful !", "You clicked the button!", "success").then(resp =>{
            window.location.href = "../ElearningLayoutAdmin/target-list.html?id=" + courseID.value;
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
        }{
            swal("Unsuccessful !", "You clicked the button!", "error")
        }

    })
}

function Cancel(){
    let courseID = document.getElementById('courseID').value;
    window.location.href = '../ElearningLayoutAdmin/target-list.html?id='+ courseID;
}