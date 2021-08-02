

function loadCourse() {
    axios({
        url: 'http://localhost:8082/api/admin/course',
        method: 'GET',

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
            console.log(err.response);
        })
}
loadCourse();

function openTarget(){
    let courseID = document.getElementById("courseID").value;
    window.location.href = "../ElearningLayoutAdmin/target-list.html?id=" + courseID;
}

