let token = localStorage.getItem('USER_TOKEN');


let url_str = window.location.href;
let url = new URL(url_str);
let id = url.searchParams.get('id');

function loadCourse() {
    axios({
        url: `http://localhost:8082/api/admin/course/${id}`,
        method: 'get',
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
        .then(function (resp) {
            let strOption = `<option value="${resp.data.course_id}">${resp.data.title}</option>`;
            document.getElementById('courseID').innerHTML = strOption;
        })
        .catch(function (err) {
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

loadCourse();

function addCourseDetail() {
    // Lấy thông tin từ form
    let title = document.getElementById('title').value;
    let courseID = document.getElementById('courseID').value;
    let url = document.getElementById('urlVideo').value;

    let courseDetail = {
        "title": title,
        "url": url,
        "course_id": courseID
    
    }
    console.log(courseDetail);
    // Gọi api để thêm mới 
    axios({
        url: 'http://localhost:8082/api/admin/course-detail',
        method: 'POST',
        data: courseDetail,
        headers: {
            "Authorization":`Bearer ${token}`
        }
    })
    .then(function (response) { // Xử lý response trả về
        console.log(response);
        window.location.href = '../ElearningLayoutAdmin/detail-course.html?id='+ courseID;
       
    })
    .catch(function (error) { // Xử lý error trả về
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
            swal("Thông báo!", "Thêm mới thất bại!", "error");
        }

    })
}