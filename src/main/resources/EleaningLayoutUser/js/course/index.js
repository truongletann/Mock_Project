let UrlParam = new URLSearchParams(window.location.search);
let id = UrlParam.get("id");

function loadCourseData() {
    // LẤY TOKEN TỪ LOCALSTORAGE
    axios({
        url: 'http://localhost:8082/api/user/course',
        method: 'get',
        // headers: {
        //     "Authorization": `Bearer ${token}`
        // }
    })
    .then(function(resp) {
        let listCourse = resp.data;
        let content = '';
        for (let course of listCourse) {
            content += `
            <div class="col-md-2" >
            <div class="course">
            <img src="/static/img/${course.image}" />
            <h6 class="course-title">${course.title}</h6>
            <small class="course-content">
            ${course.description}
            </small>
            <div class="seller-label">Hot</div>
            <div class="course-overlay">
                <a href="./details.html?id=${course.course_id}">
                    <h6 class="course-title">
                    ${course.title}
                    </h6>
                    <div class="course-author">
                        <b>${course.full_name}</b>
                        <span class="mx-1"> | </span>
                        <b> ${course.category_name}</b>
                    </div>
                    <small class="course-content">
                    ${course.description}
                    </small>
                </a>
                <a href="../EleaningLayoutUser/details.html?id=${course.course_id}" class="btn btn-sm btn-danger text-white w-100">View Course</a>
            </div>
        </div>
</div>
            `;
        }
        document.getElementById('hot-course').innerHTML = content;
    })
    .catch(function(err){
        // let data = err.response.data;
        // if(data.status == 401){
        //     alert('Chưa đăng nhập!')
        // }
        // else if(data.status == 403){
        //     alert('Không có quyền truy cập!')
        // }
    })
}

loadCourseData();


function SearchCourseCategory() {
    // LẤY TOKEN TỪ LOCALSTORAGE
    axios({
        url: `http://localhost:8082/api/user/course/by-category/${id}`,
        method: 'get',
        // headers: {
        //     "Authorization": `Bearer ${token}`
        // }
    })
        .then(function(resp) {
            let listCourse = resp.data;
            let content = '';
            for (let course of listCourse) {
                content += `
            <div class="col-md-2" >
            <div class="course">
            <img src="/static/img/${course.image}" />
            <h6 class="course-title">${course.title}</h6>
            <small class="course-content">
            ${course.description}
            </small>
            <div class="seller-label">Hot</div>
            <div class="course-overlay">
                <a href="./details.html?id=${course.course_id}">
                    <h6 class="course-title">
                    ${course.title}
                    </h6>
                    <div class="course-author">
                        <b>${course.full_name}</b>
                        <span class="mx-1"> | </span>
                        <b> ${course.category_name}</b>
                    </div>
                    <small class="course-content">
                    ${course.description}
                    </small>
                </a>
                <a href="../EleaningLayoutUser/details.html?id=${course.course_id}" class="btn btn-sm btn-danger text-white w-100">View Course</a>
            </div>
        </div>
</div>
            `;
            }
            document.getElementById('hot-course').innerHTML = content;
        })
        .catch(function(err){
            // let data = err.response.data;
            // if(data.status == 401){
            //     alert('Chưa đăng nhập!')
            // }
            // else if(data.status == 403){
            //     alert('Không có quyền truy cập!')
            // }
        })
}
SearchCourseCategory();
