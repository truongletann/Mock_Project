let url_str = window.location.href;
let url = new URL(url_str);
let id = url.searchParams.get('id');


function loadCourse() {
    axios({
        url: `http://localhost:8082/api/admin/course/${id}`,
        method: 'get',
    })
        .then(function (resp) {
            let strOption = `<option value="${resp.data.course_id}">${resp.data.title}</option>`;
            document.getElementById('courseID').innerHTML = strOption;
        })
        .catch(function (err) {
            console.log(err)
        })
}

loadCourse();


function addTarget() {
    // Lấy thông tin từ form
    let title = document.getElementById('title').value;
    let courseID = document.getElementById('courseID').value;

    let target = {
        "target_title": title,
        "course_id": courseID
    }
    // Gọi api để thêm mới 
    axios({
        url: 'http://localhost:8082/api/admin/target',
        method: 'POST',
        data: target
        // headers: {
        //     "Authorization":`Bearer ${token}`
        // }
    })
    .then(function (response) { // Xử lý response trả về
        // console.log(response);
        swal("Successfull !", "You clicked the button!", "success").then(response =>{
            window.location.href = '../ElearningLayoutAdmin/target-list.html?id='+ courseID;
        })
       
    })
    .catch(function (error) { // Xử lý error trả về
        console.log(error);
        swal("UnSuccessFul", "Add New Error", "error");
    })
}
function Cancel(){
    let courseID = document.getElementById('courseID').value;
    window.location.href = '../ElearningLayoutAdmin/target-list.html?id='+ courseID;
}