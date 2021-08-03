let token = localStorage.getItem('USER_TOKEN');


function loadCourse() {
    axios({
        url: 'http://localhost:8082/api/admin/course',
        method: 'GET',
        headers: {
            "Authorization": `Bearer ${token}`
        }

    })
        .then(function (resp) {
            //  Lấy ra mảng role
            let arrCourse = resp.data;
            // Tạo danh sách thẻ option
            let strOption = "";
            for (let course of arrCourse) {
                strOption += `<option value="${course.course_id}">${course.title}</option>`;
            }
            // Truy cập tới thẻ select có id là 'roleId'
            let courseID = document.getElementById('courseID');
            // Thay thế các thẻ option cũ bằng danh sách thẻ option mới
            courseID.innerHTML = strOption;
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

function openTarget(){
    let courseID = document.getElementById("courseID").value;
    window.location.href = "../ElearningLayoutAdmin/target-list.html?id=" + courseID;
}

