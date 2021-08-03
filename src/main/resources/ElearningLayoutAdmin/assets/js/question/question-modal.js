let token = localStorage.getItem('USER_TOKEN');

function loadCourse() {
    axios({
        url: 'http://localhost:8082/api/admin/course',
        method: 'get',
        headers: {
            "Authorization": `Bearer ${token}`
        }
    })
    .then(function(resp) {
        let listCourse = resp.data;
        console.log(listCourse);
        let options ='<option disabled> Courses List  </option>';
        for (let course of listCourse) {
            options += `
            <option value="${course.course_id}">${course.title}</option>
            `;
        }
        document.getElementById('categoryId').innerHTML = options;
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

loadCourse();

function getQuestion(){
   let courseId= document.getElementById('categoryId').value;
    window.location.href = "../ElearningLayoutAdmin/question-index.html?id=" + courseId;
}