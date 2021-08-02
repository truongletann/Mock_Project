// let token = localStorage.getItem('USER_TOKEN');
let url_str = window.location.href;
let url = new URL(url_str);
let id = url.searchParams.get('id');

function loadTarget(){
    axios({
        url:`http://localhost:8082/api/admin/target/${id}`,
        method:'get',
        // headers:{
        //     "Authorization":`Bearer ${token}`
        // }
    })
    .then(function(resp){
        document.getElementById('title').value = resp.data.target_title;
        document.getElementById('courseID').value = resp.data.course_id;
    })
    .catch(function(err){
        console.log(err)
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
        // headers:{
        //     "Authorization":`Bearer ${token}`
        // }
    })
    .then(function(resp){
        swal("Successful !", "You clicked the button!", "success").then(resp =>{
            window.location.href = "../ElearningLayoutAdmin/target-list.html?id=" + courseID.value;
        })
       
    })
    .catch(function(err){
        console.log(err)
        swal("Unsuccessful !", "You clicked the button!", "error")
    })
}

function Cancel(){
    let courseID = document.getElementById('courseID').value;
    window.location.href = '../ElearningLayoutAdmin/target-list.html?id='+ courseID;
}