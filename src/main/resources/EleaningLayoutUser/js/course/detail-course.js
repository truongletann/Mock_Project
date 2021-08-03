
let UrlParam = new URLSearchParams(window.location.search);
let id = UrlParam.get("id");
let userID = document.getElementById('userID').value;

function loadCourseDetail() {
  axios({
    url: `http://localhost:8082/api/user/course-detail/by-course/${id}`,
    method: "get",
  })
    .then(function (resp) {
      let listCourseDetail = resp.data;
      let content = ``;
      for (let courseDetail of listCourseDetail) {
        content += `
                <li>
                <a class="video-btn"  data-toggle="modal" data-src="https://www.youtube.com/embed/${courseDetail.url}" data-target="#myModal">  
                    <span> <i class="fa fa-play-circle mr-1"></i>
                       ${courseDetail.title}
                    </span>
                   
                </a>
            </li> 
            `;
      }
      document.getElementById("list-content").innerHTML = content;
    })
    .catch(function (err) {
      console.log(err);
    });
}
loadCourseDetail();

function loadTarget() {
  axios({
    url: `http://localhost:8082/api/user/target/by-course/${id}`,
    method: "GET",
    // headers: {
    //     "Authorization": `Bearer ${token}`
    // }
  })
    .then(function (resp) {
      let listTarget = resp.data;
      let content = "";
      for (let target of listTarget) {
        content += `
            <li>
                                        <i class="fa fa-check"></i>
                                        <span>${target.target_title}
                                            </span>
            </li>
            `;
      }

      document.getElementById("showTarget").innerHTML = content;
    })
    .catch(function (err) {
      console.log(err);
    });
}
loadTarget();

function loadCourse() {
  axios({
    url: `http://localhost:8082/api/user/course/${id}`,
    method: "GET",
    // headers: {
    //     "Authorization": `Bearer ${token}`
    // }
  })
    .then((resp) => {
      // console.log(resp.data);
      document.getElementById("titleCourse").innerHTML = `
        <div class="container">
            <div class="banner-content">
                <h1>${resp.data.title}</h1>
               
                <h6 class = "mt-3">
                <span><i class="fa fa-user m-1"></i> Created by </span>
                <span class = "mr-3">${resp.data.full_name}</span>
                <span> <i class="fa fa-calendar-check-o mr-1"></i>Last updated ${resp.data.last_update}</span>
                </h6>
        </div>
        </div>        
        `;
      document.getElementById("showDescription").innerHTML = `
                   ${resp.data.description}
        `;
    })
    .catch((err) => {
      console.log(err);
    });
}
loadCourse();



function loadButtonADD() {
  axios({
    url: `http://localhost:8082/api/user/userEnroll/check/${userID}/${id}`,
    method: "GET",
    // headers: {
    //     "Authorization": `Bearer ${token}`
    // }
  })

    .then((resp) => {
      console.log(resp.data.length)
      if (resp.data.length == 0){
        document.getElementById("button-addCourse").innerHTML = `
            <div class="course-buy">
                <h2 class="mb-4 font-weight-bold" >
                    FREE
                </h2>
                <button class="btn btn-danger w-100" type="button" onclick="addUserEnroll()">Add your course</button>
            </div>  
        `;

      }else{
        document.getElementById("button-addCourse").innerHTML = `
            <div class="course-buy">
                <h2 class="mb-4 font-weight-bold" >
                    FREE
                </h2>
                <button class="btn btn-success w-100" type="button" onclick="viewUserEnroll()" >View your course</button>
            </div> 
        `;
      }
    })
    .catch((err) => {
      console.log(err);
    });
}
loadButtonADD();

function addUserEnroll(){

  


  let userEnroll = {
    "course_id": id,
    "date_enroll": new Date().toJSON(),
    "user_id": userID

  }
  console.log(userEnroll)

  axios({
    url: `http://localhost:8082/api/user/userEnroll`,
    method: "POST",
    data: userEnroll
  })
    .then(function (resp) {
      window.location.href = `../EleaningLayoutUser/course.html?id=${userID}`;
    })
    .catch(function (err) {
      console.log(err);
    });

}


function viewUserEnroll(){
  window.location.href = `../EleaningLayoutUser/course.html?id=${userID}`;
  
  }
