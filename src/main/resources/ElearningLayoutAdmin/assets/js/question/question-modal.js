
function loadCourse() {
    axios({
        url: 'http://localhost:8082/api/admin/course',
        method: 'get',   
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
        console.log(err)
    })
}

loadCourse();

function getQuestion(){
   let courseId= document.getElementById('categoryId').value;
    window.location.href = "../ElearningLayoutAdmin/question-index.html?id=" + courseId;
}