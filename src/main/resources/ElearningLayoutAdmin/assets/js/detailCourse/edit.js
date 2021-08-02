// let token = localStorage.getItem('USER_TOKEN');
let url_str = window.location.href;
let url = new URL(url_str);
let id = url.searchParams.get('id');

function loadCourseDetail(){
    axios({
        url:`http://localhost:8082/api/admin/course-detail/${id}`,
        method:'get',
        // headers:{
        //     "Authorization":`Bearer ${token}`
        // }
    })
    .then(function(resp){
        document.getElementById('title').value = resp.data.title;
        document.getElementById('urlVideo').value = resp.data.url;
        document.getElementById('courseID').value = resp.data.course_id;

    })
    .catch(function(err){
        console.log(err)
    })
}

loadCourseDetail();


function editCourseDetail(){
    let title = document.getElementById('title');
    let url = document.getElementById('urlVideo');
    let courseID = document.getElementById('courseID');


    let courseDetail = {
        "title": title.value,
        "url": url.value,
        "course_id": courseID.value,
        "course_detail_id": id
    }

    console.log(courseDetail)

    axios({
        url:'http://localhost:8082/api/admin/course-detail',
        method:'put',
        data: courseDetail
        // headers:{
        //     "Authorization":`Bearer ${token}`
        // }
    })
    .then(function(resp){
        window.location.href = "../ElearningLayoutAdmin/detail-course.html?id=" + courseID.value;
    })
    .catch(function(err){
        console.log(err)
        swal("Unsuccessfull !", "You clicked the button!", "error")
    })
}